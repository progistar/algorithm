package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1149
public class P1149 {
	
	public static void main(String[] args) {
		P1149 m = new P1149();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n;
		int[][] cost;
		int[][] memory;
		try {
			n = Integer.parseInt(br.readLine());
			cost = new int[n+1][4];
			memory = new int[n+1][4];
			for(int i=1;i<=n;i++) {
				String[] value = br.readLine().split("\\s");
				cost[i][1] = Integer.parseInt(value[0]);
				cost[i][2] = Integer.parseInt(value[1]);
				cost[i][3] = Integer.parseInt(value[2]);
			}
			
			for(int i=1;i<=n;i++) {
				memory[i][1] = (memory[i-1][2] < memory[i-1][3] ? memory[i-1][2] : memory[i-1][3]) + cost[i][1]; 
				memory[i][2] = (memory[i-1][1] < memory[i-1][3] ? memory[i-1][1] : memory[i-1][3]) + cost[i][2]; 
				memory[i][3] = (memory[i-1][1] < memory[i-1][2] ? memory[i-1][1] : memory[i-1][2]) + cost[i][3]; 
			}
			int temp = memory[n][2] < memory[n][3] ? memory[n][2] : memory[n][3];
			int max = temp  < memory[n][1] ? temp : memory[n][1];
			
			System.out.println(max);
			
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
