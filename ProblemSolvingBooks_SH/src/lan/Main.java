package lan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		int[][][] inputs = readInput();
		int cases = inputs.length;
		
		for(int i=0; i<cases; i++) System.out.println(prim(inputs[i]));
	}
	
	public static Double prim(int[][] input) {
		Double cost = .0;
		
		return cost;
	}
	
	public static int[][][] readInput() throws IOException {
		int[][][] inputs = null;
		
		BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		
		int cases = Integer.parseInt(BR.readLine());
		inputs = new int[cases][][];
		
		for(int i=0; i<cases; i++) {
			String[] info = BR.readLine().split("\\s");
			int buildings = Integer.parseInt(info[0]);
			int alreadyOccupied = Integer.parseInt(info[1]);
			
			inputs[i] = new int[2+alreadyOccupied][];
			inputs[i][0] = new int[buildings];
			inputs[i][1] = new int[buildings];
			
			String[] X = BR.readLine().split("\\s");
			String[] Y = BR.readLine().split("\\s");
			for(int index=0; index<buildings; index++) {
				inputs[i][0][index] = Integer.parseInt(X[index]);
				inputs[i][1][index] = Integer.parseInt(Y[index]);
			}
			
			for(int index=0; index<alreadyOccupied; index++) {
				info = BR.readLine().split("\\s");
				inputs[i][index+2] = new int[2];
				inputs[i][index+2][0] = Integer.parseInt(info[0]);
				inputs[i][index+2][1] = Integer.parseInt(info[1]);
			}
		}
		
		BR.close();
		return inputs;
	}
}
