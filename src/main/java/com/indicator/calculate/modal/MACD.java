package com.indicator.calculate.modal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author huoshan
 * created by 2017年5月4日 上午8:24:56
 * 
 */
public class MACD {
	
	public double[] macd;
	private int shortPeriod;
	private int longPeriod;
	private int midPeriod;
	private List<Double> prices = new ArrayList<Double>();
	
	public MACD(List<Double> prices, int shortPeriod, int longPeriod, int midPeriod) {
		super();
		macd = new double[prices.size()];
		this.prices = prices;
		this.shortPeriod = shortPeriod;
		this.longPeriod = longPeriod;
		this.midPeriod = midPeriod;
		getMACD();
	}

	/** 
	* calculate MACD values 
	*  
	* @param list 
	*            :Price list to calculate，the first at head, the last at tail. 
	* @param shortPeriod 
	*            :the short period value. 
	* @param longPeriod 
	*            :the long period value. 
	* @param midPeriod 
	*            :the mid period value. 
	* @return 
	*/  
	public double[] getMACD() {  
	  List<Double> diffList = new ArrayList<Double>();  
	  Double shortEMA = 0.0;  
	  Double longEMA = 0.0;  
	  Double dif = 0.0;  
	  Double dea = 0.0;  
	
	  for (int i = prices.size() - 1; i >= 0; i--) {  
	      List<Double> sublist = prices.subList(0, prices.size() - i);  
	      shortEMA = EMA.getEXPMA(sublist, shortPeriod);  
	      longEMA = EMA.getEXPMA(sublist, longPeriod);  
	      dif = shortEMA - longEMA;  
	      diffList.add(dif);  
	      dea = EMA.getEXPMA(diffList, midPeriod);  
	      macd[prices.size() - i - 1] = (dif - dea) * 2;
	  }  
	  return macd;
	}  
}
