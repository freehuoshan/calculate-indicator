package com.indicator.calculate.modal;
import java.util.List;

public class EMA {
	
	public double[] ma;
	private List<Double> prices;
	private int periods;

    public EMA(List<Double> prices, int periods) {
    	ma = new double[prices.size()];
        this.prices = prices;
        this.periods = periods;
        calc();
    }

   
    
    /**
     * Calculate Exponential moving average
     * 
     * Formula is: EMA(current) = ( (Price(current) - EMA(prev) ) * K + EMA(prev) 
     * where K = 2 / (N+1)
     * and N = periods
     */
	public static Double getEXPMA(final List<Double> prices, final int periods) {  
		Double ema = 0.0;
		if(periods > prices.size()){
			ema = 0.0;
			return ema;
		}
		else{
			  Double k = 2.0 / (periods + 1.0);
			  for (int i = periods; i < prices.size(); i++) {  
				  ema = (prices.get(i) - prices.get(i-1)) * k + prices.get(i-1);
			  }  
			  return ema;  
		}
	}  
    
    
    public double[] calc() {
        int size = prices.size();
        if(periods>size) {
            for (int i=0;i<size;i++)
            	ma[i] = 0.0;
        } else {      
            double K = 2/((double) periods+1);
            for (int i=periods;i<size;i++){
                ma[i] = (prices.get(i) - prices.get(i-1)) * K +prices.get(i-1);
            }
        }
        return ma;
    }
}
