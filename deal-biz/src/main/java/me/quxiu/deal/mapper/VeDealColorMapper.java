package me.quxiu.deal.mapper;

import java.util.List;

import me.quxiu.deal.base.BaseMapper;
import me.quxiu.deal.model.VeDealColor;

public interface VeDealColorMapper extends BaseMapper<VeDealColor>{
    
	public VeDealColor getDealColorByDealId(Integer dealId);
	
	public List<VeDealColor> getDealColorByRelId(Integer dealId);
}