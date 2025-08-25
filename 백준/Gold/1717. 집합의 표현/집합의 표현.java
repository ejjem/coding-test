import java.util.*;
import java.io.*;

class Main {
    static class UnionFind{
        private int[] parent;
        private int[] rank;
        
        UnionFind(int n){
            parent = new int[n];
            rank = new int[n];
            makeSet(n);
        }

        private void makeSet(int n){
            for (int i = 0; i < n; i++) {
            parent[i] = i; 
            rank[i] = 0;    
            }
        }
        public int findSet(int x) {
            if (parent[x] != x) {
                parent[x] = findSet(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = findSet(x);
            int rootY = findSet(y);

            if (rootX == rootY) return; 

            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++; // 높이 증가
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        UnionFind uf = new UnionFind(n+1); 
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(flag == 0) uf.union(a, b);
            else if(flag == 1){
                if(uf.findSet(a) == uf.findSet(b)) sb.append("YES").append("\n");
                else sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }
}