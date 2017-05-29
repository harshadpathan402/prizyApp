package com.app.prizy;

import java.math.BigDecimal;
import java.util.List;

public interface IPricing {
	public static final Integer ROUNDING_UP_2 = Integer.valueOf(2);
	public static final Integer ROUNDING_UP_HALF = Integer.valueOf(2);
	public static final int MIN_SIZE = 5;
	public static final int SKIP = 2;
	public static final BigDecimal PERCENTAGE_VALUE=new BigDecimal(1.2);
	
	public BigDecimal calculatePrice(List<BigDecimal> priceList);
	
	public static BigDecimal getPeakPrice(List<BigDecimal> priceList){
		return priceList.get(priceList.size()-1);
	} 

	public static BigDecimal getMinPrice(List<BigDecimal> priceList){
		return priceList.get(0);
	}
	
	public static BigDecimal getAveragePrice(List<BigDecimal> priceList){
		BigDecimal average = BigDecimal.ZERO;
		for (BigDecimal price : priceList) {
			average = average.add(price);
		}
		average = average.divide(BigDecimal.valueOf(priceList.size()),ROUNDING_UP_2, ROUNDING_UP_HALF);
		return average;
	}
}
