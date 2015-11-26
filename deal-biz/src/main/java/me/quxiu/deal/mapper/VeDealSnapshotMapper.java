package me.quxiu.deal.mapper;

import java.util.List;

import me.quxiu.deal.base.BaseMapper;
import me.quxiu.deal.model.VeDealSnapshot;

public interface VeDealSnapshotMapper extends BaseMapper<VeDealSnapshot>{
	
	public List<VeDealSnapshot> getByGoodsId(Integer goodsId);
}