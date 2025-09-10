import java.util.*;
import java.io.*;

class Main {
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
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] trueGroup = new int[n];
        for(int i=0; i<n; i++) {
        	trueGroup[i] = Integer.parseInt(st.nextToken());
        }
        UnionFind uf = new UnionFind(N+1);
        int answer = 0;
        ArrayList<Integer>[] party = new ArrayList[M];
        int[] firstPeople = new int[M];
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int count = Integer.parseInt(st.nextToken());
        	firstPeople[i] = Integer.parseInt(st.nextToken());
        	for(int j=0; j<count-1; j++) {
        		uf.union(firstPeople[i], Integer.parseInt(st.nextToken()));
        	}
        }
        for(int i=0; i<M; i++) {
        	int tmp = uf.findSet(firstPeople[i]);
        	boolean flag = true;
        	for(int j=0; j<n; j++) {
        		if(tmp == uf.findSet(trueGroup[j])) {
        			flag = false; break;
        		}
        	}
        	if(flag) answer ++;
        }
        System.out.println(answer);
    }
}