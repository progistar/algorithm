package memorizingPi;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Memorization {

	public static void main(String[] args) {
		int[][] inputs = readInput();
		for(int i=0; i<inputs.length; i++) {
			System.out.println(getMinimum(inputs[i], new int[inputs[i].length+1], 0)+"");
		}
	}
	
	public static int getMinimum(int[] inputs, int[] memorization, int curPos) {
		int min = Integer.MAX_VALUE;
		for(int i=3; i<6; i++) {
			int curMin = getMinimum(inputs, memorization, curPos, curPos + i);
			if(curMin == -1) continue;
			min = Math.min(min, curMin);
		}
		
		return min;
	}
	
	public static int getMinimum(int[] inputs, int[] memorization, int curPos, int nextPos) {
		if(curPos == inputs.length) return 0;
		if(nextPos > inputs.length || inputs.length - curPos < 3) return -1;
		int minScore = getScore(inputs, curPos, nextPos);
		if(minScore == -1) return minScore;
		if(memorization[curPos] != 0) return memorization[curPos];
		
		int minCurScore = Integer.MAX_VALUE;
		for(int i=3; i<6; i++) {
			int curScore = getMinimum(inputs, memorization, nextPos, nextPos+i);
			if(curScore == -1) continue;
			minCurScore = Math.min(curScore, minCurScore);
		}
		
		if(minCurScore == Integer.MAX_VALUE) return - 1;
		memorization[nextPos] = minScore + minCurScore;
		return memorization[nextPos];
	}

	// [curPos, lastPos)
	public static int getScore(int[] inputs, int curPos, int nextPos) {
		if(inputs.length < nextPos) return -1;
		
		boolean isOkay = true;
		int diff = inputs[curPos] - inputs[curPos+1];
		for(int i=curPos; i<nextPos-1; i++) {
			if(inputs[i] != inputs[i+1] + diff) {
				isOkay = false;
				break;
			}
		}
		if(isOkay) {
			if(diff == 0) return 1;
			if(diff == 1 || diff == -1) return 2;
			return 5;
		}
		
		isOkay = true;
		for(int i=curPos; i<nextPos-2; i++) {
			if(inputs[i] != inputs[i+2]) {
				isOkay = false;
				break;
			}
		}
		
		if(isOkay) return 4;
		else return 10;
	}
	
	public static int[][] readInput() {
		int[][] inputs = null;
		
		try {
			BufferedReader BR =new BufferedReader(new InputStreamReader(System.in));
			int sizeOfCases  = Integer.parseInt(BR.readLine());
			
			inputs = new int[sizeOfCases][];
			
			for(int i=0; i<sizeOfCases; i++) {
				String input = BR.readLine();
				int inputLength = input.length();
				inputs[i] = new int[inputLength];
				
				for(int j=0; j<inputLength; j++) inputs[i][j] = input.charAt(j) - '0';
				
			}
			
			
			BR.close();
		}catch(Exception e) {
			
		}
		
		return inputs;
	}
}
