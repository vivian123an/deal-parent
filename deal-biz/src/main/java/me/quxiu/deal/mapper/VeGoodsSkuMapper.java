package me.quxiu.deal.mapper;

import me.quxiu.deal.base.BaseMapper;
import me.quxiu.deal.model.VeGoodsSku;

public interface VeGoodsSkuMapper extends BaseMapper<VeGoodsSku>{

	public VeGoodsSku getGoodsSkuByDealNewAttrId(Integer dealNewAttrId);
}