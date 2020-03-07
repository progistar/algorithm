package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//15990 1,2,3 더하기5
public class Main {
	int N;
	int[] cases;
	long[][] dp;
	void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			N = Integer.parseInt(br.readLine());
			cases = new int[N];
			for (int i=0; i<N; i++) {
				cases[i] = Integer.parseInt(br.readLine());
				dp = new long[cases[i]][3];
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	long solve(int value) {
		long total = recursive(value-3, 2) % 1000000009;
		total += recursive(value-2, 1) % 1000000009;
		total += recursive(value-1, 0) % 1000000009;
		return (total % 1000000009);
	}
	
	long recursive(int value, int type) {
		if (value < 0) return 0;
		else if (value == 0) return 1;
		if (dp[value][type] != 0) return dp[value][type];
		
		long total = 0;
		switch (type) {
		case 0:
			total += recursive(value-2, 1);
			total += recursive(value-3, 2);
			break;
		case 1:
			total += recursive(value-1, 0);
			total += recursive(value-3, 2);
			break;
		case 2:
			total += recursive(value-1, 0);
			total += recursive(value-2, 1);
			break;
		default:
			System.out.println("error");
			break;
		}
		dp[value][type] = total;
		return dp[value][type];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m = new Main();
		m.input();
		for (int i=0; i<m.N; i++) {
			System.out.println(m.solve(m.cases[i]));
		}
	}

}
