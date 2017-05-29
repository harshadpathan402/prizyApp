package com.org.prizypricer

public class Product {
	/*
	 *Barcode is primary Key (Id) in Product Table.   
	*/	
	String barcode
	String productName
	String description
	static hasMany = [prices:Price]
	

       
    static constraints = {
		barcode (nullable: false, blank: false, unique: true)
		productName (nullable: false, blank: false)
		description (nullable: false, blank: false, maxSize: 500)
	 
    }
	static mapping = {
		id column:'barcode', name:'barcode', generator:'assigned', unique:true
	}

	@Override
	public String toString() {
		return barcode 
	}	
}