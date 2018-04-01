package practiceSession;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution3 {

	public static void main(String[] args) throws IOException {
		int[][][] inputs = readInput();
		
		for(int i=0; i<inputs.length; i++) {
			System.out.println("Case #"+(i+1)+": "+maximumSpeed(inputs[i]));
		}
		
	}
	
	public static double maximumSpeed(int[][] input) {
		double maxTime = 0;
		double distance = input[0][0];
		int horses = input[0][1] + 1;
		
		for(int i=1; i<horses; i++) {
			double curPos = input[i][0];
			double curSpeed = input[i][1];
			
			maxTime = Math.max(maxTime, (distance - curPos)/curSpeed);
		}
		
		
		return distance/maxTime;
	}
	
	public static int[][][] readInput() throws IOException {
		int[][][] inputs = null;
		BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		
		int testCases = Integer.parseInt(BR.readLine());
		inputs = new int[testCases][][];
		
		for(int i=0; i<testCases; i++) {
			String[] reader = BR.readLine().split("\\s");
			int distance = Integer.parseInt(reader[0]);
			int horses = Integer.parseInt(reader[1]);
			
			inputs[i] = new int[horses+1][2];
			inputs[i][0][0] = distance;
			inputs[i][0][1] = horses;
			
			for(int j=1; j<horses+1; j++) {
				reader = BR.readLine().split("\\s");
				inputs[i][j][0] = Integer.parseInt(reader[0]);
				inputs[i][j][1] = Integer.parseInt(reader[1]);
			}
		}
		
		BR.close();
		return inputs;
	}
}
