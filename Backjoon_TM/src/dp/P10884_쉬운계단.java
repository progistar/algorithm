package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//P10884_쉬운계단
public class P10884_쉬운계단 {
	int N;
	long[][] dp;
	void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			N = Integer.parseInt(br.readLine());
			dp = new long[N+1][];
			for (int i=1; i<N+1; i++) {
				dp[i] = new long[10];
			}
			for (int i=0;i<10;i++) {
				dp[1][i] = 1;
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	long solve() {
		if (N == 1) return 9;
		long sum = 0L;
		for (int i=2;i<=N;i++) {
			sum = 0L;
			//0
			dp[i][0] = dp[i-1][1] % 1000000000;
			for (int j=1;j<9;j++) {
				 sum += dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
			}
			sum += dp[i][9] = dp[i-1][8] % 1000000000; 
		}
		return sum % 1000000000;
		//return sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P10884_쉬운계단 m = new P10884_쉬운계단();
		m.input();
		System.out.println(m.solve());
	}

}
