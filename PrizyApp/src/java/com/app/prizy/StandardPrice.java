package com.app.prizy;

import java.math.BigDecimal;
import java.util.List;

public class StandardPrice implements IPricing{

	@Override
	public BigDecimal calculatePrice(List<BigDecimal> priceList) {
		
	return	IPricing.getAveragePrice(priceList).multiply(PERCENTAGE_VALUE)
			.setScale(ROUNDING_UP_2, ROUNDING_UP_HALF); 	
	}

}
