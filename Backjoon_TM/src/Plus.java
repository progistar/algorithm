import java.util.Scanner;

public class Plus {
	int N;
	int[] number;
	public void input() {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		number = new int[N];
		for(int i=0;i<N;i++) {
			number[i] = sc.nextInt();
		}
		sc.close();		
	}
	public int solve(int pos, int sum) {
		if(pos >= N) {
			return sum;
		}
		
		if(number[pos]<0) {
			return Math.max(Math.max(solve(pos+1, 0), solve(pos+1, sum+number[pos])), sum);
		}else {
			return solve(pos+1, sum+number[pos]);
		}
	}
	
	public int solve2() {
		int max = -1;
		int sum = 0;
		boolean isPositiveNumber = false;
		for(int i=0;i<N;i++) {
			if(number[i] >= 0) {
				sum += number[i];
				isPositiveNumber = true;
			}else {
				if(sum > max) {
					max = sum;
				}
				if(sum + number[i] >= 0) {
					sum += number[i];
				}else {
					sum = 0;
				}
			}
		}
		
		if(sum > max) {
			max = sum;
		}
		if(max == -1) {
			max = sum;
		}
		if(!isPositiveNumber) {
			int maxx = number[0];
			for(int i=1;i<N;i++) {
				if(number[i] > maxx) {
					maxx = number[i];
				}
			}
			max = maxx;
		}
		
		return max;
	}
	public static void main(String[] args) {
		Plus m = new Plus();
		m.input();
		System.out.println(m.solve2());
	}

}
