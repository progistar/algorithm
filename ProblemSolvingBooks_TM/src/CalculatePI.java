import java.util.Scanner;

public class CalculatePI {
	char[] items;
	int[] cache;
	int max;
	
	int limit = 999999;
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		max = line.length();
		cache = new int[max];
		for(int i=0;i<max;i++) {
			cache[i] = -1;
		}
		
		items = line.toCharArray();
		sc.close();
	}
	
	
	public int solve(int pos) {
		if(pos == max) {
			return 0;
		}
		if(cache[pos] != -1) {
			return cache[pos];
		}
		cache[pos] = limit;
		for(int i=3; i<=5; i++) {
			if(pos + i <= max) {
				int recursive = solve(pos+i) + calScore(pos, i);
				if(recursive < cache[pos]) {
					cache[pos] = recursive;
				}
			}
		}
		return cache[pos];
		
	}
	
	public int calScore(int pos, int flag) {
		char[] part = new char[flag];
		for(int i=0;i<flag;i++) {
			part[i] = items[pos+i];
		}
		
		//calculate
		int score = case1(part);
		if(score == -1) {
			score = case2(part);
			if(score == -1) {
				score = case3(part);
				if(score == -1) {
					score = case4(part);
				}
			}
		}
		
		if(score == -1) {
			score = 10;
		}
			
		return score;
	}
	
	public int case1(char[] part) {
		char temp;
		temp = part[0];
		for(int i=1;i<part.length;i++) {
			if(temp == part[i]) continue;
			return -1;
		}
		return 1;
	}
	
	public int case2(char[] part) {
		char temp;
		temp = part[0];
		int score=2;
		for(int i=1;i<part.length;i++) {
			if(temp+i == part[i]) continue;
			score = -1;
		}
		if(score == -1) {
			score=2;
			for(int i=1;i<part.length;i++) {
				if(temp-i == part[i]) continue;
				score = -1;
			}
		}
		return score;
	}
	
	public int case3(char[] part) {
		char temp = part[0];
		char temp2 = part[1];
		int score = 4;
		for(int i=2; i<part.length;i=i+2) {
			if(temp == part[i]) continue;
			score = -1;
		}
		if(score == -1) {
			return score;
		}
		for(int i=3; i<part.length;i=i+2) {
			if(temp2 == part[i]) continue;
			score=-1;
		}
		return score;
	}
	
	public int case4(char[] part) {
		char temp = part[0];
		char temp2 = part[1];
		int gab = temp2 - temp;
		int score = 5;
		for(int i=2;i<part.length;i++) {
			if(temp2 == part[i] - gab*(i-1)) continue; 
			score = -1;
		}
		return score;
	}
	
	public static void main(String[] args) {
		CalculatePI main = new CalculatePI();
		main.input();
		int x = main.solve(0);
		System.out.println(x);
		//System.out.println(main.calScore(0, 4));
	}

}
