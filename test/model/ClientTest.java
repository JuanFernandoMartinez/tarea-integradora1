package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClientTest {
	private Client client;
	
	private void setup1() {
		client = new Client(IdType.CC, "35535533", "Johnny", "Bravo", "3154879865", "Las Palmas");
	}
	@Test
	void testSetFirstName() {
		setup1();
		client.setFirstName("Dave");
		assertEquals("Dave",client.getFirstName());
	}
	
	void testSetId() {
		setup1();
		client.setId("1004748818");
		assertEquals("1004748818",client.getId());
	}

}
