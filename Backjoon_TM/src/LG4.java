import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LG4 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, Edge> srcToDst = new HashMap<>();
		try {
			String[] line1 = br.readLine().split("\\s");
			int N =Integer.parseInt(line1[0]);
			int M=Integer.parseInt(line1[1]);;
			int K=Integer.parseInt(line1[2]);
			
			for(int i=0;i<M;i++) {
				String[] line = br.readLine().split("\\s");
				int src = Integer.parseInt(line[0]);
				int dst = Integer.parseInt(line[1]);
				EdgeInfo ei = new EdgeInfo(Integer.parseInt(line[2]), Integer.parseInt(line[3]));
				
				if(srcToDst.containsKey(src)) {
					Edge edge = srcToDst.get(src);
					edge.addEdge(dst, ei);
				}else {
					Edge edge = new Edge(dst, ei);
					srcToDst.put(src, edge);
				}
				
				//non directed
				if(srcToDst.containsKey(dst)) {
					Edge edge = srcToDst.get(dst);
					edge.addEdge(src, ei);
				}else {
					Edge edge = new Edge(src, ei);
					srcToDst.put(dst, edge);
				}
			}
			int PMax = 100000000;
			int PMin = 0;
			int P = 10000;
			//solve
			while(true) {
				long value = solve(N, srcToDst, P, K);
				if(PMin == P) {
					break;
				}
				if(K > value) {
					PMin = P;
					P=(int)(PMax+P)/2;
				}else if(K<value){
					PMax = P;
					P=(int)(P+PMin)/2;
				}else {
					break;
				}
			}
			System.out.println(P);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static long solve(int N, HashMap<Integer, Edge> srcToDst, int P, int K) {
		//solve
		long[] values = new long[N+1];
		for(int i=1;i<N+1;i++) {
			values[i] = 999999999;
		}
		PriorityQueue<Vertex> queue = new PriorityQueue<>();
		int start = 1;
		values[start] = 0;
		queue.add(new Vertex(start, 0));
		
		while(!queue.isEmpty()) {
			Vertex now = queue.poll();
			long hereValue = now.value;
			int hereIndex = now.number;
			
			if(hereValue > values[hereIndex])
				continue;
			Edge edges = srcToDst.get(hereIndex);
			for(Map.Entry<Integer, EdgeInfo> item : edges.dstEdge.entrySet()) {
				int dstIndex = item.getKey();
				EdgeInfo eiValue = item.getValue();
				int calculated = calculate(P, eiValue.T, eiValue.C);
				if(calculated > 1000000000) {
					return 999999999;
				}
				if(values[dstIndex] > values[hereIndex] + calculated) {
					values[dstIndex] = values[hereIndex] + calculated;
					queue.offer(new Vertex(dstIndex, values[dstIndex]));
				}
			}
		}
		return values[N];
	}
	static int calculate(int P, int T, int C) {
		if(P>T) {
			return (int)(C*Math.pow((P-T), 2.0));
		}
		return 0;
	}
}

class Vertex implements Comparable<Vertex>{
	int number;
	long value;
	
	Vertex(int number, long value){
		this.number = number;
		this.value = value;
	}
	
	@Override
	public int compareTo(Vertex o) {
		return this.value <= o.value ? -1 : 1;
	}
	
}

class Edge{
	HashMap<Integer, EdgeInfo> dstEdge = new HashMap<>();
	Edge(int dst, EdgeInfo ei){
		dstEdge.put(dst, ei);
	}
	public HashMap<Integer, EdgeInfo> getDstEdge() {
		return dstEdge;
	}
	public void addEdge(int dst, EdgeInfo edgeInfo){
		dstEdge.put(dst, edgeInfo);
	}
}
class EdgeInfo{
	int C;
	int T;
	EdgeInfo(int C, int T){
		this.C = C;
		this.T= T;
	}
}
