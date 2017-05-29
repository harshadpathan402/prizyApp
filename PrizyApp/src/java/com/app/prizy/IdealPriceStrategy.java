package com.app.prizy;
/**
 * This class's calculate method returns Ideal price.
 * This price is calculated by taking all the prices of this product,
 * removing the 2 highest and 2 lowest, 
 * then doing an average with the rest and adding 20% to it.  
 */
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IdealPriceStrategy implements IPricing {

	@Override
	public BigDecimal calculatePrice(final List<BigDecimal> priceList) {
		BigDecimal idealPrice = BigDecimal.ZERO;
		if(null!= priceList && priceList.size() > MIN_SIZE){
			List<BigDecimal> newPriceList = new ArrayList<BigDecimal>(priceList);
			Collections.sort(newPriceList);
			newPriceList = newPriceList.subList(SKIP, newPriceList.size()-SKIP);
			idealPrice = IPricing.getAveragePrice(newPriceList).multiply(PERCENTAGE_VALUE);
		}
		return idealPrice.setScale(ROUNDING_UP_2,ROUNDING_UP_HALF);
	}
}
