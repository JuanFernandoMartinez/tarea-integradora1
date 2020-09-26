package model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class ManagerTest {
	private Manager manager;
	
	private void setup1() throws IOException, ClassNotFoundException{
		manager = new Manager();
	}
	@Test
	void test() throws IOException, ClassNotFoundException {
		setup1();
		manager.registerRestaurants(new Restaurant("eye Candy", "465879", "hitler"));
		
		assertEquals(1,manager.getRestaurants().size());
	}
	
	@Test
	void testRegisterClient() throws IOException, ClassNotFoundException{
		setup1();
		manager.registerClient(new Client(IdType.CC, "1005487", "Juan", "Jimenez", "3154879564", "las Palmas"));
		assertEquals(1,manager.getClients().size());
	}

}
