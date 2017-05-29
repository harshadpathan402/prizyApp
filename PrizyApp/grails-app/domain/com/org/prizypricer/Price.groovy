package com.org.prizypricer

import java.math.BigDecimal;


public class Price {

	String barcode
	BigDecimal price
	String storeName
	String note
	Product product
   static belongsTo =[product:Product]
   static transients = ["barcode"]
	static constraints = {
		price (nullable: false, blank: false, min: 0.0, max: 9999999.99, scale: 2)
		storeName (nullable: false, blank: false, maxSize: 25)
		note (nullable: true,maxSize: 500)
	}
	
	static mapping = {
		product index:'index_price_product_id'
	}
	@Override
	public String toString() {
		return  price ;
	}
}

