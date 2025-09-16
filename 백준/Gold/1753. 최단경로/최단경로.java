import java.io.*;
import java.util.*;

class Main {
    static int V, E;
    static List<int[]>[] graph;
    static int[] dijkstra(int start){
        int[] dist = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        dist[start] = 0;
        pq.offer(new int[]{start, 0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int e = cur[0]; int w = cur[1];
            if(dist[e] != w) continue;
            for(int[] n : graph[e]){
                int ne = n[0]; int nw = n[1];
                int totalw = nw + w;
                if(dist[ne] > totalw){
                    dist[ne] = totalw;
                    pq.offer(new int[]{ne, totalw});
                }
            }
        }
        return dist;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st= new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        V = Integer.parseInt(st.nextToken()); E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        graph = new ArrayList[V+1];
        for(int i=1; i<V+1; i++) graph[i] = new ArrayList<>();
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[]{v, w});
        }
        int[] result = dijkstra(start);
        for(int i=1; i<V+1; i++){
            if(result[i] == Integer.MAX_VALUE){
                sb.append("INF").append("\n");
            }
            else{
                sb.append(result[i]).append("\n");
            }
        }
        bw.write(sb.toString()); bw.flush(); bw.close();
    }
}