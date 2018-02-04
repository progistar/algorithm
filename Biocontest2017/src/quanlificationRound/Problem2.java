package quanlificationRound;

import java.util.Scanner;

public class Problem2 {
	public static void main(String[] args) {
		long[][] inputs = readInput();
		int inputLen = inputs.length;
		for(int i=0; i<inputLen; i++) System.out.printf("%f\n", solveProblem(inputs[i][0], inputs[i][1], inputs[i][2]));
	}
	
	public static double solveProblem(long costG, long costO, long money) {
		double gluOnly = (money/costG) * 2.0;
		long leftMoney = money - costG*(money/costG);
		if(leftMoney != 0) {
			long tempO2 =  (leftMoney/costO);
			if(6*(money/costG) < tempO2){
				gluOnly += (double)(money/costG) * 36.0; 
			}else {
				gluOnly += ((double)tempO2/6.0) * 36.0;
			}
		}
		
		long init = (money/(costG+6*costO));
		long gluAvailable = init;
		long o2Available = (init) * 6;
		leftMoney = money - (costG+6*costO)*init;
		int o2Cnt = leftMoney == money ? 0 : 6;
		while(true) {
			if(o2Cnt != 6) {
				leftMoney -= costO;
				if(leftMoney < 0) {
					leftMoney += costO;
					break;
				}
				o2Cnt ++;
				o2Available++;
			}else {
				leftMoney -= costO + costG;
				if(leftMoney < 0) {
					leftMoney += costO + costG;
					break;
				}
				o2Cnt = 1;
				o2Available++;
				gluAvailable++;
			}
		}
		
		
		if(leftMoney > 0) {
			gluAvailable += leftMoney / costG;
		}
		double comb = gluAvailable * 2.0;
		comb += ((double)o2Available/6.0) * 36.0;
		
		return Math.max(gluOnly, comb);
	}
	
	public static double solveSubProblem(long leftMoney, double[][] memorizations, long glu, long o2, long costG, long costO) {
		if(memorizations[(int)glu][(int)o2] != 0) return memorizations[(int)glu][(int)o2];
		
		double solution = 0;
		
		if(leftMoney - costG < 0 && leftMoney - costO < 0) {
			// fully glu
			solution = glu * 2.0;
			// glu and o2
			
			double combSolution = 0;
			while(true) {
				glu --;
				o2 -= 6;
				
				if(glu >= 0 && o2 >= 0) {
					combSolution += 38.0;
				}else if(glu >= 0 && o2 < 0) {
					o2 += 6;
					combSolution = 36.0 * (((double)o2)/6.0) + 2.0;
					break;
				}else {
					glu ++;
					o2 += 6;
					break;
				}
			}
			
			if(glu > 0) combSolution += 2.0 * glu;
			solution = Math.max(solution, combSolution);
			return solution;
		}
		
		if(leftMoney - costG >= 0) // by glu
			solution = solveSubProblem(leftMoney-costG, memorizations, glu+1, o2, costG, costO);
		if(leftMoney - costO >= 0)
			solution = Math.max(solution, solveSubProblem(leftMoney - costO, memorizations, glu, o2+1, costG, costO));
		
		memorizations[(int)glu][(int)o2] = solution;
		
		return solution;
	}
	
	public static long[][] readInput() {
		long[][] inputs = null;
		
		Scanner scan = new Scanner(System.in);
		
		int testCases = scan.nextInt();
		inputs = new long[testCases][3];
		for(int i=0; i<testCases; i++) {
			for(int j=0; j<3; j++) {
				inputs[i][j] = scan.nextLong();
			}
		}
		
		scan.close();
		
		return inputs;
	}

}
