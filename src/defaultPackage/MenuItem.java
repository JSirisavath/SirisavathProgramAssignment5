package defaultPackage;

import java.text.DecimalFormat;

public class MenuItem implements Comparable<MenuItem> {
	String name;  
	double price;  
	int quantity;  
	
	
	public MenuItem( String name, Double price, Integer quantity ) {
		this.name = name;
		
		this.price = price;
		
		this.quantity = quantity;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	@Override
   public String toString() {
	//https://stackoverflow.com/questions/5033404/how-to-use-javas-decimalformat-for-smart-currency-formatting
	   DecimalFormat decimalFormat = new DecimalFormat("'$'0.00");
	   
	   String formattedPrice = decimalFormat.format(price);
	   
	   double totalPrice = price * quantity;
	   
	   String formattedTotalPrice = decimalFormat.format(totalPrice);
	   
	   return String.format("%-15s %10s %10d %10s", name, formattedPrice, quantity, formattedTotalPrice);
   }
	
	
   public boolean equals( MenuItem m ) {
	   	// Check if this menu item is equal to passed in menu item name case insensitive. Return true if so
	   return this.name.equalsIgnoreCase(m.name); // Truthy or falsy return
   }


@Override
public int compareTo(MenuItem m) {
	// Will return a negative, 0, or positive number of this menu name is less than, greater, or equal to passed in menu item name
	return this.name.compareToIgnoreCase(m.name);
}
	
}
