package com.app.prizy;

import java.math.BigDecimal;
import java.util.List;

/**
 * 
 * @author Harshad 
 *
 */
public class AveragePriceStategy implements IPricing{

	@Override
	public BigDecimal calculatePrice(List<BigDecimal> priceList) {
		return IPricing.getAveragePrice(priceList);
	}
}
