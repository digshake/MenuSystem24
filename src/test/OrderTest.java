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
		double sum = o.computeSubtotal();
		
		//3. Use assertions to verify results
		assertEquals(0.0, sum, 0.01);
	}
	
	@Test
	void testTotalOneItem() {
		//1. Setup objects
		o.addItem(fries);
		
		//2. Call method being tested
		double sum = o.computeSubtotal();
				
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
		double sum = o.computeSubtotal();
				
		//3. Use assertions to verify results
		assertEquals(12.25, sum, 0.01);

	}
	
	@Test
	void computeTaxSingleItemTest() {
		//1. Setup our objects
		o.addItem(fries);
		
		//2. Call method being tested
		double tax = o.computeTax();
		
		//3. Use assertions to verify results
		assertEquals(.25, tax, 0.01);
	}
	
	@Test
	void computeTaxEmptyOrder() {
		//1. Setup our objects
		
		//2. Call the method
		double tax = o.computeTax();
		
		assertEquals(0, tax, 0.01);
	}
	
	@Test
	void testComputeTaxMultipleItems() {
		//1. Setup our objects
		o.addItem(fries);
		o.addItem(burger);
		o.addItem(soda);
		
		//2. Call method being tested
		double tax = o.computeTax();
		
		//3. Use assertions to verify results
		assertEquals(1.23, tax, 0.01);
	}
	
	@Test
	void testGrandTotal() {
		//1. Setup objects
		o.addItem(fries);
		o.addItem(burger);
		o.addItem(soda);
		
		double total = o.computeGrandTotal();
		double tax = o.computeTax();
		double subtotal = o.computeSubtotal();
		
		assertEquals(13.48, total, 0.01);
		assertEquals(total, tax + subtotal, 0.01);
	}
	
	@Test
	public void testRemoveSimple() {
		o.addItem(burger);
		assertTrue(o.getNumberOfItems() == 1);
		o.removeItem(burger);
		assertTrue(o.getNumberOfItems() == 0);
		
	}
	
	@Test
	public void testRemoveMissingItem() {
		o.addItem(burger);
		assertTrue(o.getNumberOfItems() == 1);
		o.removeItem(soda);
		assertTrue(o.getNumberOfItems() == 1);
		
	}
	
	public void testRemoveItemEmptyOrder() {
		assertTrue(o.getNumberOfItems() == 0);
		o.removeItem(burger);
		assertTrue(o.getNumberOfItems() == 0);

	}
	
	
}
