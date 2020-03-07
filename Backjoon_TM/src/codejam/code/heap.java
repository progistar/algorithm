package codejam.code;
import java.util.ArrayList;
import java.util.Scanner;

public class heap {
	int N;
	int[] arr;
	ArrayList<Integer> heap;
	void input() {
		Scanner sc  = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
	}
	void solve() {
		int answer;
		heap = new ArrayList<Integer>();
		for(int i=0;i<N;i++) {
			if(arr[i] != 0) {
				push(arr[i]);
			}else {
				//pop
				answer = pop();
				System.out.println(answer);
			}
		}
	}
	
	void push(int value) {
		heap.add(value);
		int index = heap.size() -1;
		while(index > 0 && heap.get((index-1)/2) < heap.get(index)) {
			int tmp = heap.get(index);
			heap.set(index, heap.get((index-1)/2));
			heap.set((index-1)/2, tmp);
			index = (index-1)/2;
		}
	}
	
	int pop() {
		if(heap.size() == 0) {
			return 0;
		}else if(heap.size() == 1) {
			return heap.remove(0);
		}else {
			int value = heap.get(0);
			int last = heap.remove(heap.size()-1);
			heap.set(0, last);
			int here = 0;
			while(true) {
				int left = here*2 + 1;
				int right = here*2 +2;
				int next = here;
				
				if(left >= heap.size()) break;
				if(heap.get(here) < heap.get(left)) 
					next = left;
				if(right < heap.size() && heap.get(next) < heap.get(right))
					next = right;
				if(next == here)
					break;
				
				int tmp = heap.get(here);
				heap.set(here, heap.get(next));
				heap.set(next, tmp);

				here = next;
			}
			return value;
		}
		
		
	}
	
	public static void main(String[] args) {
		heap m = new heap();
		m.input();
		m.solve();
	}

}
