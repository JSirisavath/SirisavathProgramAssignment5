package defaultPackage;

import java.text.DecimalFormat;

public class Order {
	private BSTNode root;  
	private String tableID;  
	private static String restaurantName; 

	
	
	
	
	// Restaurant name constructors
	public static String getRestaurantName() {
		return restaurantName;
	}


	public static void setRestaurantName(String restaurantName) {
		Order.restaurantName = restaurantName;
	}


	public Order( String tableID ) {
		this.tableID = tableID;
		this.root = null;
	}
	
	
	public void insert( MenuItem m ) {
		root = insertItem(root, m);
	}


	// Recursive method to insert menuitem into BST
	public BSTNode insertItem(BSTNode node, MenuItem m) {
		if (node == null) {
			return new BSTNode(m, null, null);
		}
		
		int comparisonResult = m.compareTo(node.getData());
		
		if (comparisonResult < 0) {
			node.setLeft(insertItem(node.getLeft(), m));
		} else if (comparisonResult > 0) {
			node.setRight(insertItem(node.getRight(),m));
		} else {
			int newQ = node.getData().getQuantity() + m.getQuantity();
			node.getData().setQuantity(newQ);
		}
		
		return node;
	}
	
	
	
	public void preorder() {
		preorderRecursive(root);
	}

	// preorder traverse
	public void preorderRecursive(BSTNode node) {
		if (node != null) {
			System.out.print(node.getData());
			preorderRecursive(node.getLeft());
			preorderRecursive(node.getRight());
			
		}
		
	}
	
	
	// in order 
	public void inorder() {
		inOrderRecursive(root);
	}


	public void inOrderRecursive(BSTNode node) {
		if (node != null) {
			inOrderRecursive(node.getLeft());
			
			System.out.print(node.getData());
			
			inOrderRecursive(node.getRight());
		}
		
	}
	
	
	
	public void postorder() {
		postorderRec(root);
	}

	// post order rec.
	public void postorderRec(BSTNode node) {
		
		if (node != null) {
		postorderRec(node.getLeft());
		
		postorderRec(node.getRight());
		
		System.out.print(node.getData());
		}
	}
	
	
	public int size() {
		return sizeRecursive(root);
	}

	
	// Size rec.
	public int sizeRecursive(BSTNode node) {
		if (node == null) {
			return 0; // empty
		} else {
			return 1 + sizeRecursive(node.getLeft()) + sizeRecursive(node.getRight());
		}
	}
	
	
	
	public int height() {
		return heightRecursive(root);
	}

	// height rec.
	public int heightRecursive(BSTNode node) {
		if (node == null) {
			return -1; // empty tree
		} else {
			int leftHeight = heightRecursive(node.getLeft());
			
			int rightHeight = heightRecursive(node.getRight());
			
			// Taking the larger of left and right subtree height. Add 1 to mover up a level from child node to current node.
			// Use math max so that we are considering the longest path of current node down to leaf. This helps determine accurately the height of tree
			return 1 + Math.max(leftHeight, rightHeight);
		}
	}
	
	
	
	
	public int getTotalQty() {
		return getTotalQtyRec(root);
	}


	// get total qty rec
	public int getTotalQtyRec(BSTNode node) {
		if (node == null) {
			return 0;
		} else {
			return node.getData().getQuantity() + getTotalQtyRec(node.getLeft()) + getTotalQtyRec(node.getRight());
		}
	}
	
	
	public MenuItem search ( String itemName ) {
		return searchMenuItemRec(root,itemName );
	}

	
	// Find the ref. to menuItem or null if not found . Find the item by name ( doesn't really work)
	public MenuItem searchMenuItemRec(BSTNode node, String itemName) {
		if (node == null) {
			return null;
		}
		
		int comparisonResult = itemName.compareToIgnoreCase(node.getData().getName());
		
		if (comparisonResult < 0) {
			return searchMenuItemRec(node.getLeft(), itemName);
		} else if (comparisonResult > 0) {
			return searchMenuItemRec(node.getRight(), itemName);
		} else {
			node.getData();
		}
		return null;
	}
	
	
	public double getTotalBeforeTaxAndTip() {
		return getTotalBeforeTaxAndTipRec(root);
	}

	
	// Total of subtree rooted at node
	public double getTotalBeforeTaxAndTipRec(BSTNode node) {
		if (node == null) {
			return 0.0;
		} else {
			double total = node.getData().getPrice() * node.getData().getQuantity();
			
			return total + getTotalBeforeTaxAndTipRec(node.getLeft()) + getTotalBeforeTaxAndTipRec(node.getRight());
		}
	}
	
	
	
	// Return amount of tip 
	public double getTip(double tipPct ) {
		double subTotalBeforeTaxAndTip = getTotalBeforeTaxAndTip();
		
		return subTotalBeforeTaxAndTip * (tipPct / 100.0);
	}
	
	
	// Return tax amount
	public double getTax(double taxPct ) {
		double subTotalBeforeTaxAndTip = getTotalBeforeTaxAndTip();
		
		return subTotalBeforeTaxAndTip * (taxPct / 100.0);
	}
	
	
	 @Override
	    public String toString() {
	        StringBuilder sb = new StringBuilder();
	        sb.append(restaurantName).append(" Table ").append(tableID).append("\n");
	        sb.append("--------------------------------------------------------------------------------\n");
	        sb.append(String.format("%-15s %10s %10s %10s\n", "Item", "Price", "Qty", "Total"));
	        sb.append("--------------------------------------------------------------------------------\n");
	        inorderToString(root, sb);
	        sb.append("--------------------------------------------------------------------------------\n");
	        double totalBeforeTaxAndTip = getTotalBeforeTaxAndTip();
	        double tax = getTax(8.0); // Use 8% tax
	        double tip = getTip(20.0); // Use 20% tip
	        double grandTotal = totalBeforeTaxAndTip + tax + tip;
	        sb.append(String.format("%-10s %10s\n", "Total:", formatCurrency(totalBeforeTaxAndTip)));
	        sb.append(String.format("%-10s %10s\n", "Tax:", formatCurrency(tax)));
	        sb.append(String.format("%-10s %10s\n", "Tip:", formatCurrency(tip)));
	        sb.append("--------------------------------------------------------------------------------\n");
	        sb.append(String.format("%-15s %10s\n", "Grand total:", formatCurrency(grandTotal)));
	        return sb.toString();
	    }

	//Recursive helper method to traverse the tree in-order and append MenuItems to the StringBuilder.  
	    private void inorderToString(BSTNode node, StringBuilder sb) {
	        if (node != null) {
	            inorderToString(node.getLeft(), sb);
	            sb.append(node.getData().toString()).append("\n");
	            inorderToString(node.getRight(), sb);
	        }
	    }


	    // Formats a double value as currency with exactly two digits after the decimal point.
	    private String formatCurrency(double amount) {
	        DecimalFormat df = new DecimalFormat("$0.00");
	        return df.format(amount);
	    }
	
}
