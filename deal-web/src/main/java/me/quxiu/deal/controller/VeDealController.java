package me.quxiu.deal.controller;

import javax.annotation.Resource;

import me.quxiu.deal.dto.VeDealDto;
import me.quxiu.deal.service.VeDealCopyService;
import me.quxiu.deal.service.VeDealService;
import me.quxiu.share.result.ResultDO;
import me.quxiu.share.result.ResultSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wenan.chen@quxiu.me
 * @version 2015年9月28日 下午3:36:52
 * 
 */

@Controller
@RequestMapping("/utils")
@ResponseBody
public class VeDealController {

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource
	VeDealService veDealService;
	@Resource
	VeDealCopyService veDealCopyService;
	
	@RequestMapping("/dealCopy")
	public ResultDO<VeDealDto> copyDeal(VeDealDto dto){
		ResultDO<VeDealDto> result = new ResultSupport<VeDealDto>();
		
		if(dto.getUserId()==null){
			result.setSuccess(false);
			result.setModel(dto);
			result.setMessage("userId不能为空");
			return result;
		}
		if(dto.getVeDealId()==null){
			result.setSuccess(false);
			result.setModel(dto);
			result.setMessage("veDealId不能为空");
			return result;
		}
		
		try {
			return veDealCopyService.copyDealAll(dto);
		}  catch (Exception e) {
			logger.error("ve_deal记录拷贝失败："+e.getMessage());
			result.setSuccess(false);
			result.setMessage("商品拷贝出错,veDealId:"+dto.getVeDealId()+e.getMessage());
		}
		
		return result;
	}
}
