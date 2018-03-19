package p1753;

import java.util.ArrayList;
import java.util.Scanner;

class Node {
	int cost = Integer.MAX_VALUE;
	ArrayList<Node> children = new ArrayList<Node>();
	ArrayList<Integer> edgeCost = new ArrayList<Integer>();
}

public class Main {

	public static ArrayList<Node> minHeap = new ArrayList<Node>();
	public static Node[] tree = null;
	public static int sourceIndex = 0;
	
	public static void readInput() {
		Scanner scan = new Scanner(System.in);
		
		int v = scan.nextInt();
		int e = scan.nextInt();
		
		sourceIndex= scan.nextInt()-1;
		tree = new Node[v];
		for(int i=0; i<v; i++) tree[i] = new Node();
		
		for(int i=0; i<e; i++) {
			int start = scan.nextInt()-1;
			int dest = scan.nextInt()-1;
			int cost = scan.nextInt();
			
			tree[start].children.add(tree[dest]);
			tree[start].edgeCost.add(cost);
		}
		
		scan.close();
	}
	
	public static void main(String[] args) {
		readInput();
		
		// Dijkstra
		Node curNode = tree[sourceIndex];
		curNode.cost = 0;
		push(curNode);
		while(minHeap.size() != 0) {
			curNode = pop();
			for(int i=0; i<curNode.children.size(); i++) {
				int cost = curNode.cost + curNode.edgeCost.get(i);
				if(cost < curNode.children.get(i).cost) {
					curNode.children.get(i).cost = cost;
					push(curNode.children.get(i));
				}
			}
		}
		
		for(int i=0; i<tree.length; i++) {
			int cost = tree[i].cost;
			if(cost == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(cost);
				
		}
	}
	
	// Min Heap: Push operation
	public static void push(Node node) {
		minHeap.add(node);
		int curIndex = minHeap.size()-1;
		
		while(curIndex != 0) {
			int patIndex = (curIndex-1)/2;
			if(minHeap.get(curIndex).cost < minHeap.get(patIndex).cost) {
				// SWAP
				Node curNode = minHeap.get(curIndex);
				minHeap.set(curIndex, minHeap.get(patIndex));
				minHeap.set(patIndex, curNode);
			}else break;
			
			curIndex = patIndex;
		}
		
	}
	
	// Min Heap: Pop operation
	public static Node pop() {
		Node node = null;
		
		if(minHeap.size() != 0) {
			node = minHeap.get(0);
			minHeap.set(0, minHeap.get(minHeap.size()-1));
			minHeap.remove(minHeap.size()-1);
			
			int curIndex = 0;
			int maxSize = minHeap.size();
			while(curIndex*2 + 1 < maxSize) {
				int leftChild = curIndex*2 + 1;
				int rightChild = leftChild + 1;
				
				Node curNode = minHeap.get(curIndex);
				Node leftNode = minHeap.get(leftChild);
				int targetIndex = leftChild;
				
				Node rightNode = null;
				if(rightChild < maxSize) {
					rightNode = minHeap.get(rightChild);
					targetIndex = leftNode.cost > rightNode.cost ? rightChild : leftChild;
				}
				
				if(curNode.cost > minHeap.get(targetIndex).cost) {
					minHeap.set(curIndex, minHeap.get(targetIndex));
					minHeap.set(targetIndex, curNode);
				}else break;
				
				curIndex = targetIndex;
			}
		}
		
		return node;
	}
}
