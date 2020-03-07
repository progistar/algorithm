package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//11052
public class P11052 {
	int N;
	int[] values;
	int[] memory;
	
	void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			N = Integer.parseInt(br.readLine());
			values = new int[N+1];
			memory = new int[N+1]; 
			String[] line = br.readLine().split("\\s");
			for (int i=1; i<=N; i++) {
				values[i] = Integer.parseInt(line[i-1]);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	int solve() {
		int max = values[N];
		for (int i=1; i<= N/2; i++) {
			int sum = (recursive(i) + recursive(N-i));
			max = sum > max ? (recursive(i) + recursive(N-i)) : max;
		}
		return max;
	}
	
	int recursive(int index) {
		if (index == 1) return values[1];
		if (memory[index] != 0) return memory[index];
		memory[index] = values[index];
		for (int i=1; i<=index/2; i++) {
			int newValue = recursive(i) + recursive(index - i);
			if (newValue > memory[index]) memory[index] = newValue;
		}
		return memory[index];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		P11052 m = new P11052();
		m.input();
		System.out.println(m.solve());
	}

}
