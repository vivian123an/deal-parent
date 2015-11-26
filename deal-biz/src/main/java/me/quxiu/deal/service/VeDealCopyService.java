package me.quxiu.deal.service;

import me.quxiu.deal.base.BaseService;
import me.quxiu.deal.dto.VeDealDto;
import me.quxiu.deal.model.VeDeal;
import me.quxiu.share.result.ResultDO;

/**
 * @author wenan.chen@quxiu.me
 * @version 2015年10月12日 上午11:21:04
 * 
 */

public interface VeDealCopyService extends BaseService<VeDeal>{

	public ResultDO<VeDealDto> copyDealAll(VeDealDto dto);
}
