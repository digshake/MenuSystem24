package menu;

public class MenuItem {
	
	//has-a's
	private String name;
	private double price;
	
	public MenuItem(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
	
	
}
