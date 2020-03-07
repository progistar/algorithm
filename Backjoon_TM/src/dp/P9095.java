package dp;

import java.util.Scanner;
//9095
public class P9095 {

	int[] memory;
	int[] N;
	int T;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P9095 m = new P9095();
		m.input();
		for (int i=0; i<m.T; i++) {
			m.memory = new int[m.N[i]+1];
			System.out.println(m.solve(m.N[i]));
		}
	}
	
	void input() {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		N=new int[T];
		for (int i=0;i<T;i++) {
			N[i] = sc.nextInt();
		}
		sc.close();
	}
	int solve(int n) {
		if (n == 0) return 1;
		if (memory[n] != 0) return memory[n];
		
		int total = 0;
		total = (n-3 >= 0) ? solve(n-3)+total : total;
		total = (n-2 >= 0) ? solve(n-2)+total : total;
		total = (n-1 >= 0) ? solve(n-1)+total : total;
		memory[n] = total;
		return total;
	}

}
