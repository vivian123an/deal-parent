package me.quxiu.deal.mapper;

import me.quxiu.deal.base.BaseMapper;
import me.quxiu.deal.model.VeProCates;

public interface VeProCatesMapper extends BaseMapper<VeProCates>{
	
	public VeProCates getByDealId(Integer dealId);
}