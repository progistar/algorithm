package p2220;

import java.util.Scanner;

/**
 * given n,
 * Give from n to 2 numbers as sequential input in the order.
 * 
 * ex>
 * n     --> maxHeap with 1 element
 * n-1   --> maxHeap with 2 elements
 * n-2   --> maxHeap with 3 elements
 * .
 * .
 * .
 * 2     --> maxHeap with n-1 elements
 * 
 * and then, just add 1 as the last element.
 * 
 * WHY is it working well?
 * 
 * @author progi
 *
 */

public class Main {

	public static void main(String[] args) {
		int[] numbers = readInput();
		int[] maxHeap = makeHeap(numbers);
		for(int i=0; i<maxHeap.length; i++) System.out.print(maxHeap[i]+" ");
	}
	
	public static int[] makeHeap(int[] numbers) {
		int[] maxHeap = new int[numbers.length];
		
		int heapSize = 0;
		for(int i=1; i<numbers.length; i++) {
			int value = numbers[i];
			maxHeap[heapSize++] = value;
			
			int currentIndex = heapSize-1;
			int parentIndex = (currentIndex-1)/2;
			
			while(maxHeap[parentIndex] < value) {
				maxHeap[currentIndex] = maxHeap[parentIndex];
				maxHeap[parentIndex] = value;
				currentIndex = parentIndex;
				parentIndex = (currentIndex-1)/2;
			}
			
		}
		maxHeap[heapSize++] = 1;
		
		return maxHeap;
	}
	
	public static int[] readInput() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] numbers = new int[n];
		for(int i=0; i<n; i++) numbers[i] = (i+1);
		scan.close();
		return numbers;
	}
}
