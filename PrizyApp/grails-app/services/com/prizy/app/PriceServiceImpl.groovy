package com.prizy.app

import java.applet.AppletContext;

import com.app.prizy.IPricing;
import com.app.prizy.PricingEnum;
import com.org.prizypricer.Price;
import com.org.prizypricer.Product;

class PriceServiceImpl implements PriceService{

	@Override
	public def getIdealPrice(Product productInstance, String fomula) {
		String pricingFormula = PricingEnum.valueOf(fomula).getValue();
		BigDecimal price = null;
		try {
			IPricing iPricing = (IPricing)Class.forName(pricingFormula).newInstance();
			price = iPricing.calculatePrice(productInstance.prices.price)
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return price;
	}

}
