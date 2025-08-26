import java.util.*;
import java.io.*;

public class Solution {
	static class UnionFind{
		private int[] parent;
		private int[] rank;
		UnionFind(int n){
			this.parent = new int[n];
			this.rank = new int[n];
			makeSet(n);
		}
		
		private void makeSet(int n) {
			for(int i=0; i<n; i++) {
				parent[i] = i;
				rank[i] = 0;
			}
		}
		
		public int findSet(int x) {
			if(parent[x] != x) {
				parent[x] = findSet(parent[x]);
			}
			return parent[x];
		}
		
		public void union(int a, int b) {
			int rootA = findSet(a);
			int rootB = findSet(b);
			if(rootA == rootB) return;
			else {
				if(rank[rootA] > rank[rootB]) parent[rootB] = rootA;
				else if(rank[rootA] < rank[rootB]) parent[rootA] = rootB;
				else {
					parent[rootA] = rootB;
					rank[rootB] ++;
				}
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
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken());
			UnionFind uf = new UnionFind(n+1);
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				int flag = Integer.parseInt(st.nextToken()); int a = Integer.parseInt(st.nextToken()); int b = Integer.parseInt(st.nextToken());
				if(flag == 0) {
					uf.union(a, b);
				}
				else if(flag == 1) {
					if(uf.findSet(a) == uf.findSet(b)) sb.append("1");
					else sb.append("0");
				}
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush(); bw.close();
	}
}
