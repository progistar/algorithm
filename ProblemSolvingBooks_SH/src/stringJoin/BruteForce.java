package stringJoin;

import java.util.LinkedList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 
 * Algorithm
 * 
 * Input: Integer Array
 * 
 * 1. Making the input to linkedlist
 * 2. Sorting the linkedlist as a ascending order.
 * 3. Polling first two elements and adding the elements.
 * 4. Pushing the added element into the linkedlist.
 * 5. Recursively running from 2 to 4 until remaining only one element in the linkedlist.
 * 
 * ** Improvement Point **
 * 1. Data Structure
 *    Use heap instead of linkedlist
 *    or
 *    Use Priority-queue instead of linkedlist
 * 
 * @author progi
 *
 */
public class BruteForce {

	public static void main(String[] args) {
		int[][] inputs = readInput();
		int size = inputs.length;
		for(int i=0; i<size; i++) System.out.println(minCal(inputs[i]));
	}
	
	public static int minCal(int[] input) {
		int cnt = 0;
		
		LinkedList<Integer> sortedInput = new LinkedList<Integer>();
		for(int i=0; i<input.length; i++) sortedInput.add(input[i]);
		Collections.sort(sortedInput);
		
		cnt = sortedInput.pollFirst() + sortedInput.pollFirst();
		sortedInput.push(cnt);
		
		cnt += greedy(sortedInput);
		
		return cnt;
	}
	
	public static int greedy(LinkedList<Integer> sortedInput) {
		if(sortedInput.size() == 1) return 0;
		
		int cnt = 0;
		Collections.sort(sortedInput);
		cnt = sortedInput.pollFirst() + sortedInput.pollFirst();
		sortedInput.push(cnt);
		
		cnt += greedy(sortedInput);
		
		return cnt;
	}
	
	public static int[][] readInput() {
		Scanner scan = new Scanner(System.in);
		
		int size = scan.nextInt();
		int[][] inputs = new int[size][];
		
		for(int i=0; i<size; i++) {
			int elements = scan.nextInt();
			inputs[i] = new int[elements];
			for(int j=0; j<elements; j++) inputs[i][j] = scan.nextInt();
		}
		
		scan.close();
		return inputs;
	}
}
