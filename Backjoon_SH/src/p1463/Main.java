package p1463;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int target = scan.nextInt();
		scan.close();
		
		System.out.println(count(target, new int[target+1]));
		
	}
	
	public static int count(int target, int[] memorization) {
		if(target == 1) return 0;
		if(target < 1) return Integer.MAX_VALUE;
		if(memorization[target] != 0) return memorization[target];
		
		int count = 0;
		
		int div3 = target%3 == 0 ? count(target/3, memorization) : Integer.MAX_VALUE;
		int div2 = target%2 == 0 ? count(target/2, memorization) : Integer.MAX_VALUE;
		int minus1 = count(target-1, memorization);
		
		count = Math.min(div2, div3);
		count = Math.min(count, minus1);
		memorization[target] = count + 1;
		
		return memorization[target];
	}
}
