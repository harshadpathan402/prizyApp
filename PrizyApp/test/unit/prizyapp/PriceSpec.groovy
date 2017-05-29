


package prizyapp

import spock.lang.Specification;

import com.org.prizypricer.Price;
import com.org.prizypricer.Product

@TestFor(Price)
public class PriceSpec extends Specification{
	
	Product productInstance = productInstance = new Product(barcode:'123ABC', productName:'htcOne' ,description:'Good')

	/**
	 * Test for Nullables
	 */
	void "Test that checks for nullable on price"(){
		
		
		when: 'the productPrice barcode is not null'
		def productPrice1 = new Price(barcode:'123ABC',price:'1234' ,storeName:'Mobile Store' ,note:'ABCDEF',product:productInstance);
		
		then: 'validation should pass'
		productPrice1.validate()
		
		
		when: 'the product Price  is Null'
		
		def productPrice2 = new Price(barcode:'123ABC',storeName:'Mobile Store' ,note:'ABCDEF',product:productInstance);
		
		then: 'validation should fail'
		! productPrice2.validate()
		}
	
	void "Test that checks for nullable on storeName"(){
		
		
		when: 'the storeName is not null'
		def productPrice1 = new Price(barcode:'123ABC',price:'1234' ,storeName:'Mobile Store' ,note:'ABCDEF',product:productInstance);
		
		then: 'validation should pass'
		productPrice1.validate()
		
		
		when: 'the product storeName  is Null'
		
		def productPrice2 = new Price(barcode:'123ABC',note:'ABCDEF',product:productInstance);
		
		then: 'validation should fail'
		! productPrice2.validate()
		}
	

	void "Test that checks for nullable on note"(){
		
		
		when: 'the note is not null'
		def productPrice1 = new Price(barcode:'123ABC',price:'1234' ,storeName:'Mobile Store' ,note:'ABCDEF',product:productInstance);
		
		then: 'validation should pass'
		productPrice1.validate()

		when: 'the product note  is Null'
		
		def productPrice2 = new Price(barcode:'123ABC',price:'1234',product:productInstance);
		
		then: 'validation should fail'
		! productPrice2.validate()
		}
	
	
	/**
	 * Test for Blank
	 */
	void "Test that checks for blank on price"(){
		
		
		when: 'the price is not blank'
		def productPrice1 = new Price(barcode:'123ABC',price:'1234' ,storeName:'Mobile Store' ,note:'ABCDEF',product:productInstance);
		
		then: 'validation should pass'
		productPrice1.validate()

		when: 'the product blank  is Null'
		
		def productPrice2 = new Price(barcode:'123ABC',price:'',storeName:'Mobile Store',product:productInstance);
		
		then: 'validation should fail'
		! productPrice2.validate()
		}
	
	void "Test that checks for blank on storeName"(){
		
		when: 'the storeName is not blank'
		def productPrice1 = new Price(barcode:'123ABC',price:'1234' ,storeName:'Mobile Store' ,note:'ABCDEF',product:productInstance);
		
		then: 'validation should pass'
		productPrice1.validate()

		when: 'the storeName blank  is blank'
		
		def productPrice2 = new Price(barcode:'123ABC',price:'1234',storeName:'',product:productInstance);
		
		then: 'validation should fail'
		! productPrice2.validate()
		}
	
	
	void "Test that checks for blank on note. Here note is not compulsory field here"(){
		
		
		when: 'the storeName is not blank'
		def productPrice1 = new Price(barcode:'123ABC',price:'1234' ,storeName:'Mobile Store' ,note:'ABCDEF',product:productInstance);
		
		then: 'validation should pass'
		productPrice1.validate()

		when: 'the note is blank'
		
		def productPrice2 = new Price(barcode:'123ABC',price:'1234',storeName:'Mobile Store',note:'',product:productInstance);
		
		then: 'validation should fail'
		productPrice2.validate()
		}
	
	/**
	 * Test for min
	 */
	void "Test that checks for min price"(){
		
		
		when: 'when Price is minimum'
		def productPrice1 = new Price(barcode:'123ABC',price:0.0 ,storeName:'Mobile Store' ,note:'ABCDEF',product:productInstance);
		
		then: 'validation should pass'
		productPrice1.validate()

	}
	
	/**
	 * Test for max Price
	 */
	void "Test that checks for max price"(){
		
		
		when: 'when Price is max'
		def productPrice1 = new Price(barcode:'123ABC',price:9999999.99 ,storeName:'Mobile Store' ,note:'ABCDEF',product:productInstance);
		
		then: 'validation should pass'
		productPrice1.validate()
		
		when: 'when Price is above max'
		def productPrice2 = new Price(barcode:'123ABC',price:19999999.99 ,storeName:'Mobile Store' ,note:'ABCDEF',product:productInstance);
		
		then: 'validation should fail'
		! productPrice2.validate()

	}

	/**
	 * Test for negative value
	 */
	
	void "Test that checks for nigative value "(){
		
		when: 'when Price is minimum'
		def productPrice1 = new Price(barcode:'123ABC',price:0.0 ,storeName:'Mobile Store' ,note:'ABCDEF',product:productInstance);
		
		then: 'validation should pass'
		productPrice1.validate()
	}
	
}
