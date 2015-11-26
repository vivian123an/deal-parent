package me.quxiu.deal.service.impl;

import java.util.ArrayList;
import java.util.Collection;
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
import me.quxiu.deal.service.VeDealCopyService;
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
 * @author wenan.chen@quxiu.me
 * @version 2015年10月10日 下午5:26:45
 * 
 */
@Service("veDealCopyService")
@Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
public class VeDealCopyServiceImpl extends BaseServiceImpl<VeDeal> implements VeDealCopyService{
	
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
	public ResultDO<VeDealDto> copyDealAll(VeDealDto dto) {
		ResultDO<VeDealDto> result = new ResultSupport<VeDealDto>();
		
		VeDeal dealEntity = veDealMapper.get(dto.getVeDealId());
		if(dto.getVeDealId()==null || dealEntity==null){
			result.setSuccess(false);
			result.setMessage("被复制的数据空,veDealId:"+dto.getVeDealId());
			return result;
		}
		
		List<String> copyDealIdList = new ArrayList<String>();
		
		//复制VeDeal
		VeDeal copyDeal = new VeDeal();
		copyVeDealProperty(dealEntity, copyDeal);
		veDealMapper.save(copyDeal);
		copyDealIdList.add(copyDeal.getId().toString());
		dto.setNewDealIdList(copyDealIdList);
		
		VeDealColor colorEntity = veDealColorMapper.getDealColorByDealId(dto.getVeDealId());
		if(colorEntity!=null){
			//复制VeDealColor
			VeDealColor copyColor = new VeDealColor();
			BeanUtils.copyProperties(colorEntity, copyColor);
			copyColor.setMid(copyDeal.getId());
			veDealColorMapper.save(copyColor);
			
			//复制veDealGallery
			doCopyDealGallery(dto.getVeDealId(), copyDeal);
			
			//复制veProCates
			doCopyProCates(dto.getVeDealId(), copyDeal);
			
			//复制ve_prop_goods
			doCopyPropGoods(dto.getVeDealId(), copyDeal);
			
			//复制VeDealNewattr记录
			doCopyDealNewattr(dto.getVeDealId(), copyDeal);
		}
		
		//复制通过ve_deal_color关联的ve_deal
		if(colorEntity!=null && StringUtils.isNotBlank(colorEntity.getRelid())){
			for(String dealId:colorEntity.getRelid().split(",")){
				//复制关联的VeDeal
				VeDeal dealItem = veDealMapper.get(Integer.valueOf(dealId));
				VeDeal copyDealItem = new VeDeal();
				copyVeDealProperty(dealItem, copyDealItem);
				veDealMapper.save(copyDealItem);
				copyDealIdList.add(copyDealItem.getId().toString());
				
				//复制关联的VeDealColor
				VeDealColor colorOther = veDealColorMapper.getDealColorByDealId(Integer.valueOf(dealId));
				if(colorOther != null){
					VeDealColor copyColorItem = new VeDealColor();
					BeanUtils.copyProperties(colorOther, copyColorItem);
					copyColorItem.setMid(copyDealItem.getId());
					veDealColorMapper.save(copyColorItem);
				}
				
				//复制veDealGallery
				doCopyDealGallery(dealItem.getId(), copyDealItem);
				
				//复制veProCates
				doCopyProCates(dealItem.getId(), copyDealItem);
				
				//复制ve_prop_goods
				doCopyPropGoods(dealItem.getId(), copyDealItem);
				
				//复制VeDealNewattr记录
				doCopyDealNewattr(dealItem.getId(), copyDealItem);
			}
		}
		
		
		//修改ve_deal_color中的rel_id字段
		for(String dealId:copyDealIdList){
			VeDealColor colorItem = veDealColorMapper.getDealColorByDealId(Integer.valueOf(dealId));
			if(colorItem != null){
				List<String> removeList = new ArrayList<String>();
				removeList.add(dealId);
				@SuppressWarnings("unchecked")
				Collection<String> relIdList = CollectionUtils.subtract(copyDealIdList, removeList);
				String newRelIds = relIdList.toString();
				newRelIds = newRelIds.substring(1, newRelIds.length()-1).replaceAll(", ", ",");
				colorItem.setRelid(newRelIds);
				veDealColorMapper.update(colorItem);
			}
		}
		
		
		//复制veDealSnapshot
		/*List<VeDealSnapshot> snapshotList = veDealSnapshotMapper.getByGoodsId(dto.getVeDealId());
		if(CollectionUtils.isNotEmpty(snapshotList)){
			for(VeDealSnapshot snapshotEntity: snapshotList){
				VeDealSnapshot copySnapshot = new VeDealSnapshot();
				copyVeDealSnapshot(snapshotEntity, copySnapshot);
				copySnapshot.setGoodsId(copyDeal.getId());
				veDealSnapshotMapper.save(copySnapshot);
			}
		}*/
		
		result.setModel(dto);
		return result;
	}

	//复制ve_prop_goods
	private void doCopyPropGoods(Integer dealId, VeDeal copyDeal) {
		List<VePropGoods> propGoodsList = vePropGoodsMapper.getByDealId(dealId);
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
	}

	//复制veProCates
	private void doCopyProCates(Integer dealId, VeDeal copyDealItem) {
		VeProCates catesEntity = veProCatesMapper.getByDealId(dealId);
		if(catesEntity!=null){
			VeProCates copyProCates = new VeProCates();
			BeanUtils.copyProperties(catesEntity, copyProCates);
			copyProCates.setProId(copyDealItem.getId());
			veProCatesMapper.save(copyProCates);
		}
	}

	//复制veDealGallery
	private void doCopyDealGallery(Integer dealId, VeDeal copyDeal) {
		List<VeDealGallery> galleryList = veDealGalleryMapper.getByDealId(dealId);
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
	}

	//复制VeDealNewattr
	private void doCopyDealNewattr(Integer dealId, VeDeal copyDeal) {
		List<VeDealNewattr> attrs = veDealNewattrMapper.getNewattrByDealId(dealId);
		if(CollectionUtils.isNotEmpty(attrs)){
			for(int i=0;i<attrs.size();i++){
				VeDealNewattr attr = attrs.get(i);
				VeDealNewattr copyDealAttr = new VeDealNewattr();
				BeanUtils.copyProperties(attr, copyDealAttr);
				copyDealAttr.setDealId(copyDeal.getId());
				copyDealAttr.setMaterialCode(attr.getMaterialCode()+i);
				veDealNewattrMapper.save(copyDealAttr);
				
				//复制VeGoodsSku
				VeGoodsSku goodsSku = veGoodsSkuMapper.getGoodsSkuByDealNewAttrId(attr.getId());
				if(goodsSku != null){
					VeGoodsSku copySku = new VeGoodsSku();
					BeanUtils.copyProperties(goodsSku, copySku);
					copySku.setMaterialCode(goodsSku.getMaterialCode()+i);
					copySku.setGoodsId(copyDeal.getId());
					copySku.setAttrId(copyDealAttr.getId());
					veGoodsSkuMapper.save(copySku);
				}
				
				//复制VeDealStorage
				VeDealStorage storageEntity = veDealStorageMapper.getByDealIdAndAttrId(dealId, attr.getId());
				if(storageEntity!=null){
					VeDealStorage copyStorage = new VeDealStorage();
					BeanUtils.copyProperties(storageEntity, copyStorage);
					copyStorage.setDealId(copyDeal.getId());
					copyStorage.setAttrId(copyDealAttr.getId());
					veDealStorageMapper.save(copyStorage);
				}
			}
		}
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
	
	@SuppressWarnings("unused")
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
