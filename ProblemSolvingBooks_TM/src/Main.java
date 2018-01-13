import java.util.Scanner;

public class Main {
	int N;
	int[] step;
	int[][] cache;
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		step = new int[N+1];
		cache = new int[N+1][2];
		for(int i=1; i<=N;i++) {
			step[i] = sc.nextInt();
		}
		for(int i=1;i<=N;i++) {
			for(int j=0;j<2;j++) {
				cache[i][j] = -99999;
			}
			
		}
		sc.close();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m = new Main();
		m.input();
		//int result = m.solve(0, 0, 0);

		//System.out.println(result);
		
		for(int i=0;i<m.N;i++) {
			for(int j=0;j<2;j++) {
				System.out.println(m.cache[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
