package p1766;

import java.util.ArrayList;
import java.util.Scanner;

class Node {
	int number = 0;
	int outEdges = 0;
	ArrayList<Node> inEdges = new ArrayList<Node>();
	
	public Node(int number) {
		this.number = number;
	}
}

public class Main {

	public static void main(String[] args) {
		Node[] nodes = readInput();
		solve(nodes);
	}
	
	public static void solve(Node[] nodes) {
		int index = 1;
		int lastIndex = nodes.length;
		ArrayList<Integer> minHeap = new ArrayList<Integer>();
		
		while(index < lastIndex) {
			//push
			if(nodes[index].number != -1 && nodes[index].outEdges == 0) {
				push(minHeap, index);
				nodes[index].number = -1;
			}
			//pop and release
			Integer popIndex = pop(minHeap, index);
			while(popIndex != null) {
				System.out.print(popIndex+" ");
				
				while(!nodes[popIndex].inEdges.isEmpty()) { 	
					// visiting check
					if(--nodes[popIndex].inEdges.get(0).outEdges == 0) {
						push(minHeap, nodes[popIndex].inEdges.get(0).number);
						nodes[popIndex].inEdges.get(0).number = -1;
					}
					nodes[popIndex].inEdges.remove(0);
				}
				popIndex = pop(minHeap, index);
			}
			index++;
		}
	}
	
	
	public static void push(ArrayList<Integer> minHeap, Integer value) {
		minHeap.add(value);
		
		int index= minHeap.size()-1;
		int parentIndex = (index-1)/2;
		
		while(index != 0) {
			if(value < minHeap.get(parentIndex)) {
				minHeap.set(index, minHeap.get(parentIndex));
				minHeap.set(parentIndex, value);
				index = parentIndex;
				parentIndex = (index-1)/2;
			}else break;
		}
	}
	
	public static Integer pop(ArrayList<Integer> minHeap, int threshold) {
		if(minHeap.size() == 0) return null;
		Integer minValue = minHeap.get(0);
		if(minValue > threshold) return null;
		if(minHeap.size() == 1) {
			minHeap.remove(0);
			return minValue;
		}
			
		minHeap.set(0, minHeap.get(minHeap.size()-1));
		minHeap.remove(minHeap.size()-1);
		Integer value = minHeap.get(0);
		
		// reconstruct
		int minHeapSize = minHeap.size();
		int index = 0;
		int childIndex = index*2 + 1;
		while(childIndex < minHeapSize) {
			int bestChildIndex = childIndex;
			if(childIndex+1 < minHeapSize)
				bestChildIndex = minHeap.get(childIndex) > minHeap.get(childIndex+1) ? childIndex+1 : childIndex;
			if(value < minHeap.get(bestChildIndex)) {
				minHeap.set(index, minHeap.get(bestChildIndex));
				minHeap.set(bestChildIndex, value);
				index = bestChildIndex;
				childIndex = (index*2) + 1;
			}else break;
		}
		
		return minValue;
	}
	
	public static Node[] readInput() {
		Node[] nodes = null;
		
		Scanner scan = new Scanner(System.in);
		
		// node in 0-index will be an empty.
		nodes = new Node[scan.nextInt()+1];
		for(int i=1; i<nodes.length; i++) nodes[i] = new Node(i);
		
		int relation = scan.nextInt();
		for(int i=0; i<relation; i++) {
			int first = scan.nextInt();
			int second = scan.nextInt();
			nodes[first].inEdges.add(nodes[second]);
			nodes[second].outEdges++;
		}
		
		scan.close();
		return nodes;
	}
}
