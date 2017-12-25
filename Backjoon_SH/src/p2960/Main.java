package p2960;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int sizeOfInput = scan.nextInt()+1;
		int targetIndex = scan.nextInt();
		
		long[] naturalNumbers = new long[sizeOfInput];
		
		System.out.println(eratosthenes(naturalNumbers, targetIndex));
		
		scan.close();
	}
	
	private static int eratosthenes(long[] naturalNumbers, int targetIndex) {
		int sizeOfInput = naturalNumbers.length;
		
		for(int num=2; num<sizeOfInput; num++) {
			if(naturalNumbers[num] == -1) continue;
			
			int del = num;
			while(del < sizeOfInput) {
				if(naturalNumbers[del] != -1) targetIndex--;
				if(targetIndex == 0) return del;
				naturalNumbers[del] = -1;
				del += num;
			}
			
		}
		
		return 0;
	}
}
