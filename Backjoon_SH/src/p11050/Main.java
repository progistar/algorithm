package p11050;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int K = scan.nextInt();
		scan.close();
		
		int frac1 = 1;
		for(int i=0; i<K; i++) frac1 *= N--;
		int frac2 = 1;
		for(int i=0; i<K; i++) frac2 *= (K-i);
		
		System.out.println(frac1/frac2);
	}
}
