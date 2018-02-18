package runningMedian;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int[][] inputs = readInput();
		for(int i=0; i<inputs.length; i++) System.out.println(makeHeap(inputs[i]));
		
	}
	
	public static long makeHeap(int[] input) {
		long[] maxHeap = null;
		long[] minHeap = null;
		int len = input[0];
		int a = input[1];
		int b = input[2];
		
		maxHeap = new long[len/2+1];
		minHeap = new long[len/2+1];
		
		// make heap
		/// Init
		maxHeap[0] = 1983;
		
		/// Put
		int maxIndex = 0;
		int minIndex = -1;
		long sum = 1983;
		long value = 1983;
		for(int i=1; i<len; i++) {
			value = (value*a + b) % 20090711;
			if(maxIndex <= minIndex) {
				// max
				maxHeap[++maxIndex] = value;
				putMax(maxHeap, maxIndex);
			}else {
				// min
				minHeap[++minIndex] = value;
				putMin(minHeap, minIndex);
			}
			if(minIndex != -1 && maxHeap[0] > minHeap[0]) {
				long maxValue = popMax(maxHeap, maxIndex);
				long minValue = popMin(minHeap, minIndex);
				maxHeap[maxIndex] = minValue;
				putMax(maxHeap, maxIndex);
				minHeap[minIndex] = maxValue;
				putMin(minHeap, minIndex);
			}
			sum += maxHeap[0];
		}
		
		return sum % 20090711;
	}
	
	private static void putMin(long[] minHeap, int minIndex) {
		int index = minIndex;
		while(index != 0) {
			int parentIndex = (index-1)/2;
			if(minHeap[index] < minHeap[parentIndex]) {
				long temp = minHeap[index];
				minHeap[index] = minHeap[parentIndex];
				minHeap[parentIndex] = temp;
				index = parentIndex;
			}else
				break;
		}

	}
	
	private static void putMax(long[] maxHeap, int maxIndex) {
		int index = maxIndex;
		while(index != 0) {
			int parentIndex = (index-1)/2;
			if(maxHeap[index] > maxHeap[parentIndex]) {
				long temp = maxHeap[index];
				maxHeap[index] = maxHeap[parentIndex];
				maxHeap[parentIndex] = temp;
				index = parentIndex;
			}else
				break;
		}
	}
	
	private static long popMin(long[] minHeap, int minIndex) {
		long popValue = minHeap[0];
		minHeap[0] = minHeap[minIndex--];
		
		int parentIndex = 0;
		while(parentIndex*2 + 1 <= minIndex) {
			int childLeftIndex = parentIndex*2 + 1;
			int childRightIndex = parentIndex*2 + 2;
			
			if(childRightIndex <= minIndex && (minHeap[childLeftIndex] > minHeap[childRightIndex] && minHeap[parentIndex] > minHeap[childRightIndex])) {
				long temp = minHeap[parentIndex];
				minHeap[parentIndex] = minHeap[childRightIndex];
				minHeap[childRightIndex] = temp;
				parentIndex = childRightIndex;
			}else if(childRightIndex > minIndex || (minHeap[childLeftIndex] <= minHeap[childRightIndex] && minHeap[parentIndex] > minHeap[childLeftIndex])) {
				long temp = minHeap[parentIndex];
				minHeap[parentIndex] = minHeap[childLeftIndex];
				minHeap[childLeftIndex] = temp;
				parentIndex = childLeftIndex;
			}else {
				break;
			}
		}
		
		return popValue;
	}
	
	private static long popMax(long[] maxHeap, int maxIndex) {
		long popValue = maxHeap[0];
		maxHeap[0] = maxHeap[maxIndex--];
		
		int parentIndex = 0;
		while(parentIndex*2 + 1 <= maxIndex) {
			int childLeftIndex = parentIndex*2 + 1;
			int childRightIndex = parentIndex*2 + 2;
			
			if(childRightIndex <= maxIndex && (maxHeap[childLeftIndex] < maxHeap[childRightIndex] && maxHeap[parentIndex] < maxHeap[childRightIndex])) {
				long temp = maxHeap[parentIndex];
				maxHeap[parentIndex] = maxHeap[childRightIndex];
				maxHeap[childRightIndex] = temp;
				parentIndex = childRightIndex;
			}else if(childRightIndex > maxIndex || (maxHeap[childLeftIndex] >= maxHeap[childRightIndex] && maxHeap[parentIndex] < maxHeap[childLeftIndex])) {
				long temp = maxHeap[parentIndex];
				maxHeap[parentIndex] = maxHeap[childLeftIndex];
				maxHeap[childLeftIndex] = temp;
				parentIndex = childLeftIndex;
			}else {
				break;
			}
		}
		
		return popValue;
	}
	
	public static int[][] readInput() {
		int[][] inputs = null;
		Scanner scan= new Scanner(System.in);
		
		inputs = new int[scan.nextInt()][3];
		
		for(int i=0; i<inputs.length; i++) {
			inputs[i] = new int[3];
			inputs[i][0] = scan.nextInt();
			inputs[i][1] = scan.nextInt();
			inputs[i][2] = scan.nextInt();
		}
		
		scan.close();
		return inputs;
	}
	
}
