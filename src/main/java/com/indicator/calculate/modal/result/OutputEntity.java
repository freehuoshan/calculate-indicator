
package com.indicator.calculate.modal.result;

/**
 * @author huoshan
 * created by 2017年5月4日 上午9:57:56
 * 
 */
public class OutputEntity {
	
	private String date;
	private double EMA;
	private double MACD;
	private double AMA;
	private double TEMA;
	
	public OutputEntity(String date, double eMA, double mACD, double aMA, double tEMA) {
		super();
		this.date = date;
		EMA = eMA;
		MACD = mACD;
		AMA = aMA;
		TEMA = tEMA;
	}

	public OutputEntity() {
		super();
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getEMA() {
		return EMA;
	}

	public void setEMA(double eMA) {
		EMA = eMA;
	}

	public double getMACD() {
		return MACD;
	}

	public void setMACD(double mACD) {
		MACD = mACD;
	}

	public double getAMA() {
		return AMA;
	}

	public void setAMA(double aMA) {
		AMA = aMA;
	}

	public double getTEMA() {
		return TEMA;
	}

	public void setTEMA(double tEMA) {
		TEMA = tEMA;
	}

	@Override
	public String toString() {
		return "OutputEntity [date=" + date + ", EMA=" + EMA + ", MACD=" + MACD + ", AMA=" + AMA + ", TEMA=" + TEMA
				+ "]";
	}
	
	
}
