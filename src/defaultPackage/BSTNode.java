package defaultPackage;

public class BSTNode {
	MenuItem data;
	BSTNode left;
	BSTNode right;

	
	public BSTNode( MenuItem m, BSTNode l, BSTNode r ) {
		this.data = m;
		this.left = l;
		this.right = r;
	}


	public MenuItem getData() {
		return data;
	}


	public void setData(MenuItem data) {
		this.data = data;
	}


	public BSTNode getLeft() {
		return left;
	}


	public void setLeft(BSTNode left) {
		this.left = left;
	}


	public BSTNode getRight() {
		return right;
	}


	public void setRight(BSTNode right) {
		this.right = right;
	}
	
	
}
