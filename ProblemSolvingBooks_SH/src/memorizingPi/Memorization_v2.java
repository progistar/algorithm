package memorizingPi;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Memorization_v2 {

	
	public static void main(String[] args) {
		int[][] inputs = readInput();
		for(int i=0; i<inputs.length; i++) {
			System.out.println(getMinimum(inputs[i], 0, 0, new int[inputs[i].length][3]));
		}
	}
	
	public static int getMinimum(int[] inputs, int start, int end, int[][] memorization) {
		int len = inputs.length;
		if(len < end) return Integer.MAX_VALUE;
		else if(len == end) return calDifficulty(inputs, start, end);
		else if(end != 0 && memorization[start][end-start-3] != 0) return memorization[start][end-start-3];
		
		int childDifficulty = Integer.MAX_VALUE;
		for(int i = 0; i<3; i++) {
			childDifficulty = Math.min(childDifficulty, getMinimum(inputs, end, end + 3 + i, memorization));
		}
		
		if(end != 0)
			if(childDifficulty == Integer.MAX_VALUE) {
				memorization[start][end - start - 3] = childDifficulty;
			}else {
				childDifficulty += calDifficulty(inputs, start, end);
				memorization[start][end - start - 3] = childDifficulty;
			}
		return childDifficulty;
	}
	
	// [start, end)
	public static int calDifficulty(int[] inputs, int start, int end) {
		if(end == 0) return 0;
		
		int diffculty = 10;
		boolean isDone = false;
		
		// All numbers are equal. Diff = 1
		boolean isEqual = true;
		for(int i=start; i<end-1; i++) {
			if(inputs[i] != inputs[i+1]) isEqual = false;
		}
		if(isEqual) {
			diffculty = 1;
			isDone = true;
		}
		
		// In/Decreasing just one. Diff = 2
		// Sequence series. Diff = 5
		if(!isDone) {
			boolean isSereis = true;
			int series = inputs[start+1] - inputs[start];
			for(int i=start; i<end-1; i++) {
				if(inputs[i] + series != inputs[i+1]) isSereis = false;
			}
			
			if(isSereis) {
				diffculty = (series == 1 || series == -1) ? 2 : 5;
				isDone = true;
			}
			// Repetitive numbers. Diff = 4
			
			boolean isRepetitive = true;
			for(int i=start; i<end-2; i++) {
				if(inputs[i] != inputs[i+2]) isRepetitive = false;
			}
			
			if(isRepetitive) {
				diffculty = (diffculty == 2) ? 2 : 4;
				isDone = true;
			}
		}
		
		// Otherwise. Diff = 10
		
		return diffculty;
		
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
