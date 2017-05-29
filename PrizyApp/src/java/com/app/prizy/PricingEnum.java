package com.app.prizy;

public enum PricingEnum {

	IDEAL_PRICE("com.app.prizy.IdealPriceStrategy"),SIMPLE_PRICE("com.app.prizy.AveragePriceStategy")
	,STANDERED_PRICE("com.app.prizy.StandardPrice");

	private String value;
	
	private PricingEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
}
