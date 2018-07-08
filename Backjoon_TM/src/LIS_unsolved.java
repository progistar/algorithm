import java.util.Scanner;

public class LIS_unsolved {
	char[] a;
	char[] b;
	int[][] table;
	boolean[][] flagTable;
	public void input() {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String b = sc.nextLine();
		this.a = a.toCharArray();
		this.b = b.toCharArray();
		sc.close();
		table = new int[a.length()][b.length()];
		flagTable = new boolean[a.length()][b.length()];
	}
	public void solve() {
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<b.length;j++) {
			}
		}
	}
	public static void main(String[] args) {
		
	}

}
