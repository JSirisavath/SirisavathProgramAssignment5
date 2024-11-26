package defaultPackage;

public class ResturantDriver {

	public static void main(String[] args) {
		
		  Order.setRestaurantName("Downtown Café");
		
	      Order order1 = new Order("1");
	      Order order2 = new Order("2");
	      
	      
	       MenuItem[] menuItems = new MenuItem[15];
	       
	       	menuItems[0] = new MenuItem("Pizza", 12.99, 1);
	        menuItems[1] = new MenuItem("Burger", 8.99, 2);
	        menuItems[2] = new MenuItem("Salad", 5.99, 3);
	        menuItems[3] = new MenuItem("Pasta", 10.99, 1);
	        menuItems[4] = new MenuItem("Sushi", 15.99, 2);
	        menuItems[5] = new MenuItem("Steak", 20.99, 1);
	        menuItems[6] = new MenuItem("Soup", 4.99, 2);
	        menuItems[7] = new MenuItem("Sandwich", 7.99, 1);
	        menuItems[8] = new MenuItem("Tacos", 6.99, 3);
	        menuItems[9] = new MenuItem("Nachos", 9.99, 1);
	        menuItems[10] = new MenuItem("Fries", 3.99, 2);
	        menuItems[11] = new MenuItem("Ice Cream", 4.50, 2);
	        menuItems[12] = new MenuItem("Cake", 5.50, 1);
	        menuItems[13] = new MenuItem("Coffee", 2.99, 3);
	        menuItems[14] = new MenuItem("Tea", 2.50, 1);
	        
	        
	        
	        // Order 1: Insert items in the original order
	        for (MenuItem item : menuItems) {
	            order1.insert(item);
	        }

	        // Order 2: Insert items in a different order (not alphabetical) to create a different tree
	        int[] orderToSequence = {10, 5, 14, 8, 2, 4, 12, 1, 0, 7, 3, 13, 9, 6, 11};
	        for (int index : orderToSequence) {
	            order2.insert(menuItems[index]);
	        }
	        
	        

	        // Testing methods on Order 1
	        System.out.println("Testing methods on Order 1:");
	        System.out.println("--------------------------------------------------------------------------------");

	        
	        
	        // Preorder traversal
	        System.out.println("Preorder traversal of Order 1:");
	        order1.preorder();
	        System.out.println();
	        
	        
	        

	        // Inorder traversal
	        System.out.println("Inorder traversal of Order 1:");
	        order1.inorder();
	        System.out.println();
	        
	        
	        

	        // Postorder traversal
	        System.out.println("Postorder traversal of Order 1:");
	        order1.postorder();
	        System.out.println();

	        
	        
	        // Size of the order
	        System.out.println("Size of Order 1: " + order1.size());

	        // Height of the tree
	        System.out.println("Height of Order 1: " + order1.height());

	        // Total quantity of items
	        System.out.println("Total quantity in Order 1: " + order1.getTotalQty());
	        
	        
	        

	        // Search for an item
	        String searchItemName = "Sushi";
	        MenuItem foundItem = order1.search(searchItemName);
	        if (foundItem != null) {
	            System.out.println("Search for '" + searchItemName + "' in Order 1: Found - " + foundItem);
	        } else {
	            System.out.println("Search for '" + searchItemName + "' in Order 1: Not Found");
	        }
	        
	        
	        

	        // Calculate totals
	        double totalBeforeTaxAndTip = order1.getTotalBeforeTaxAndTip();
	        double tax = order1.getTax(8.0); // 8% tax
	        double tip = order1.getTip(20.0); // 20% tip

	        System.out.printf("Total before tax and tip for Order 1: $%.2f%n", totalBeforeTaxAndTip);
	        System.out.printf("Tax for Order 1 (8%%): $%.2f%n", tax);
	        System.out.printf("Tip for Order 1 (20%%): $%.2f%n", tip);
	        System.out.println();

	        
	        
	        
	        // Print Order 1 details
	        System.out.println("Order 1 Details:");
	        System.out.println(order1);

	        
	        
	        
	        
	        // Testing methods on Order 2
	        System.out.println("Testing methods on Order 2:");
	        System.out.println("--------------------------------------------------------------------------------");

	        
	        
	        // Preorder traversal
	        System.out.println("Preorder traversal of Order 2:");
	        order2.preorder();
	        System.out.println();

	        
	        
	        
	        // Inorder traversal
	        System.out.println("Inorder traversal of Order 2:");
	        order2.inorder();
	        System.out.println();

	        
	        
	        
	        // Postorder traversal
	        System.out.println("Postorder traversal of Order 2:");
	        order2.postorder();
	        System.out.println();

	        
	        
	        
	        // Size of the order
	        System.out.println("Size of Order 2: " + order2.size());

	        
	        
	        
	        // Height of the tree
	        System.out.println("Height of Order 2: " + order2.height());

	        
	        
	        
	        // Total quantity of items
	        System.out.println("Total quantity in Order 2: " + order2.getTotalQty());

	        
	        
	        
	        // Search for an item
	        searchItemName = "Fries";
	        foundItem = order2.search(searchItemName);
	        if (foundItem != null) {
	            System.out.println("Search for '" + searchItemName + "' in Order 2: Found - " + foundItem);
	        } else {
	            System.out.println("Search for '" + searchItemName + "' in Order 2: Not Found");
	        }

	        
	        
	        
	        // Calculate totals
	        totalBeforeTaxAndTip = order2.getTotalBeforeTaxAndTip();
	        tax = order2.getTax(8.0); // 8% tax
	        tip = order2.getTip(20.0); // 20% tip

	        
	        
	        
	        System.out.printf("Total before tax and tip for Order 2: $%.2f%n", totalBeforeTaxAndTip);
	        System.out.printf("Tax for Order 2 (8%%): $%.2f%n", tax);
	        System.out.printf("Tip for Order 2 (20%%): $%.2f%n", tip);
	        System.out.println();

	        
	        
	        // Print Order 2 details
	        System.out.println("Order 2 Details:");
	        System.out.println(order2);

	}

}
