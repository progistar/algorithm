package dp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P2579 {
	int n;
	int[] points;
	int[][] memory;
	int max;
	ArrayList<Integer> maxList;

	void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			n = Integer.parseInt(br.readLine());
			memory = new int[n+1][3];
			points = new int[n+1];
			for(int i=1;i<n+1;i++) {
				points[i] = Integer.parseInt(br.readLine());
			}
			
			
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	int solve(int index, int score, int stepCount, ArrayList<Integer> list) {
		if(index > n) {
			return -1;
		}else if(index == n) {
			score += points[index];
			list.add(index);
			if(max < score) {
				max = score;
				maxList = list;
			}
			return max;
		}
		
		score += points[index];
		if(memory[index][stepCount] < score) {
			memory[index][stepCount] = score;
			list.add(index);
		}else {
			return -1;
		}
		
		if(stepCount == 1) {
			// 2step
			ArrayList<Integer> newList = (ArrayList<Integer>) list.clone();
			
			solve(index+2, memory[index][stepCount], 0, newList);
		}else {
			// 1step
			ArrayList<Integer> newList = (ArrayList<Integer>) list.clone();
			solve(index+1, memory[index][stepCount], stepCount+1, newList);
			//2step
			ArrayList<Integer> newList2 = (ArrayList<Integer>) list.clone();
			solve(index+2, memory[index][stepCount], 0, newList2);
		}
		return 0;
	}
	
	public static void main(String[] args) {
		P2579 m = new P2579();
		m.input();
		ArrayList<Integer> list = new ArrayList<Integer>();
		m.solve(1, 0, 0, list);
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		m.solve(2, 0, 0, list2);
		System.out.println(m.max);
	}

}
