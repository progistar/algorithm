import java.util.ArrayList;
import java.util.Scanner;

public class Minkyun {
	private int N;
	private int[] numbers;
	public void input() {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		numbers = new int[N];
		for(int i=0;i<N;i++) {
			numbers[i] = sc.nextInt();
		}
		sc.close();
	}
	
	public int solve() {
		ArrayList<Node> list = new ArrayList<Node>();
		list.add(new Node());
		int answer = -1;
		for(int i=0;i<N;i++) {
			int number = numbers[i];
			int max = -1;
			for(int j=list.size()-1;j>=0;j--) {
				int key = list.get(j).key;
				if(number > key) {
					int value = list.get(j).value;
					if(max < value) {
						max = value;
					}
				}
			}
			list.add(new Node(number, max+1));
			if(max+1 > answer) {
				answer = max+1;
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Minkyun main = new Minkyun();
		main.input();
		System.out.println(main.solve());
	}
}
class Node{
	int key;
	int value;
	public Node() {
		key = 0;
		value = 0;
	}
	public Node(int key, int value) {
		this.key = key;
		this.value = value;
	}
}
