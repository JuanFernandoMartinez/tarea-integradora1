package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RestaurantTest {

	private Restaurant restaurant;
	
	private void setup1() {
		this.restaurant = new Restaurant("Las Palmas","5554568","Robert Kingsman");
	}
	
	private void setup2() {
		
	}
	
	@Test
	void testSetName() {
		setup1();
		restaurant.setName("Candy Crush");
		assertEquals("Candy Crush", restaurant.getName());
	}
	
	
	
	@Test
	void testSetNit() {
		setup1();
		restaurant.setNit("10254687");
		assertEquals("10254687", restaurant.getNit());
	}
	
	@Test 
	void testSetAdmin(){
		setup1();
		restaurant.setAdmin("King crimson");
		assertEquals("King crimson", restaurant.getAdmin());
	}
	
	@Test
	void testRestaurant() {
		setup2();
		restaurant = new Restaurant("Delicious things", "546789", "Fredric Chopin");
		assertEquals("Delicious things", restaurant.getName());
		assertEquals("546789", restaurant.getNit());
		assertEquals("Fredric Chopin", restaurant.getAdmin());
		
	}

}
