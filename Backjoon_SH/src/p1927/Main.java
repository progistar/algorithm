package p1927;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * MinHeap
 * @author progi
 *
 */
public class Main {

	
	public static void main(String[] args) {
		Integer[] input = readInput();
		
		ArrayList<Integer> minHeap = new ArrayList<Integer>();
		for(int i=0; i<input.length; i++) {
			if(input[i] == 0) 
				pop(minHeap);
			else
				put(minHeap, input[i]);
		}
		
	}
	
	public static void put(ArrayList<Integer> minHeap, Integer value) {
		// Add value
		minHeap.add(value);
		
		// Construct Min Heap Structure
		int index = minHeap.size()-1;
		int parentIndex = (index-1)/2;
		
		while(index != 0) {
			// Swap
			if(value < minHeap.get(parentIndex)) {
				minHeap.set(index, minHeap.get(parentIndex));
				minHeap.set(parentIndex, value);
				index = parentIndex;
				parentIndex = (index-1)/2;
			}else break;
		}
		
	}
	
	public static void pop(ArrayList<Integer> minHeap) {
		int value = 0;
		// pop value
		if(minHeap.size() > 0) {
			value = minHeap.get(0);
			minHeap.set(0, minHeap.get(minHeap.size()-1));
			minHeap.remove(minHeap.size()-1);
		}
		
		// Reconstruct Min Heap Structure
		if(minHeap.size() > 0) {
			int parentIndex = 0;
			int leftChildIndex = parentIndex * 2 + 1;
			int rightChildIndex = leftChildIndex + 1;
			
			while(leftChildIndex < minHeap.size()) {
				int bestChildIndex = leftChildIndex;
				if(rightChildIndex < minHeap.size()) 
					bestChildIndex = minHeap.get(leftChildIndex) > minHeap.get(rightChildIndex) ? rightChildIndex : bestChildIndex;
				
				if(minHeap.get(parentIndex) > minHeap.get(bestChildIndex)) {
					int temp = minHeap.get(parentIndex);
					minHeap.set(parentIndex, minHeap.get(bestChildIndex));
					minHeap.set(bestChildIndex, temp);
					parentIndex = bestChildIndex;
					leftChildIndex = parentIndex * 2 + 1;
					rightChildIndex = leftChildIndex + 1;
				}else break;
			}
		}
		
		System.out.println(value);
	}
	
	public static Integer[] readInput() {
		Integer[] input = null;
		
		Scanner scan = new Scanner(System.in);
		
		int len = scan.nextInt();
		input = new Integer[len];
		for(int i=0; i<len; i++) input[i] = scan.nextInt();
		
		scan.close();
		
		return input;
	}
}
