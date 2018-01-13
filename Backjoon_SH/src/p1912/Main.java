package p1912;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println(biggestSum(readInput()));
	}
	
	public static int biggestSum(int[] input) {
		int inputLen = input.length;
		int[] memorization = null;
		int max = input[0];
		
		// Reduction
		int[] reducer = new int[inputLen];
		reducer[0] = input[0];
		int reducerIndex = 0;
		boolean isPlus = reducer[0] > 0 ? true : false;
		for(int i=1; i<inputLen; i++) {
			boolean curPlus = input[i] > 0 ? true : false;
			if(isPlus != curPlus) {
				reducerIndex++;
				isPlus = curPlus;
			}
			reducer[reducerIndex] += input[i];
			max = Math.max(input[i], max);
		}
		reducerIndex++;
		
		memorization = new int[reducerIndex];
		memorization[0] = reducer[0];
		max = Math.max(max, reducer[0]);
		for(int i=1; i<reducerIndex; i++) {
			memorization[i] = memorization[i-1] + reducer[i];
			max = Math.max(max, memorization[i]);
		}
		
		for(int from=1; from<reducerIndex; from++) {
			for(int to=from; to<reducerIndex; to++) {
				int val = memorization[to] - memorization[from-1];
				max = Math.max(val, max);
			}
		}
		
		return max;
	}
	
	public static int[] readInput() {
		int[] input = null;
		Scanner scan = new Scanner(System.in);
		
		int size = scan.nextInt();
		
		input = new int[size];
		
		for(int i=0; i<size; i++) input[i] = scan.nextInt();
		
		scan.close();
		return input;
	}
}
