package p6359;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int sizeOfCases = scan.nextInt();
		int[] cases = new int[sizeOfCases];
		for(int i=0; i<cases.length; i++) cases[i] = scan.nextInt();
		
		for(int i=0; i<cases.length; i++) locking(new boolean[cases[i]+1], 1);
		
		scan.close();
	}
	
	public static void locking(boolean[] doors, int num) {
		int len = doors.length;
		if(num == len) {
			int cnt = 0;
			for(int i=1; i<len; i++) if(doors[i]) cnt ++;
			System.out.println(cnt);
			return;
		}
		
		for(int i=num; i<len; i += num) 
			doors[i] = doors[i] == true ? false : true;
		
		locking(doors, num+1);
	}
}
