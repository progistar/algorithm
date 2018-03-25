package routing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Dijkstra
 * 
 * BFS with Priority Queue.
 * 
 * Priority Queue : Min-Heap
 * 
 * 
 * @author progi
 *
 */

class Route implements Comparable<Route>{
	ArrayList<Route> connections = new ArrayList<Route>();
	ArrayList<Double> noises = new ArrayList<Double>();
	double currentNoise = Double.MAX_VALUE;
	boolean isVisited = false;
	
	@Override
	public int compareTo(Route o) {
		// TODO Auto-generated method stub
		if(this.currentNoise < o.currentNoise) return -1;
		else if(this.currentNoise > o.currentNoise) return 1;
		
		return 0;
	}
	
	
}

public class Routing {

	public static ArrayList<Route> minHeap = new ArrayList<Route>();
	
	public static void main(String[] args) throws IOException {
		Route[][] routes = readInput();
		
		for(int i=0; i<routes.length; i++) System.out.println(dijkstra(routes[i]));
		
	}
	
	
	public static double dijkstra(Route[] routes) {
		PriorityQueue<Route> PQ = new PriorityQueue<Route>();
		PQ.add(routes[0]);
		
		while(!PQ.isEmpty()) {
			Route curRoute = PQ.poll();
			if(curRoute == routes[routes.length-1]) break;
			// Relax
			int sizeOfChildren = curRoute.connections.size();
			double curNoise = curRoute.currentNoise;
			curRoute.isVisited = true;

			for(int i=0; i<sizeOfChildren; i++) {
				if(!curRoute.connections.get(i).isVisited && curRoute.connections.get(i).currentNoise > curRoute.noises.get(i) + curNoise) {
					curRoute.connections.get(i).currentNoise = curRoute.noises.get(i) + curNoise;
					curRoute.connections.get(i).isVisited = true;
					PQ.add(curRoute.connections.get(i));
				}
			}
			
			
		}
		return Math.pow(10, routes[routes.length-1].currentNoise);
	}
	
	public static Route [][] readInput() throws IOException{
		Route[][] inputs = null;
		BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(BR.readLine());

		inputs = new Route[n][];
		
		for(int i=0; i<n; i++) {
			String[] str = BR.readLine().split("\\s");
			int nodes = Integer.parseInt(str[0]);
			int edges = Integer.parseInt(str[1]);
			inputs[i] = new Route[nodes];
			
			for(int j=0; j<inputs[i].length; j++) {
				inputs[i][j] = new Route();
			}
			
			inputs[i][0].currentNoise = .0;
			
			for(int j=0; j<edges; j++) {
				str = BR.readLine().split("\\s");
				int source = Integer.parseInt(str[0]);
				int dest = Integer.parseInt(str[1]);
				double noise = Math.log10(Double.parseDouble(str[2]));
				
				inputs[i][source].connections.add(inputs[i][dest]);
				inputs[i][source].noises.add(noise);
				inputs[i][dest].connections.add(inputs[i][source]);
				inputs[i][dest].noises.add(noise);
			}
			
		}
		
		BR.close();
		
		return inputs;
	}
}
