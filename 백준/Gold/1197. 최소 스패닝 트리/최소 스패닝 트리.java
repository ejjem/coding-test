import java.util.*;
import java.io.*;

class Main {
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
			if(this.weight == o.weight) return Integer.compare(this.end, o.end);
			return Long.compare(this.weight, o.weight);
		}
	}
	
	static Edge[] edges;
	
	static class UnionFind {
		private int[] parents;
		
		UnionFind(int N){
			parents = new int[N];
			makeSet(N);
		}
		
		private void makeSet(int N) {
			for(int i=0; i<N; i++) {
				parents[i] = i;
			}
		}
		
		public int findSet(int x) {
			if(parents[x] != x) {
				parents[x] = findSet(parents[x]);
			}
			return parents[x];
		}
		
		public boolean union(int a, int b) {
			int rootA = findSet(a);
			int rootB = findSet(b);
			if(rootA == rootB) return false;
			else {
				if(rootA < rootB) {
					parents[rootB] = rootA;
				}
				else {
					parents[rootA] = rootB;
				}
			}
			return true;
		}
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        UnionFind uf = new UnionFind(V);
        edges = new Edge[E];
        long answer = 0;
        for(int i=0; i<E; i++) {
        	st = new StringTokenizer(br.readLine());
        	int s = Integer.parseInt(st.nextToken())-1;
        	int e = Integer.parseInt(st.nextToken())-1;
        	long w = Long.parseLong(st.nextToken());
        	edges[i] = new Edge(s, e, w);
        }
        Arrays.sort(edges);
        for(int i=0; i<E; i++) {
        	if(uf.union(edges[i].start, edges[i].end)) {
        		answer += edges[i].weight;
        	}
        }
        System.out.println(answer);
    }
}