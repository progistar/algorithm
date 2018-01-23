package p10610;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println(returnMax(readInput()));
	}
	
	public static String returnMax(char[] input) {
		String returnVal = "-1";
		int inputLen = input.length;
		
		// increasing order
		Arrays.sort(input);
		
		// check first condition
		// Can it be divided by 10?
		if(input[0] != '0') return returnVal;
		
		// check second condition
		// Can it be divided by 3?
		int sum = 0;
		for(int i=0; i<inputLen; i++) sum += input[i]-'0';
		if(sum%3 != 0) return returnVal;
		
		returnVal = "";
		for(int i=inputLen-1; i>-1; i--) returnVal += input[i];
		
		return returnVal;
	}
	
	public static char[] readInput() {
		char[] input = null;
		
		Scanner scan = new Scanner(System.in);
		String number = scan.nextLine();
		scan.close();
		
		int numLength = number.length();
		input = new char[numLength];
		for(int i=0; i<numLength; i++) input[i] = number.charAt(i);
		
		return input;
	}
}
