package forest;

import java.util.ArrayList;
import java.util.Scanner;

class Node {
	int x;
	int y;
	int radius;
	int longestDepth = 0;
	ArrayList<Node> inner = new ArrayList<Node>();
}

public class Main {
	
	public static int maxDist = 0;
	
	public static void main(String[] args) {
		int[][][] inputs = readInput();
		for(int i=0; i<inputs.length; i++) {
			maxDist = 0;
			Node root = buildTree(inputs[i]);
			postorder(root);
			System.out.println(--maxDist);
		}
	}
	
	public static Node buildTree(int[][] input) {
		Node root = new Node();
		int x = input[0][0];
		int y = input[0][1];
		int r = input[0][2];
		
		root.x = x;
		root.y = y;
		root.radius = r;
		
		for(int i=1; i<input.length; i++) {
			Node curNode = new Node();
			curNode.x = input[i][0];
			curNode.y = input[i][1];
			curNode.radius = input[i][2];
			insertNode(root, curNode);
		}
		
		return root;
	}
	
	/**
	 * Distance: It is based on the number of node given path.
	 * Longest Depth: The maximum distance from parent node to each child node.
	 * maxDist: The maximum distance from node to node.
	 * 
	 * For example,
	 * 
	 * A ----- B ----- C
	 *   ----- D ----- E ----- F
	 * 
	 * The longest depth for A is 4 (A-D-E-F).
	 * The maxDist is 6 (F-E-D-A-B-C: F to C)
	 * 
	 * Caution!
	 * In this problem, the maxDist is based on edge so (maxDist-1) is the real answer in this problem.
	 * 
	 * @param node
	 * @return
	 */
	public static int postorder(Node node) {
		int longestDepth = 0;
		int longsetIndex = 0;
		for(int i=0; i<node.inner.size(); i++) {
			int thisDepth = postorder(node.inner.get(i));
			longestDepth = Math.max(thisDepth, longestDepth);
			
			if(thisDepth == longestDepth) longsetIndex = i;
		}
		
		longestDepth++;
		node.longestDepth = longestDepth;
		maxDist = Math.max(maxDist, node.longestDepth);
		for(int i=0; i<node.inner.size(); i++) {
			if(i == longsetIndex) continue;
			maxDist = Math.max(maxDist, node.inner.get(longsetIndex).longestDepth+node.inner.get(i).longestDepth+1);
		}
		
		return longestDepth;
		
	}
	
	public static void insertNode(Node parent, Node child) {
		for(int i=0; i<parent.inner.size(); i++) {
			Node target = parent.inner.get(i);
			int diff = (int)Math.sqrt(Math.pow((target.x - child.x),2) + Math.pow((target.y - child.y),2));
			if(diff < target.radius) {
				insertNode(target, child);
				return;
			}
		}
		
		parent.inner.add(child);
	}
	
	public static int[][][] readInput() {
		int[][][] inputs = null;
		Scanner scan = new Scanner(System.in);
		int case_ = scan.nextInt();
		
		inputs = new int[case_][][];
		
		for(int i=0; i<case_; i++) {
			int nodes = scan.nextInt();
			inputs[i] = new int[nodes][3];
			for(int j=0; j<nodes; j++) {
				inputs[i][j][0] = scan.nextInt();
				inputs[i][j][1] = scan.nextInt();
				inputs[i][j][2] = scan.nextInt();
			}
		}
		
		scan.close();
		
		return inputs;
	}
	
}
