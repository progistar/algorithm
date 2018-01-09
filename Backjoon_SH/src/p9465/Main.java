package p9465;

import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		int[][][] inputs = readInput();
		for(int i=0; i<inputs.length; i++) {
			int[][] memorization = new int[3][inputs[i][0].length];
			boolean[] states = new boolean[2];
			System.out.println(selector(inputs[i], 0, states, memorization));
		}
	}
	
	public static int selector(int[][] stamps, int col, boolean[] states, int[][] memorization) {
		if(col == stamps[0].length) return 0;
		int tempScore = 0;
		int maxScore = 0;
		
		
		// Comparing with the left-up
		if(col==0 || !states[0]) {
			if(memorization[0][col] == 0) {
				boolean[] newStates = new boolean[2];
				newStates[0] = true;
				tempScore = selector(stamps, col+1, newStates, memorization) + stamps[0][col];
				memorization[0][col] = tempScore;
			}else {
				tempScore = memorization[0][col];
			}
			maxScore = Math.max(maxScore, tempScore);
		}
		
		// Comparing with the left-down
		if(col==0 || !states[1]) {
			if(memorization[1][col] == 0) {
				boolean[] newStates = new boolean[2];
				newStates[1] = true;
				tempScore = selector(stamps, col+1, newStates, memorization) + stamps[1][col];;
				memorization[1][col] = tempScore;
			}else {
				tempScore = memorization[1][col];
			}
			maxScore = Math.max(maxScore, tempScore);
		}
		
		// Pass
		if(memorization[2][col] == 0) {
			boolean[] newStates = new boolean[2];
			tempScore = selector(stamps, col+1, newStates, memorization);
			memorization[2][col] = tempScore;
		}else {
			tempScore = memorization[2][col];
		}
		maxScore = Math.max(maxScore, tempScore);
		
		
		return maxScore;
	}
	
	public static int[][][] readInput() {
		int[][][] inputs = null;
		
		Scanner scan = new Scanner(System.in);
		
		int case_ = scan.nextInt();
		
		inputs = new int[case_][][];
		
		for(int i=0; i<case_; i++) {
			int size = scan.nextInt();
			inputs[i] = new int[2][size];
			
			for(int j=0; j<size; j++) inputs[i][0][j] = scan.nextInt();
			for(int j=0; j<size; j++) inputs[i][1][j] = scan.nextInt();
		}
		
		scan.close();
		return inputs;
	}
}
