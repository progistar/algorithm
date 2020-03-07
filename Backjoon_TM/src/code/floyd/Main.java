package code.floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	final static int maxV = 501;
	int[][] adj = new int[maxV][maxV];
	int[][] adj_vertex = new int[maxV][maxV];
	int[][] via = new int[maxV][maxV];
	int[] vertex;
	int V; int E;
	int testCase;
	Pair[] pair;
	int[] answer;
	
	void init() {
		for(int i=0;i<maxV;i++) {
			for(int j=0;j<maxV;j++) {
				adj[i][j] = 99999999;
				adj_vertex[i][j] = 99999999;
				via[i][j] = -1;
			}
		}
	}
	
	void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] line1 = br.readLine().split("\\s");
			this.V = Integer.parseInt(line1[0]); this.E = Integer.parseInt(line1[1]); 
			vertex = new int[V];
			String[] line2 = br.readLine().split("\\s");
			for(int i=0;i<V;i++) {
				vertex[i] = Integer.parseInt(line2[i]);
			}
			for(int i=0;i<E;i++) {
				String[] line3 = br.readLine().split("\\s");
				int s = Integer.parseInt(line3[0]);
				int d = Integer.parseInt(line3[1]);
				int w = Integer.parseInt(line3[2]);
				adj[s][d] = adj[d][s] = w;
			}
			
			testCase = Integer.parseInt(br.readLine());
			pair = new Pair[testCase];
			answer = new int[testCase];
			for(int i=0;i<testCase;i++) {
				String[] line4 = br.readLine().split("\\s");
				int s = Integer.parseInt(line4[0]);
				int d = Integer.parseInt(line4[1]);
				pair[i] = new Pair(s, d);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	void solution() {
		for(int i=0;i<testCase;i++) {
			//initialize
			floyd();
			ArrayList<Integer> path = new ArrayList<Integer>();
			reconstruct(pair[i].start, pair[i].end, path);
			for(int j=0;j<path.size();j++) {
				System.out.print(path.get(j)+"   ");
			}
			System.out.println();System.out.println();
 		}
	}
	
	
	void floyd(){
		for(int i=0;i<V;i++) {
			adj[i][i] = 0;
		}
		for(int k=0;k<V;k++) {
			for(int s=0;s<V;s++) {
				for(int d=0;d<V;d++) {
					if(adj[s][d] > adj[s][k] + adj[k][d] + vertex[k]) {
						via[s][d] = k;
						adj[s][d] = adj[s][k] + adj[k][d] + vertex[k];
					}
				}
			}
		}
	}
	
	void reconstruct(int s, int d, ArrayList<Integer> path) {
		if(via[s][d] == -1) {
			path.add(s);
			if(s != d) path.add(d);
		}else {
			int w = via[s][d];
			reconstruct(s, w, path);
			path.remove(path.size()-1);
			reconstruct(w, d, path);
		}
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.init();
		main.input();
		main.solution();
	}

}

class Pair{
	int start;
	int end;
	Pair(int start, int end){
		this.start = start;
		this.end = end;
	}
}