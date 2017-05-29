package com.prizy.app

import com.org.prizypricer.Product;

interface PriceService {

	def getIdealPrice (Product productInstance,final String fomula);
}
