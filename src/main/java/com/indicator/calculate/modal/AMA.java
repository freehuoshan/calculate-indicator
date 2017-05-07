package com.indicator.calculate.modal;

import java.util.ArrayList;
import java.util.List;

public class AMA{

	private List<Double> prices = new ArrayList<Double>();
	private int periods;
	public double[] ma;
	
    private int fscPeriod = 2;
    private int sscPeriod = 30;
    
    /**
     * Constructor, using default values
     * @param value
     * @param periods
     */
    public AMA(List<Double> prices, int periods) {
        this.prices = prices;
        this.periods = periods;
        ma = new double[prices.size()];
        calc();
    }

    /**
     * Constructor 2
     * @param value
     * @param periods
     * @param fscPeriod
     * @param sscPeriod
     */
    public AMA(List<Double> prices, int periods,int fscPeriod,int sscPeriod) {
    	this(prices, periods);
        this.fscPeriod = fscPeriod;
        this.sscPeriod = sscPeriod;
       
    }

    
    /**
     * Calculate Adaptive moving average
     */
    public double[] calc() {
            int size = prices.size();
        if(periods>size) {
            for (int i=0;i<size;i++)
                ma[i] = 0.0;   
        } else {      
            
            double direction  = 0;
            double volatility = 0;
            double er         = 0;
            double fastC      = 0;
            double slowC      = 0;
            double ssc        = 0;
            double c          = 0;
            
            for (int i=periods;i<size;i++){
                direction = prices.get(i) - prices.get(i-periods);
                volatility = 0;
                for (int j=i-periods+1;j<i;j++)
                    volatility += Math.abs(prices.get(j) - prices.get(j-1));
                    // Effeciency Ratio (ER) 
                    if (volatility!=0.0)
                        er = (double) direction / (double) volatility;
                    else
                        er = 0;
                    //  Fast Smoothing Constant (FastC) = 2/(p + 1)  ; where p = FSC Period
                    fastC = 2/(double) (fscPeriod+1);
                    //  Slow Smoothing Constant (SlowC) = 2/(q + 1)  ; where q = SSC Period
                    slowC = 2/(double) (sscPeriod+1);
                    //  Scaled Smoothing Constant (SSC) = ER(FastC - SlowC) + SlowC
                    ssc = er*(fastC - slowC) + slowC;
                    c = Math.pow(ssc,2);
                    if (i>periods)
                        ma[i] = prices.get(i-1) + c*(prices.get(i)-prices.get(i-1));
                    else
                        ma[i] = ma[i-1] + c*(prices.get(i)-ma[i-1]);
            } // end for
        } // end if
        return ma;
    }
} 

