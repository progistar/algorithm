package codejam.code;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LG1 {
	
	static int calRow(char[][] table, String pattern, int N, int M) {
		if(pattern.length() <= M) {
			for(int i=0;i<N;i++) {
				StringBuilder builder = new StringBuilder(); 
				for(int j=0;j<M;j++) {
					builder.append(table[i][j]);
				}
				String str = builder.toString();
				ArrayList<Integer> list = kmp(str, pattern);
				if(list.size() != 0) {
					System.out.println("1");
					return 1;
				}
				
				//reverse
				builder = builder.reverse();
				str = builder.toString();
				list = kmp(str, pattern);
				if(list.size() != 0) {
					System.out.println("1");
					return 1;
				}
			}
		}
		return 0;
	}
	
	static int calCol(char[][] table, String pattern, int N, int M) {
		if(pattern.length() <= N) {
			for(int j=0;j<M;j++) {
				StringBuilder builder = new StringBuilder();
				for(int i=0;i<N;i++) {
					builder.append(table[i][j]);
				}
				String str = builder.toString();
				ArrayList<Integer> list = kmp(str, pattern);
				if(list.size() != 0) {
					System.out.println("1");
					return 1;
				}
				
				//reverse
				builder = builder.reverse();
				str = builder.toString();
				list = kmp(str, pattern);
				if(list.size() != 0) {
					System.out.println("1");
					return 1;
				}
			}
		}
		return 0;
	}
	
	static int calLeftUp(char[][] table, String pattern, int N, int M) {
		int patternLength = pattern.length();
		if(patternLength <= M && patternLength <= N) {
			for(int i=patternLength-1;i<N;i++) {
				StringBuilder builder = new StringBuilder();
				for(int j=0;(i-j)>=0 && j<M;j++) {
					builder.append(table[i-j][j]);
				}
				String str = builder.toString();
				ArrayList<Integer> list = kmp(str, pattern);
				if(list.size() != 0) {
					System.out.println("1");
					return 1;
				}
				
				//reverse
				builder = builder.reverse();
				str = builder.toString();
				list = kmp(str, pattern);
				if(list.size() != 0) {
					System.out.println("1");
					return 1;
				}
			}
			
			for(int j=1;j<=M-patternLength;j++) {
				StringBuilder builder = new StringBuilder();
				for(int i=N-1;i>=0 && j+(N-1-i)<M;i--) {
					builder.append(table[i][j+(N-1-i)]);
				}
				String str = builder.toString();
				ArrayList<Integer> list = kmp(str, pattern);
				if(list.size() != 0) {
					System.out.println("1");
					return 1;
				}
				
				//reverse
				builder = builder.reverse();
				str = builder.toString();
				list = kmp(str, pattern);
				if(list.size() != 0) {
					System.out.println("1");
					return 1;
				}
			}
		}
		return 0;
	}
	
	static int calLeftDown(char[][] table, String pattern, int N, int M) {
		int patternLength = pattern.length();
		if(patternLength <= M && patternLength <= N) {
			for(int i=0;i<=N-patternLength;i++) {
				StringBuilder builder = new StringBuilder();
				for(int j=0;j<M && (i+j)<N;j++) {
					builder.append(table[i+j][j]);
				}
				String str = builder.toString();
				ArrayList<Integer> list = kmp(str, pattern);
				if(list.size() != 0) {
					System.out.println("1");
					return 1;
				}
				
				//reverse
				builder = builder.reverse();
				str = builder.toString();
				list = kmp(str, pattern);
				if(list.size() != 0) {
					System.out.println("1");
					return 1;
				}
			}
			
			for(int j=1;j<=M-patternLength;j++) {
				StringBuilder builder = new StringBuilder();
				for(int i=0;i<M && (i+j)<N;i++) {
					builder.append(table[i][j+i]);
				}
				String str = builder.toString();
				ArrayList<Integer> list = kmp(str, pattern);
				if(list.size() != 0) {
					System.out.println("1");
					return 1;
				}
				
				//reverse
				builder = builder.reverse();
				str = builder.toString();
				list = kmp(str, pattern);
				if(list.size() != 0) {
					System.out.println("1");
					return 1;
				}
			}
		
		}
		return 0;
	}
	
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			
			String pattern = br.readLine();
			String[] line1 = br.readLine().split("\\s");
			int N = Integer.parseInt(line1[0]);
			int M = Integer.parseInt(line1[1]);
			
			char[][] table = new char[N][M];
			for(int i=0;i<N;i++) {
				table[i] = br.readLine().toCharArray();
			}
			//input completed
			
			//row
			int flag = calRow(table, pattern, N, M);
			if(flag == 1) {
				return;
			}
			flag = calCol(table, pattern, N, M);
			if(flag == 1) {
				return;
			}
			flag = calLeftDown(table, pattern, N, M);
			if(flag == 1) {
				return;
			}
			flag = calLeftUp(table, pattern, N, M);
			if(flag == 1) {
				return;
			}
			
			System.out.println("0");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public static ArrayList<Integer> kmp(String str, String pattern) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] pi = getPi(pattern);
		int n = str.length(), m = pattern.length(), j = 0;
		char[] s = str.toCharArray();
		char[] p = pattern.toCharArray();
                // str - 전체 문자열, pattern - 찾을 문자열
		// j - 찾을 문자열의 비교 인덱스.
		// i - 전체 문자열과 비교할 인덱스이기 때문에 1씩 증가하기만 함. 절대 불규칙적으로 변경되지 않음.

		for (int i = 0; i < n; i++) {
			while (j > 0 && s[i] != p[j]) {
				// 중간 단계 뛰어넘기.
				// pi배열을 이용하여 j인덱스를 변경시킴으로써 while문 중단.
				j = pi[j - 1];
			}
			
			if (s[i] == p[j]) {
				if (j == m - 1) {
					// j는 비교 인덱스로써, 인덱스가 찾을 문자열의 크기에 도달하면 문자열 찾음.
					list.add(i - m + 1);
					// 여러 개의 찾을 문자열이 있을 수 있기 때문.
					j = pi[j];
				} else {
					j++;
				}
			}
		}
		return list;
	}
	
	public static int[] getPi(String pattern) {
		int m = pattern.length();
		int j = 0;
		char[] p = new char[m];
		int[] pi = new int[m];

		p = pattern.toCharArray();

		for (int i = 1; i < m; i++) {
			while (j > 0 && p[i] != p[j]) {
				j = pi[j - 1];
			}
			if (p[i] == p[j]) {
				pi[i] = ++j;
			}
		}
		return pi;
	}






}
