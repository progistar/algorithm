package code.floyd;

import java.util.ArrayList;

public class Floyd {
	final int maxValue = 9999;
	int V; //정점의 개수
	int[][] adj = new int[maxValue][maxValue];
	int[][] via = new int[maxValue][maxValue];
	
	void floyd(){
		for(int i=0;i<V;i++) {
			adj[i][i] = 0;
		}
		
		for(int k=0;k<V;k++) {
			for(int s=0;s<V;s++) {
				for(int d=0;d<V;d++) {
					if(adj[s][d] > adj[s][k] + adj[k][d]) {
						via[s][d] = k;
						adj[s][d] = adj[s][k] + adj[k][d];
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
	
	
}
