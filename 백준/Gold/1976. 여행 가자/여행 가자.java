import java.util.*;
import java.io.*;

class Main {
    static class UnionFind{
        private int[] parents;
        private int[] rank;

        UnionFind(int N){
            parents = new int[N];
            rank = new int[N];
            makeSet(N);
        }

        private void makeSet(int N){
            for(int i=0; i<N; i++){
                parents[i] = i;
                rank[i] = 0;
            }
        }

        public int findSet(int x){
            if(parents[x] != x){
                parents[x] = findSet(parents[x]);
            }
            return parents[x];
        }
        public boolean union(int a, int b){
            int rootA = findSet(a); int rootB = findSet(b);
            if(rootA == rootB) return false;
            else{
                if(rank[a] > rank[b]) parents[rootB] = rootA;
                else if(rank[a] < rank[b]) parents[rootA] = rootB;
                else{
                    parents[rootB] = rootA; rank[a] ++;
                }         
            }
            return true;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        UnionFind uf = new UnionFind(N);
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                if(Integer.parseInt(st.nextToken()) == 1) uf.union(i, j);
            }
        }
        st = new StringTokenizer(br.readLine());
        int root = uf.findSet(Integer.parseInt(st.nextToken()) - 1);
        int idx;
        for(idx=1; idx<M; idx++){
            if(uf.findSet(Integer.parseInt(st.nextToken())-1) != root) break;
        }
        if(idx == M) System.out.println("YES");
        else System.out.println("NO");
    }
}