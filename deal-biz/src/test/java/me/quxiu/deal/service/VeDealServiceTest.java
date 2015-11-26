package me.quxiu.deal.service;

import me.quxiu.share.result.ResultDO;
import me.quxiu.deal.dto.VeDealDto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author wenan.chen@quxiu.me
 * @version 2015年9月28日 下午4:18:12
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/spring-context.xml")
public class VeDealServiceTest {

	@Autowired
	VeDealService veDealService;
	
	@Autowired
	VeDealCopyService veDealCopyService;
	
	public void copyDeal(){
		VeDealDto query = new VeDealDto();
		query.setVeDealId(53310);
		query.setUserId(0);
		TestUtils.printObject(query);
		ResultDO<VeDealDto> result = veDealService.copyDeal(query);
		TestUtils.printObject(result);
	}
	
	@Test
	public void copyDealAll(){
		VeDealDto query = new VeDealDto();
		query.setVeDealId(53441);
		query.setUserId(0);
		TestUtils.printObject(query);
		ResultDO<VeDealDto> result = veDealCopyService.copyDealAll(query);
		TestUtils.printObject(result);
	}
}
