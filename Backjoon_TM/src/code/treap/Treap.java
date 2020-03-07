package code.treap;

public class Treap {
	
}

class Node{
	int key;
	int priority;
	int size;

	Node left, right;
	Node(int key){
		this.key = key;
		this.priority = (int)Math.random()*10000;
		this.size = 1;
		left = null;
		right = null;
	}
	public void setLeft(Node left) {
		this.left = left;
		calSize();
	}
	public void setRight(Node right) {
		this.right = right;
		calSize();
	}
	private void calSize() {
		this.size = 1;
		if(left != null) this.size += left.size;
		if(right != null) this.size += right.size;
	}
}