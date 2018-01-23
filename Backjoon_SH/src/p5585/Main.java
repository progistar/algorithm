package p5585;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int baseMoney = 1000;
		Scanner scan = new Scanner(System.in);
		baseMoney -= scan.nextInt();
		scan.close();
		
		int[] possibleCharges = {500, 100, 50, 10, 5, 1};
		int chargePivot = 0;
		int chargeCnt = 0;
		
		while(baseMoney != 0) {
			if(possibleCharges[chargePivot] > baseMoney) {
				chargePivot++;
			}else {
				baseMoney -= possibleCharges[chargePivot];
				chargeCnt++;
			}
		}
		
		System.out.println(chargeCnt);
	}
	
	public static int brute(int money, int[] memorization) {
		if(money == 0) return 0;
		if(memorization[money] != 0) return memorization[money];
		
		int[] possibleCharges = {500, 100, 50, 10, 5, 1};
		
		int minCnt = Integer.MAX_VALUE;
		for(int i=0; i<possibleCharges.length; i++) {
			if(money - possibleCharges[i] >= 0) {
				int thisCnt = brute(money - possibleCharges[i], memorization) + 1;
				minCnt = Math.min(thisCnt, minCnt);
			}
			
		}
		
		memorization[money] = minCnt;
		
		return minCnt;
	}
}
