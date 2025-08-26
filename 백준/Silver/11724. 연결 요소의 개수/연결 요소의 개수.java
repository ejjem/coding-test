import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static HashMap<Integer, ArrayList<Integer>> graph;
	static boolean[] visited;
	
	static class UnionFind {
		private int[] parents;
		private int[] rank;
		
		UnionFind(int N) {
			this.parents = new int[N];
			this.rank = new int[N];
			makeSet(N);
		}
		private void makeSet(int N) {
			for(int i=0; i<N; i++) {
				parents[i] = i;
			}
		}
		
		public int findSet(int x) {
			if(parents[x] != x) parents[x] = findSet(parents[x]);
			return parents[x];
		}
		
		public void union(int a, int b) {
			int rootA = findSet(a);
			int rootB = findSet(b);
			if(rootA == rootB) return;
			else {
				if(rank[rootA] > rank[rootB]) parents[rootB] = rootA;
				else if(rank[rootA] < rank[rootB]) parents[rootA] = rootB;
				else {
					parents[rootB] = rootA;
					rank[rootA] ++;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
		graph = new HashMap<>();
		UnionFind uf = new UnionFind(N);
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1; int b= Integer.parseInt(st.nextToken()) - 1;
			uf.union(a, b);
		}
		HashSet<Integer> root = new HashSet<>();
		for(int i=0; i<N; i++) {
			root.add(uf.findSet(i));
		}
		System.out.println(root.size());
	}
}
