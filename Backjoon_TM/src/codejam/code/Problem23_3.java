package codejam.code;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem23_3 {
	int C;
	int[] LENGTH;
	int[] A;
	int[] B;
	ArrayList<Long> maxHeap;
	ArrayList<Long> minHeap;
	long[] arr;
	long sum=1983;
	void input() {
		Scanner sc = new Scanner(System.in);
		C = sc.nextInt();
		LENGTH = new int[C]; 
		A = new int[C]; 
		B = new int[C];
		for(int i=0;i<C;i++) {
			LENGTH[i] = sc.nextInt();
			A[i] = sc.nextInt();
			B[i] = sc.nextInt();
		}
		sc.close();
	}
	long cal(long value, int a, int b) {
		return (value*a + b) % 20090711;
	}
	void makeMinHeap() {
		int here = minHeap.size()-1;
		while(here > 0 && minHeap.get((here-1)/2) > minHeap.get(here)) {
			long tmp = minHeap.get(here);
			minHeap.set(here, minHeap.get((here-1)/2));
			minHeap.set((here-1)/2, tmp);
			here = (here-1)/2;
		}
	}
	void makeMaxHeap() {
		int here = maxHeap.size()-1;
		while(here > 0 && maxHeap.get((here-1)/2) < maxHeap.get(here)) {
			long tmp = maxHeap.get(here);
			maxHeap.set(here, maxHeap.get((here-1)/2));
			maxHeap.set((here-1)/2, tmp);
			here = (here-1)/2;
		}
	}
	void makeHeap(int len, int a, int b, long[] arr) {
		for(int i=1;i<len;i++) {
			arr[i] = cal(arr[i-1], a, b);
			if(maxHeap.size() == minHeap.size()) {
				maxHeap.add(arr[i]);
				makeMaxHeap();
			}else {
				minHeap.add(arr[i]);
				makeMinHeap();
			}
			
			//rule 2.
			if(minHeap.size() != 0 && maxHeap.size() != 0 && (minHeap.get(0) < maxHeap.get(0))) {
				long min = minHeap.get(0); 	long max = maxHeap.get(0);
				popMinHeap();
				popMaxHeap();
				minHeap.add(max);
				maxHeap.add(min);
				//maxHeap.set(0, min);
				makeMinHeap();
				makeMaxHeap();
			}
			sum += maxHeap.get(0);
		}
		
		
	}
	/*int calMedian(int len) {
		int medianIndex = len/2 + 1;
		if(len %2 == 0)
			medianIndex = len/2 - 1;
		int value = -1;
		for(int i=0; i<medianIndex; i++) {
			value = popHeap();
			System.out.println("value : "+ value);
		}
		return value;
	}*/
	long popMinHeap() {
		long value = minHeap.remove(0);
		if(minHeap.size() == 0) {
			return -1;
		}
		minHeap.add(0, minHeap.remove(minHeap.size()-1));
		int index = 0;
		while(true) {
			int next = index;
			int left = index*2 +1;
			int right = index*2 +2;
			
			if(left >= minHeap.size())	break;
			if(minHeap.get(index) > minHeap.get(left)) 
				next = left;
			if(right < minHeap.size() && minHeap.get(next) > minHeap.get(right))
				next = right;
			
			if(next == index) break;
			
			//swap
			long tmp = minHeap.get(index);
			minHeap.set(index, minHeap.get(next));
			minHeap.set(next, tmp);
			
			index = next;
		}
		return value;
	}
	long popMaxHeap() {
		long value = maxHeap.remove(0);
		if(maxHeap.size() == 0) {
			return -1;
		}
		maxHeap.add(0, maxHeap.remove(maxHeap.size()-1));
		int index = 0;
		while(true) {
			int next = index;
			int left = index*2 +1;
			int right = index*2 +2;
			
			if(left >= maxHeap.size())	break;
			if(maxHeap.get(index) < maxHeap.get(left)) 
				next = left;
			if(right < maxHeap.size() && maxHeap.get(next) < maxHeap.get(right))
				next = right;
			
			if(next == index) break;
			
			//swap
			long tmp = maxHeap.get(index);
			maxHeap.set(index, maxHeap.get(next));
			maxHeap.set(next, tmp);
			
			index = next;
		}
		return value;
	}
	long solve(int len, int a, int b) {
		arr = new long[len];
		maxHeap = new ArrayList<Long>();
		minHeap = new ArrayList<Long>();
		arr[0] = 1983L;	maxHeap.add(1983L);
		makeHeap(len, a, b, arr);
		return sum;
		//return calMedian(len);
	}
	public static void main(String[] args) {
		Problem23_3 m = new Problem23_3();
		m.input();
		for(int i=0;i<m.C;i++) {
			m.sum = 1983;
			System.out.println(m.solve(m.LENGTH[i], m.A[i], m.B[i]) % 20090711);
		}
	}

}
