package codejam.code;
import java.util.Scanner;

public class Sticker {
	public static int max(int a, int b, int c) {
		int max = a;
		if(b>max) {
			max = b;
		}
		if(c>max) {
			max = c;
		}
		return max;
	}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int[][] sticker;
		int[][] cache = new int[2][100002];
		int[] solution = new int[testCase];
		
		for(int i=0;i<testCase;i++) {//testCase each by each
			int N = sc.nextInt();
			sticker = new int[2][N+2];
			
			for(int j=0;j<2;j++) {
				for(int k=2;k<N+2;k++) {
					sticker[j][k] = sc.nextInt();
				}
			}
			
			//solve
			for(int j=2;j<N+2;j++) {
				cache[0][j] = max(sticker[0][j]+cache[1][j-1], sticker[0][j]+cache[1][j-2], cache[0][j-1]);
				cache[1][j] = max(sticker[1][j]+cache[0][j-1], sticker[1][j]+cache[0][j-2], cache[1][j-1]);
			}
			int max=-1;
			if(cache[0][N+1] > cache[1][N+1]) {
				max = cache[0][N+1];
			}else {
				max = cache[1][N+1];
			}
			solution[i] = max;
		}
		sc.close();
		
		for(int i=0;i<testCase;i++) {
			System.out.println(solution[i]);
		}
	}

}
