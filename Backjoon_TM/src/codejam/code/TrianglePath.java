package codejam.code;
import java.util.Scanner;

public class TrianglePath {
	private int N;
	private int[][] array;
	private int[][] cache;
	public void input() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		array = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<=i;j++) {
				array[i][j] = sc.nextInt();
			}
		}
		cache = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<=i;j++) {
				cache[i][j] = -1;
			}
		}
		
		sc.close();
	}
	public int solve(int row, int col, int sum) {
		if(row == N-1) {
			return sum + array[row][col];
		}
		if(cache[row][col] != -1) {
			return cache[row][col];
		}
		
		int score = array[row][col];
		sum += score;
		
		int left = solve(row+1, col, sum);
		int right = solve(row+1, col+1, sum);
		
		if(left > right) {
			cache[row][col] = left;
		}else {
			cache[row][col] = right;
		}
		return cache[row][col];
	}
	public int solve2(int row, int col) {
		if(row == N-1) {
			return array[row][col];
		}
		if(cache[row][col] != -1) {
			return cache[row][col];
		}
		
		int score = array[row][col];
		
		int left = solve2(row+1, col);
		int right = solve2(row+1, col+1);
		
		if(left > right) {
			cache[row][col] = left+score;
		}else {
			cache[row][col] = right+score;
		}
		return cache[row][col];
	}
	public static void main(String[] args) {
		TrianglePath m = new TrianglePath();
		m.input();
		System.out.println(m.solve2(0, 0));
	}
}

