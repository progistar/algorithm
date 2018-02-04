package quanlificationRound;

import java.util.Scanner;

/**
 * Glucose + 6 oxygens = 36 ATP (Aerobic Respiration)
 * Glucose only = 2 ATP (Fermentation)
 * 
 * @author progi
 *
 */
public class Problem1 {
	// None integer programming
	public static void main(String[] args) {
		int[][] inputs = readInput();
		int inputLen = inputs.length;
		for(int i=0; i<inputLen; i++) System.out.println(solveProblem(inputs[i][0], inputs[i][1], inputs[i][2]));
	}
	
	public static double solveProblem(int costG, int costO, int money) {
		double aerobic = ((double)money/((double)(costG+6*costO))) * 38.0;
		double fermentation = (double)money/((double)costG) * 2.0;
		return Math.max(aerobic, fermentation);
		
	}
	
	public static int[][] readInput() {
		int[][] inputs = null;
		
		Scanner scan = new Scanner(System.in);
		
		int testCases = scan.nextInt();
		inputs = new int[testCases][3];
		for(int i=0; i<testCases; i++) {
			for(int j=0; j<3; j++) {
				inputs[i][j] = scan.nextInt();
			}
		}
		
		scan.close();
		
		return inputs;
	}
}
