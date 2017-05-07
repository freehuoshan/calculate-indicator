package com.indicator.calculate.modal;

import java.util.ArrayList;
import java.util.List;

public class TEMA {

	private List<Double> prices = new ArrayList<Double>();
	private int periods;
	public double[] ma;
	
    public TEMA(List<Double> prices, int periods) {
        this.prices = prices;
        this.periods = periods;
        ma = new double[prices.size()];
        calc();
    }

    public double[] calc() {
       int size = prices.size();
        if(periods>size) {
            for (int i=0;i<size;i++)
                ma[i] = 0.0;   
        } else {      
            EMA ema  = new EMA(prices,periods);
            List<Double> mas = new ArrayList<Double>();
            for(double ma : ema.ma){
            	mas.add(ma);
            }
            List<Double> mas1 = new ArrayList<Double>();
            for(double ma1 : new EMA(mas,periods).ma){
            	mas1.add(ma1);
            }
            for (int i=periods;i<size;i++){
                ma[i] = (3 * ema.ma[i]) - (3 * new EMA(mas,periods).ma[i]) + new EMA(mas1,periods).ma[i];
            }
        
        }
        
        return ma;
    }
}
