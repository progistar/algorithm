package qualificatinoRound;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2 {

	public static void main(String[] args) throws IOException {
		int[][] inputs = readInput();
		for(int i=0; i<inputs.length; i++) {
			int result = troubleSort(inputs[i]);
			if(result == -1) {
				System.out.println("Case #"+(i+1)+": OK");
			}else {
				System.out.println("Case #"+(i+1)+": "+result);
			}
		}
	}
	
	public static int troubleSort(int[] input) {
		int len = input.length;
		boolean isDone = false;
		
		while(!isDone) {
			isDone = true;
			for(int i=0; i<len-2; i++) {
				if(input[i] > input[i+2]) {
					int temp = input[i];
					input[i] = input[i+2];
					input[i+2] = temp;
					isDone = false;
				}
			}
			
			len -= 2;
		}
		
		int isOkay = -1;
		len = input.length - 1;
		for(int i=0; i<len; i++) {
			if(input[i] > input[i+1]) {
				isOkay = i;
				break;
			}
		}
		
		return isOkay;
	}
	
	public static int[][] readInput() throws IOException {
		int[][] inputs = null;
		
		BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(BR.readLine());
		
		inputs = new int[testCase][];
		for(int i=0; i<testCase; i++) {
			int size = Integer.parseInt(BR.readLine());
			inputs[i] = new int[size];
			String[] input = BR.readLine().split("\\s");
			
			for(int j=0; j<size; j++) {
				inputs[i][j] = Integer.parseInt(input[j]);
			}
			
		}
		
		BR.close();
		
		return inputs;
	}
}
