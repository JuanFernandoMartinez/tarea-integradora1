package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProductTest {
	private Product product;
	private void setup1() {
		product = new Product("123546", "pink Ice Cream", "This is a great Ice Cream", "5554568", 5000);
	}
	
	private void setup2() {
		
	}
	
	@Test
	void testSetName() {
		setup1();
		product.setName("Candy Juice");
		assertEquals("Candy Juice", product.getName());
	}
	
	@Test
	void testSetCode() {
		setup1();
		product.setCode("5487");
		assertEquals("5487", product.getCode());
	}
	
	@Test
	void testSetCost() {
		setup1();
		product.setCost(7000);
		assertEquals(7000, product.getCost());
	}
	
	 @Test
	 void testSetNit() {
		 setup1();
		 product.setNit("549876");
		 assertEquals("549876", product.getNit());
	 }
	 
	 @Test
	 void TestProduct() {
		 setup2();
		 Product aux = new Product("8067","Ice cream","no comments","4578",8000);
		 product = new Product("8067","Ice cream","no comments","4578",8000);
		 
		 assertEquals("8067", product.getCode());
		 assertEquals("Ice cream", product.getName());
		 assertEquals("no comments", product.getInfo());
		 assertEquals("4578", product.getNit());
		 assertEquals(8000, product.getCost());
	 }

}
