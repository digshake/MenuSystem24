package menu;

import java.util.LinkedList;
import java.util.List;

public class Order {

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
	
	public double computeTotal() {
		double sum = 0;
		for(MenuItem mi : items) {
			sum += mi.getPrice();
		}
		return sum;
	}
}
