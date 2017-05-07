
package com.indicator.calculate.modal.result;

/**
 * @author huoshan
 * created by 2017年5月4日 上午9:57:39
 * 
 */
public class InputEntity {
	
	private String date;
	private Double price;
	
	public InputEntity() {
		super();
	}

	public InputEntity(String date, Double price) {
		super();
		this.date = date;
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "InputEntity [date=" + date + ", price=" + price + "]";
	}

	
	

}
