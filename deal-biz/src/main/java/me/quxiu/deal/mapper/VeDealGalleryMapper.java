package me.quxiu.deal.mapper;

import java.util.List;

import me.quxiu.deal.base.BaseMapper;
import me.quxiu.deal.model.VeDealGallery;

public interface VeDealGalleryMapper extends BaseMapper<VeDealGallery>{

	public List<VeDealGallery> getByDealId(Integer dealId);
}