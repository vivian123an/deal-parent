package me.quxiu.deal.mapper;

import me.quxiu.deal.base.BaseMapper;
import me.quxiu.deal.model.VeDealStorage;

import org.apache.ibatis.annotations.Param;

public interface VeDealStorageMapper extends BaseMapper<VeDealStorage>{

	public VeDealStorage getByDealIdAndAttrId(@Param("dealId")Integer dealId, @Param("attrId")Integer attrId);
}