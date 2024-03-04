package menu;

import java.util.LinkedList;
import java.util.List;

public class Order {
	
	private final double TAX_RATE = 0.1;

	//instance variables
	private List<MenuItem> items;
	
	public Order() {
		items = new LinkedList<>();
	}
	
	public void addItem(MenuItem i) {
		items.add(i);
	}
	
	public int getNumberOfItems() {
		return items.size();
	}
	
	public double computeSubtotal() {
		double sum = 0;
		for(MenuItem mi : items) {
			sum += mi.getPrice();
		}
		return sum;
	}
	
	public double computeTax() {
		return computeSubtotal() * TAX_RATE;
	}
	
	public double computeGrandTotal() {
		return computeSubtotal() + computeTax();
	}
	
	public void removeItem(MenuItem mi) {
		items.remove(mi);
	}
	
	public static void main(String[] args) {
		System.out.println("Hello!");
	}
}
