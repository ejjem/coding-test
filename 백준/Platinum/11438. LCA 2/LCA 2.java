import java.io.*;
import java.util.*;

class Main {
    static ArrayList<Integer>[] tree;
    static int N, M;
    static int LOG;
    static int[] depth;
    static int[][] parent;

    static void BFS(int root){
        Arrays.fill(depth, -1);
        ArrayDeque<Integer> q = new ArrayDeque<>();
        depth[root] = 0;
        parent[0][root] = 0;
        q.offerLast(root);
        while(!q.isEmpty()){
            int cur = q.pollFirst();
            for(int n : tree[cur]){
                if(depth[n] != -1) continue;
                depth[n] = depth[cur] + 1;
                parent[0][n] = cur;
                q.offerLast(n);
            }
        }

        for(int k=1; k < LOG; k++){
            for(int v = 1; v <= N; v++){
                int anc = parent[k-1][v];
                if(anc == 0) parent[k][v] = 0;
                else parent[k][v] = parent[k-1][anc];
            }
        }
    }
    static int LCA(int a, int b){
        int u = 0; int v = 0;
        if(depth[a] > depth[b]) {u = a; v = b;}
        else {u = b; v = a;}
        int diff = depth[u] - depth[v];
        u = kthAnc(u, diff);
        if(u == v) return u;

        for (int k = LOG - 1; k >= 0; k--) {
            if (parent[k][u] != parent[k][v]) {
                u = parent[k][u];
                v = parent[k][v];
            }
        }
        return parent[0][u];
    }
    static int kthAnc(int u, int diff) {
    int step = 0;                 
    while (diff > 0 && u != 0) {
        if ((diff % 2) == 1) {
            u = parent[step][u];
        }
        diff /= 2;                
        step++;
    }
    return u;
}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];
        for(int i=1; i<N+1; i++) tree[i] = new ArrayList<>();
        LOG = 1;
        while( (1 << LOG) <= N) LOG++;
        depth = new int[N+1];
        parent = new int[LOG][N+1];
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }
        BFS(1);

        M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(LCA(a, b)).append("\n");
        }
        bw.write(sb.toString()); bw.flush(); bw.close();
    }
}