package dp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P내려가기 {
	int n;
	int[][] points;
	int[][] memory;
	int max; int min = 100000;
	ArrayList<Integer> maxList;
	ArrayList<Integer> minList;
	void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			n = Integer.parseInt(br.readLine());
			points = new int[n+1][4];
			memory = new int[n+1][4];
			for(int i=1;i<=n;i++) {
				String line = br.readLine();
				String[] value = line.split("\\s"); 
				for(int j=1;j<=3;j++) {
					points[i][j] = Integer.parseInt(value[j-1]);
				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void solve() {
		memory[0][1] = 0;
		memory[0][2] = 0;
		memory[0][3] = 0;
		
		for(int i=1;i<=n;i++) {
			memory[i][1] = max(memory[i-1][1], memory[i-1][2]) + points[i][1];
			memory[i][2] = max(memory[i][1]-points[i][1], memory[i-1][3]) + points[i][2];
			memory[i][3] = max(memory[i-1][2], memory[i-1][3]) + points[i][3];
		}
		max = max(max(memory[n][1], memory[n][2]), memory[n][3]);
		
		for(int i=1;i<=n;i++) {
			memory[i][1] = min(memory[i-1][1], memory[i-1][2]) + points[i][1];
			memory[i][2] = min(memory[i][1]-points[i][1], memory[i-1][3]) + points[i][2];
			memory[i][3] = min(memory[i-1][2], memory[i-1][3]) + points[i][3];
		}
		min = min(min(memory[n][1], memory[n][2]), memory[n][3]);
	}
	
	int max(int a, int b) {
		return a > b ? a:b;
	}
	
	int min(int a, int b) {
		return a < b ? a:b;
	}
	
	public static void main(String[] args) {
		P내려가기 m = new P내려가기();
		m.input();
		m.solve();
		System.out.println(m.max+" "+m.min);
		
	}

}
