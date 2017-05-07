/**
 * author: wangxj
 * create time: 上午10:02:08
 */
package com.indicator.calculate;

import java.util.ArrayList;
import java.util.List;

import com.indicator.calculate.modal.AMA;
import com.indicator.calculate.modal.EMA;
import com.indicator.calculate.modal.MACD;
import com.indicator.calculate.modal.TEMA;
import com.indicator.calculate.modal.result.InputEntity;
import com.indicator.calculate.modal.result.OutputEntity;

/**
 * @author huoshan
 * created by 2017年5月4日 上午10:02:08
 * 
 */
public class Entry {
	
	public static final Integer periods = 1;
	public static final Integer shortPeriod = 12;
	public static final Integer longPeriod = 26;
	public static final Integer midPeriod = 9;
	
	public List<OutputEntity> calculateIndicator(List<InputEntity> inputList){
		
		List<String> dateList = new ArrayList<String>();
		List<Double> priceList = new ArrayList<Double>();
		
		for (InputEntity inputEntity : inputList) {
			dateList.add(inputEntity.getDate());
			priceList.add(inputEntity.getPrice());
		}
		double[] emaArr = calculateEMA(priceList);
		double[] macdArr = calculateMACD(priceList);
		double[] amaArr = calculateAMA(priceList);
		double[] temaArr = calculateTEMA(priceList);
		
		List<OutputEntity> outputList = new ArrayList<OutputEntity>();
		
		for (int i = 0; i < temaArr.length; i++) {
			OutputEntity outputEntity = new OutputEntity();
			outputEntity.setDate(dateList.get(i));
			outputEntity.setEMA(emaArr[i]);
			outputEntity.setMACD(macdArr[i]);
			outputEntity.setAMA(amaArr[i]);
			outputEntity.setTEMA(temaArr[i]);
			
			outputList.add(outputEntity);
		}
		return outputList;
	}

	/**
	 * @param priceList
	 * @return
	 */
	private double[] calculateTEMA(List<Double> priceList) {
		return new TEMA(priceList, periods).ma;
	}

	/**
	 * @param priceList
	 * @return
	 */
	private double[] calculateAMA(List<Double> priceList) {
		
		return new AMA(priceList, periods).ma;
	}

	/**
	 * @param priceList
	 * @return
	 */
	private double[] calculateMACD(List<Double> priceList) {
		
		return new MACD(priceList, shortPeriod, longPeriod, midPeriod).macd;
	}

	/**
	 * @param priceList
	 * @return
	 */
	private double[] calculateEMA(List<Double> priceList) {
		 return new EMA(priceList, periods).ma;
	}

}
