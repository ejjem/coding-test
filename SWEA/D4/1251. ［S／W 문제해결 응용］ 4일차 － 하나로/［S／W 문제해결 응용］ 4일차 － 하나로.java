import java.util.*;
import java.io.*;

public class Solution {
	
	static class Edge implements Comparable<Edge>{
		int start;
		int end;
		long weight;
		Edge(int start, int end, long weight){
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.weight, o.weight);
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
	static int[] islandsY;
	static int[] islandsX;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<T+1;tc++) {
			long sum = 0;
			int edgecnt = 0;
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(br.readLine());
			UnionFind uf = new UnionFind(N);
			Edge[] edges = new Edge[N*(N-1)/2];
			islandsX = new int[N]; islandsY = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				islandsY[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				islandsX[i] = Integer.parseInt(st.nextToken());
			}
			double E = Double.parseDouble(br.readLine());
			int idx = 0;
			for(int i=0; i<N; i++) {
				for(int j=i+1; j<N; j++) {
					long dx = (long) islandsX[i] - islandsX[j];
					long dy = (long) islandsY[i] - islandsY[j];
					long w = dx*dx + dy*dy;
					edges[idx++] = new Edge(i, j, w);
				}
			}
			Arrays.sort(edges);
			for(Edge e : edges) {
				if(uf.union(e.start, e.end)) {
					sum += e.weight;
					if(++edgecnt == N - 1) break;
				}
			}
			long answer = Math.round(sum * E);
			sb.append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush(); bw.close();
	}
}
