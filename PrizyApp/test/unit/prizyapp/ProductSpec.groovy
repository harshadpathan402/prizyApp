

package prizyapp

import spock.lang.Specification;

import com.org.prizypricer.Product;

@TestFor(Product)
class ProductSpec extends Specification{
	
	void "Test that checks for nullable on barcode"(){
		
		when: 'the product barcode is nullable'
		def product1 = new Product(barcode:'123ABC', productName:'htcOne' ,description:'Good')
		
		then: 'validation should pass'
		product1.validate()
		
		when: 'the product is unique'
		def product2 = new Product( productName:'htcOne' ,description:'Good')
		
		then: 'validation should fail'
		! product2.validate()
		}
	
	
	void "Test that checks for nullable  on productName"(){
		
		when: 'the product name is nullable'
		def product1 = new Product(barcode:'123ABC', productName:'htcOne' ,description:'Good')
		
		then: 'validation should pass'
		product1.validate()
		
		when: 'the productName is null'
		def product2 = new Product(barcode:'123ABC',description:'Good')
		
		then: 'validation should fail'
		! product2.validate()
		}

	
	void "Test that checks for nullable on description "(){
		
		when: 'the product Description is not is nullable'
		def product1 = new Product(barcode:'123ABC', productName:'htcOne' ,description:'Good')
		
		then: 'validation should pass'
		product1.validate()
		
		when: 'the product description is  Null'
		def product2 = new Product(barcode:'123ABC', productName:'htcOne')
		
		then: 'validation should fail'
		! product2.validate()
		}
	
	void "Test that checks product barcode is not is blank "(){
		
		when: 'the product barcode is not is blank'
		def product1 = new Product(barcode:'123ABC', productName:'htcOne' ,description:'Good')
		
		then: 'validation should pass'
		product1.validate()
		
		when: 'the product barcode is blank'
		def product2 = new Product(barcode:'', productName:'htcOne' ,description:'Good')
		
		then: 'validation should fail'
		! product2.validate()
		}
	
	void "Test that checks product ProductName is not is blank "(){
		
		when: 'the product ProductName is not is blank'
		def product1 = new Product(barcode:'123ABC', productName:'htcOne' ,description:'Good')
		
		then: 'validation should pass'
		product1.validate()
		
		when: 'the product ProductName is blank'
		def product2 = new Product(barcode:'', productName:'' ,description:'Good')
		
		then: 'validation should fail'
		! product2.validate()
		}

	
	void "Test that checks product description is not is blank "(){
		
		when: 'the product description is not is blank'
		def product1 = new Product(barcode:'123ABC', productName:'htcOne' ,description:'Good')
		
		then: 'validation should pass'
		product1.validate()
		
		when: 'the product description is blank'
		def product2 = new Product(barcode:'', productName:'' ,description:'')
		
		then: 'validation should fail'
		! product2.validate()
		}
}
