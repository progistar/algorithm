package practiceSession;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1 {

	public static void main(String[] args) throws IOException{
		BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(BR.readLine());
		
		for(int i=0; i<testCases; i++) {
			String[] minMaxString = BR.readLine().split("\\s");
			int min = Integer.parseInt(minMaxString[0]);
			int max = Integer.parseInt(minMaxString[1]);
			int remain = Integer.parseInt(BR.readLine());
			int guess = (min+max)/2;
			String status = null;
			while((remain--) != 0) {
				
				System.out.println(guess+"");
				status = BR.readLine();
				
				if(status.equalsIgnoreCase("TOO_SMALL")) {
					min = guess;
				}else if(status.equalsIgnoreCase("TOO_BIG")) {
					max = guess;
				}else if(status.equalsIgnoreCase("CORRECT")) {
					break;
				}else if(status.equalsIgnoreCase("WRONG_ANSWER")) {
					break;
				}
				
				guess = (min+max+1)/2;
			}
		}
	}
}
