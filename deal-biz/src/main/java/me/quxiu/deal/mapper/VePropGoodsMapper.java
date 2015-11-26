package me.quxiu.deal.mapper;

import java.util.List;

import me.quxiu.deal.base.BaseMapper;
import me.quxiu.deal.model.VePropGoods;

public interface VePropGoodsMapper extends BaseMapper<VePropGoods>{

	public List<VePropGoods> getByDealId(Integer dealId);
}