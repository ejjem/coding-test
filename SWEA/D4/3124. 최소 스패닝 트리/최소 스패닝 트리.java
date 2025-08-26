import java.util.*;
import java.io.*;

public class Solution {
	
	static class Edge implements Comparable<Edge>{
		int start;
		int end;
		int weight;
		Edge(int start, int end, int weight){
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
		
		
	}
	
	
	static class UnionFind{
		private int[] parent;
		UnionFind(int n){
			this.parent = new int[n];
			makeSet(n);
		}
		
		private void makeSet(int n) {
			for(int i=0; i<n; i++) {
				parent[i] = i;
			}
		}
		
		public int findSet(int x) {
			if(parent[x] != x) {
				parent[x] = findSet(parent[x]);
			}
			return parent[x];
		}
		
		public boolean union(int a, int b) {
			int rootA = findSet(a);
			int rootB = findSet(b);
			if(rootA == rootB) return false;
			else {
				if(rootA < rootB) parent[rootB] = rootA;
				else parent[rootA] = rootB;
				return true;
			}
			
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<T+1;tc++) {
			long answer = 0;
			int edgecnt = 0;
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
			UnionFind uf = new UnionFind(N);
			Edge[] edges = new Edge[M];
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken())-1;
				int end = Integer.parseInt(st.nextToken())-1;
				int weight = Integer.parseInt(st.nextToken());
				edges[i] = new Edge(start, end, weight);
			}
			Arrays.sort(edges);
			for(int i=0; i<M; i++) {
				if(uf.union(edges[i].start, edges[i].end)) {
					answer += edges[i].weight;
					if(++edgecnt == N-1) break;
				}
				else continue;
			}
			
			
			sb.append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush(); bw.close();
	}
}
