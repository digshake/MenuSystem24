package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import menu.MenuItem;
import menu.Order;

class OrderTest {
	
	private MenuItem fries, burger, soda;
	private Order o;
	
	@BeforeEach
	void setup() {
		fries = new MenuItem("Fries", 2.50);
		burger = new MenuItem("Burger", 8.00);
		soda = new MenuItem("Soda", 1.75);
		o = new Order();
	}

	@Test
	void testItemCountSimple() {
		//1. Setup objects
		o.addItem(fries);
		
		//2. Call the method being tested
		int num = o.getNumberOfItems();
		
		//3. Use assertions to verify results
		assertTrue(num == 1);
	}
	
	@Test
	void testItemCountEmpty() {
		//1. Setup objects
		
		//2. Call method being tested
		int num = o.getNumberOfItems();
		
		//3. Use assertions to verify results
		assertTrue(num == 0);
	}
	
	@Test
	void testTotalEmptyOrder() {
		//1. Setup objects
		
		//2. Call method being tested
		double sum = o.computeTotal();
		
		//3. Use assertions to verify results
		assertEquals(0.0, sum, 0.01);
	}
	
	@Test
	void testTotalOneItem() {
		//1. Setup objects
		o.addItem(fries);
		
		//2. Call method being tested
		double sum = o.computeTotal();
				
		//3. Use assertions to verify results
		assertEquals(2.50, sum, 0.01);
	}
	
	@Test
	void testTotalManyItems() {
		//1. Setup objects
		o.addItem(fries);
		o.addItem(burger);
		o.addItem(soda);
		
		//2. Call method being tested
		double sum = o.computeTotal();
				
		//3. Use assertions to verify results
		assertEquals(12.25, sum, 0.01);

	}

}
