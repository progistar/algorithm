package p1068;

import java.util.ArrayList;
import java.util.Scanner;

class Node {
	int cnt;
	ArrayList<Node> children = new ArrayList<Node>();
	Node parent;
}

/**
 * 
 * Tree problem
 * 
 * The aim of this problem is to calculate the number of leaf nodes in the tree when one of node is deleted.
 * Notice that, if root has no children, then the root will be either root and leaf.
 * 
 * 
 * @author progi
 *
 */
public class Main {

	public static int targetNode = 0;
	public static int rootIndex = 0;
	public static void main(String[] args) {
		Node[] tree = readInput();
		postorder(tree[rootIndex]);
		
		int cnt = tree[rootIndex].cnt;
		cnt -= tree[targetNode].cnt;
		
		if(targetNode != rootIndex) {
			if(tree[targetNode].parent.children.size() == 1 ) cnt += 1;
		}
		System.out.println(cnt);
	}
	

	public static void postorder(Node node) {
		int n = node.children.size();
		if(n == 0) {
			node.cnt ++;
			return;
		}
		for(int i=0; i<n; i++) postorder(node.children.get(i));
		for(int i=0; i<n; i++) node.cnt += node.children.get(i).cnt;
	}
	
	
	// It is possible to indicate a parent before the parent node wasn't assigned.
	// So, if the parent node is null then it must be handled.
	public static Node[] readInput() {
		// Input
		Node[] tree = null;
		
		// Take some inputs
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		tree = new Node[n];
		
		for(int i=0; i<n; i++) {
			int parentIndex = scan.nextInt();
			if(tree[i] == null) tree[i] = new Node();
			if(parentIndex == -1) {
				rootIndex = i;
				continue;
			}
			if(tree[parentIndex] == null) tree[parentIndex] = new Node();
			tree[parentIndex].children.add(tree[i]);
			tree[i].parent = tree[parentIndex];
		}
		
		targetNode = scan.nextInt();
		
		scan.close();
		
		
		return tree;
	}
}
