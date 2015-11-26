package me.quxiu.deal.mapper;

import java.util.List;

import me.quxiu.deal.base.BaseMapper;
import me.quxiu.deal.model.VeDealNewattr;

public interface VeDealNewattrMapper extends BaseMapper<VeDealNewattr>{
	
	List<VeDealNewattr> getNewattrByDealId(int dealId);
}