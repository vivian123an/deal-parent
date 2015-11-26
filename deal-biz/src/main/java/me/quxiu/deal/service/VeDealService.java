package me.quxiu.deal.service;

import me.quxiu.deal.base.BaseService;
import me.quxiu.deal.dto.VeDealDto;
import me.quxiu.deal.model.VeDeal;
import me.quxiu.share.result.ResultDO;

/**
 * @author wenan.chen@quxiu.me
 * @version 2015年9月28日 下午12:05:54
 * 
 */

public interface VeDealService extends BaseService<VeDeal>{

	public ResultDO<VeDealDto> copyDeal(VeDealDto dto);
	
}
