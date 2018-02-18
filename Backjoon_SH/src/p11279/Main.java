package p11279;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * MaxHeap
 * @author progi
 *
 */
public class Main {

	
	public static void main(String[] args) {
		Integer[] input = readInput();
		
		ArrayList<Integer> maxHeap = new ArrayList<Integer>();
		for(int i=0; i<input.length; i++) {
			if(input[i] == 0)
				pop(maxHeap);
			else
				put(maxHeap, input[i]);
		}
		
	}
	
	public static void put(ArrayList<Integer> maxHeap, Integer value) {
		// Add value
		maxHeap.add(value);
		
		// Construct Max Heap Structure
		int index = maxHeap.size()-1;
		int parentIndex = (index-1)/2;
		
		while(index != 0) {
			// Swap
			if(value > maxHeap.get(parentIndex)) {
				maxHeap.set(index, maxHeap.get(parentIndex));
				maxHeap.set(parentIndex, value);
				index = parentIndex;
				parentIndex = (index-1)/2;
			}else break;
		}
		
	}
	
	public static void pop(ArrayList<Integer> maxHeap) {
		int value = 0;
		// pop value
		if(maxHeap.size() > 0) {
			value = maxHeap.get(0);
			maxHeap.set(0, maxHeap.get(maxHeap.size()-1));
			maxHeap.remove(maxHeap.size()-1);
		}
		
		// Reconstruct Max Heap Structure
		if(maxHeap.size() > 0) {
			int parentIndex = 0;
			int leftChildIndex = parentIndex * 2 + 1;
			int rightChildIndex = leftChildIndex + 1;
			
			while(leftChildIndex < maxHeap.size()) {
				int bestChildIndex = leftChildIndex;
				if(rightChildIndex < maxHeap.size()) 
					bestChildIndex = maxHeap.get(leftChildIndex) < maxHeap.get(rightChildIndex) ? rightChildIndex : bestChildIndex;
				
				if(maxHeap.get(parentIndex) < maxHeap.get(bestChildIndex)) {
					int temp = maxHeap.get(parentIndex);
					maxHeap.set(parentIndex, maxHeap.get(bestChildIndex));
					maxHeap.set(bestChildIndex, temp);
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
