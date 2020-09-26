package model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Calendar;

import org.junit.jupiter.api.Test;

class OrderTest {
	private Order order;

	private void setup1() {
		order = new Order("4485623","5554568");
	}
	@Test
	void testGenerateCode() {
		setup1();
		String aux = order.getCode();
		order.generateCode();
		
		assertNotEquals(aux , order.getCode());
	}
	
	@Test
	void testParseDate() {
		setup1();
		String aux;
		aux = LocalDate.now().getYear()+"";
		aux += " / ";
		aux += LocalDate.now().getMonthValue()+"";
		aux += " / ";
		aux += LocalDate.now().getDayOfMonth()+"";
		
		order.parseDate();
		
		assertEquals(aux,order.parseDate());
	}

}
