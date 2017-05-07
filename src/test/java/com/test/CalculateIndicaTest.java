
package com.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.indicator.calculate.Entry;
import com.indicator.calculate.modal.result.InputEntity;
import com.indicator.calculate.modal.result.OutputEntity;

/**
 * @author huoshan
 * created by 2017年5月4日 上午10:29:40
 * 
 */
public class CalculateIndicaTest {
	
	@Test
	public void testCalculate(){
		Entry entry = new Entry();
		List<InputEntity> inputList = new ArrayList<InputEntity>();
		
		for(int i = 0 ; i< 29 ; i++){
			InputEntity inputEntity = new InputEntity();
			inputEntity.setDate("2017-04-"+(i+1));
			inputEntity.setPrice(Math.random() * (20-1));
			
			inputList.add(inputEntity);
		}
		System.out.println(inputList);
		List<OutputEntity> calculateResult = entry.calculateIndicator(inputList);
		
		System.out.println(calculateResult);
		
	}
}
