import java.io.*;
import java.util.*;

class Main {
    static int N, M, start, end, cnt;
    static ArrayList<int[]>[] graph, rev;
    static int[] indegree;
    static boolean[] visited;
    static long[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        rev = new ArrayList[N+1];
        for(int i=0; i<N+1; i++){
            graph[i] = new ArrayList<>();
            rev[i] = new ArrayList<>();
        }
        indegree = new int[N+1];
        visited = new boolean[N+1];
        dist = new long[N+1];
        Arrays.fill(dist, Long.MIN_VALUE);
        cnt = 0;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[]{v, w});
            rev[v].add(new int[]{u, w});
            indegree[v] += 1;
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i=1; i<N+1; i++){
            if(indegree[i] == 0) queue.offerLast(i);
        }
        dist[start] = 0;
        while(!queue.isEmpty()){
            int cur = queue.pollFirst();
            for(int[] n : graph[cur]){
                int ne = n[0];
                indegree[ne] -= 1;
                if(indegree[ne] == 0) queue.offerLast(ne);
                if(dist[cur] != Long.MIN_VALUE){
                    long totalw = n[1] + dist[cur];
                    if(dist[ne] < totalw){ dist[ne] = totalw;}
                }
            }
        }
        sb.append(dist[end]).append("\n");
        queue.offerLast(end);
        while(!queue.isEmpty()){
            int cur = queue.pollFirst();
            for(int[] n : rev[cur]){
                int nv = n[0];
                int nw = n[1];
                if(dist[nv] == dist[cur] - nw){
                    cnt ++;
                    if(!visited[nv]){
                        visited[nv] = true;
                        queue.offerLast(nv);
                    }
                }
            }
        }
        sb.append(cnt);
        System.out.println(sb);
    }
}