package me.quxiu.deal.service.impl;

import java.util.ArrayList;
import java.util.List;

import me.quxiu.deal.base.impl.BaseServiceImpl;
import me.quxiu.deal.dto.VeDealDto;
import me.quxiu.deal.mapper.VeDealColorMapper;
import me.quxiu.deal.mapper.VeDealGalleryMapper;
import me.quxiu.deal.mapper.VeDealMapper;
import me.quxiu.deal.mapper.VeDealNewattrMapper;
import me.quxiu.deal.mapper.VeDealSnapshotMapper;
import me.quxiu.deal.mapper.VeDealStorageMapper;
import me.quxiu.deal.mapper.VeGoodsSkuMapper;
import me.quxiu.deal.mapper.VeProCatesMapper;
import me.quxiu.deal.mapper.VePropGoodsMapper;
import me.quxiu.deal.model.VeDeal;
import me.quxiu.deal.model.VeDealColor;
import me.quxiu.deal.model.VeDealGallery;
import me.quxiu.deal.model.VeDealNewattr;
import me.quxiu.deal.model.VeDealSnapshot;
import me.quxiu.deal.model.VeDealStorage;
import me.quxiu.deal.model.VeGoodsSku;
import me.quxiu.deal.model.VeProCates;
import me.quxiu.deal.model.VePropGoods;
import me.quxiu.deal.service.VeDealService;
import me.quxiu.share.result.ResultDO;
import me.quxiu.share.result.ResultSupport;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * 临时解决方案
 * 
 * <p>拷贝ve_deal表以及关联的
 * ve_deal_newattr
 * ve_deal_color
 * ve_goods_sku
 * ve_deal_storage,
 * ve_deal_snapshot,
 * ve_deal_gallery,
 * ve_pro_cates,
 * ve_prop_goods</p>
 * 
 * <p>生成一条新的ve_deal记录后返回主键</p>
 * 
 * @author wenan.chen@quxiu.me
 * @version 2015年9月28日 下午12:06:41
 * 
 */

@Service("veDealService")
@Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
public class VeDealServiceImpl extends BaseServiceImpl<VeDeal> implements VeDealService{

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	VeDealMapper veDealMapper;
	@Autowired
	VeDealNewattrMapper veDealNewattrMapper;
	@Autowired
	VeDealColorMapper veDealColorMapper;
	@Autowired
	VeGoodsSkuMapper veGoodsSkuMapper;
	@Autowired
	VeDealGalleryMapper veDealGalleryMapper;
	@Autowired
	VeDealSnapshotMapper veDealSnapshotMapper;
	@Autowired
	VeDealStorageMapper veDealStorageMapper;
	@Autowired
	VeProCatesMapper veProCatesMapper;
	@Autowired
	VePropGoodsMapper vePropGoodsMapper;
	
	
	@Override
	protected void initMapper() {
		mapper = veDealMapper;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED , isolation= Isolation.READ_COMMITTED ,rollbackFor = { Exception.class })
	public ResultDO<VeDealDto> copyDeal(VeDealDto dto) {
		ResultDO<VeDealDto> result = new ResultSupport<VeDealDto>();
		
		VeDeal dealEntity = veDealMapper.get(dto.getVeDealId());
		if(dto.getVeDealId()==null || dealEntity==null){
			result.setSuccess(false);
			result.setMessage("被复制的数据空,veDealId:"+dto.getVeDealId());
			return result;
		}
		
		//复制VeDeal
		VeDeal copyDeal = new VeDeal();
		copyVeDealProperty(dealEntity, copyDeal);
		veDealMapper.save(copyDeal);
		//dto.setNewDealId(copyDeal.getId());
		
		//复制VeDealNewattr记录
		List<VeDealNewattr> attrs = veDealNewattrMapper.getNewattrByDealId(dto.getVeDealId());
		if(CollectionUtils.isNotEmpty(attrs)){
			for(VeDealNewattr attr: attrs){
				VeDealNewattr copyDealAttr = new VeDealNewattr();
				BeanUtils.copyProperties(attr, copyDealAttr);
				copyDealAttr.setDealId(copyDeal.getId());
				veDealNewattrMapper.save(copyDealAttr);
				
				//复制VeGoodsSku记录
				VeGoodsSku goodsSku = veGoodsSkuMapper.getGoodsSkuByDealNewAttrId(attr.getId());
				if(goodsSku != null){
					VeGoodsSku copySku = new VeGoodsSku();
					BeanUtils.copyProperties(goodsSku, copySku);
					copySku.setGoodsId(copyDeal.getId());
					copySku.setAttrId(copyDealAttr.getId());
					veGoodsSkuMapper.save(copySku);
				}
				
				//复制VeDealStorage
				VeDealStorage storageEntity = veDealStorageMapper.getByDealIdAndAttrId(dto.getVeDealId(), attr.getId());
				if(storageEntity!=null){
					VeDealStorage copyStorage = new VeDealStorage();
					BeanUtils.copyProperties(storageEntity, copyStorage);
					copyStorage.setDealId(copyDeal.getId());
					copyStorage.setAttrId(copyDealAttr.getId());
					veDealStorageMapper.save(copyStorage);
				}
			}
		}
		
		//复制VeDealColor记录
		VeDealColor colorEntity = veDealColorMapper.getDealColorByDealId(dto.getVeDealId());
		if(colorEntity != null){
			
			if(StringUtils.isBlank(colorEntity.getRelid())){
				colorEntity.setRelid(copyDeal.getId()+"");
				veDealColorMapper.update(colorEntity);
			}else{
				colorEntity.setRelid(colorEntity.getRelid() + "," + copyDeal.getId());
				veDealColorMapper.update(colorEntity);
			}
			
			String relIdStr = dto.getVeDealId() + StringUtils.EMPTY;
			
			List<VeDealColor> colorList = veDealColorMapper.getDealColorByRelId(dto.getVeDealId());
			if(CollectionUtils.isNotEmpty(colorList)){
				for(VeDealColor existColor: colorList){
					existColor.setRelid(existColor.getRelid()+","+copyDeal.getId());
					veDealColorMapper.update(existColor);
					
					relIdStr = relIdStr +","+ existColor.getMid();//累计deal_id用【,】分隔
				}
			}
			relIdStr = relIdStr.startsWith(",")? relIdStr.substring(1):relIdStr;//处理原来dto.getVeDealId()为空的情况
			
			VeDealColor copyColor = new VeDealColor();
			BeanUtils.copyProperties(colorEntity, copyColor);
			copyColor.setMid(copyDeal.getId());
			copyColor.setRelid(relIdStr);
			veDealColorMapper.save(copyColor);
		}
		
		//复制veDealGallery
		List<VeDealGallery> galleryList = veDealGalleryMapper.getByDealId(dto.getVeDealId());
		if(CollectionUtils.isNotEmpty(galleryList)){
			List<VeDealGallery> copyGalleryList = new ArrayList<VeDealGallery>();
			for(VeDealGallery galleryEntity:galleryList){
				VeDealGallery copyGallery = new VeDealGallery(); 
				BeanUtils.copyProperties(galleryEntity, copyGallery);
				copyGallery.setDealId(copyDeal.getId());
				copyGalleryList.add(copyGallery);
			}
			veDealGalleryMapper.saveBatch(copyGalleryList);
		}
		
		//复制veDealSnapshot
		List<VeDealSnapshot> snapshotList = veDealSnapshotMapper.getByGoodsId(dto.getVeDealId());
		if(CollectionUtils.isNotEmpty(snapshotList)){
			//List<VeDealSnapshot> copySnapshotList = new ArrayList<VeDealSnapshot>();
			for(VeDealSnapshot snapshotEntity: snapshotList){
				VeDealSnapshot copySnapshot = new VeDealSnapshot();
				copyVeDealSnapshot(snapshotEntity, copySnapshot);
				copySnapshot.setGoodsId(copyDeal.getId());
				veDealSnapshotMapper.save(copySnapshot);
			}
			//veDealSnapshotMapper.saveBatch(copySnapshotList);
		}
		
		//复制veProCates
		VeProCates catesEntity = veProCatesMapper.getByDealId(dto.getVeDealId());
		if(catesEntity!=null){
			VeProCates copyProCates = new VeProCates();
			BeanUtils.copyProperties(catesEntity, copyProCates);
			copyProCates.setProId(copyDeal.getId());
			veProCatesMapper.save(copyProCates);
		}
		
		//复制ve_prop_goods
		List<VePropGoods> propGoodsList = vePropGoodsMapper.getByDealId(dto.getVeDealId());
		if(CollectionUtils.isNotEmpty(propGoodsList)){
			List<VePropGoods> copyGoodsList = new ArrayList<VePropGoods>();
			for(VePropGoods propGoods: propGoodsList){
				VePropGoods copyGoods = new VePropGoods();
				BeanUtils.copyProperties(propGoods, copyGoods);
				copyGoods.setGoodsId(copyDeal.getId());
				copyGoodsList.add(copyGoods);
			}
			vePropGoodsMapper.saveBatch(copyGoodsList);
		}
		
		result.setModel(dto);
		return result;
	}
	
