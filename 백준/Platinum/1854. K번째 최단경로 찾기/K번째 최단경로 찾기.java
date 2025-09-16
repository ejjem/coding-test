import java.util.*;
import java.io.*;

class Main {
    static int n, m, k;
    static List<int[]>[] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        for(int i=1; i<n+1; i++) graph[i] = new ArrayList<>();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[]{v, w});
        }
        //dijkstra 구현
        
        PriorityQueue<Integer>[] dist = new PriorityQueue[n+1];
        for(int i=1; i<n+1; i++) dist[i] = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{1, 0});
        dist[1].offer(0);
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int e = cur[0]; int w = cur[1];
            if(dist[e].size() == k && dist[e].peek() < w) continue;
            for(int[] n : graph[e]){
                int ne = n[0]; int nw = n[1];
                int totalw = w + nw;
                if(dist[ne].size() < k){
                    dist[ne].offer(totalw);
                    pq.add(new int[]{ne, totalw});
                }
                else if(dist[ne].size() == k){
                    if(dist[ne].peek() > totalw){
                        dist[ne].poll();
                        dist[ne].offer(totalw);
                        pq.add(new int[]{ne, totalw});
                    }
                }
            }
        }
        for(int i=1; i<n+1; i++){
            if(dist[i].size() < k){
                sb.append("-1").append("\n");
            }
            else if(dist[i].size() == k){
                sb.append(dist[i].peek()).append("\n");
            }
        }
        bw.write(sb.toString()); bw.flush(); bw.close();
    }
}