	private void copyVeDealProperty(VeDeal entity, VeDeal newDeal){
		
		BeanUtils.copyProperties(entity, newDeal);
		
		newDeal.setCopyFromDealId(entity.getId());
		newDeal.setId(null);
		newDeal.setIsEffect(false);
		newDeal.setIsDelete(false);
		newDeal.setIsSale(0);//售卖状态,0未上架,1已上架,2已下架
		newDeal.setSubmitStatus(null);
		newDeal.setSubmitTime(null);
		newDeal.setStatus(3);//商品状态 0'待审核',1'审核通过',2'审核不通过',3'待提交'
		newDeal.setAuditStatus(null);//商品审核状态：0未审核；1审核通过(暂弃用)；2审核不通过
		newDeal.setAuditMsg(null);
		newDeal.setAuditTimeBak(null);
		newDeal.setAuditTime(null);
		newDeal.setAuditAdminId(null);
		newDeal.setSkuAuditAdminId(null);
		newDeal.setSkuAuditStatus(null);
		newDeal.setSkuAuditTime(null);
		newDeal.setSkuAuditMsg(null);
	}
	
	private void copyVeDealSnapshot(VeDealSnapshot entity,VeDealSnapshot copy){
		
		BeanUtils.copyProperties(entity, copy);
		
		copy.setId(null);
		copy.setTimeBegin(null);
		copy.setTimeEnd(null);
		copy.setIsEffect(false);
		copy.setIsDelete(false);
		copy.setStatus(0);//'商品提交状态：0未提交，1已提交（待审核）',
		copy.setAuditStatus(0);//'商品审核状态：0未审核；1审核通过(暂弃用)；2审核不通过',
		copy.setAuditMsg(null);
		copy.setAuditTime(null);
		copy.setAuditAdminId(null);
		copy.setAuditMsg(null);
		copy.setAuditTime(null);
		copy.setSubmitStatus(0);//'商品提交状态：0未提交，1已提交（待审核）',
		copy.setSubmitTime(null);
	}
	
}
