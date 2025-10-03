import java.io.*;
import java.util.*;

class Main {
    static int n, d, c, a, b, s, cnt;
    static long time;
    static List<int[]>[] graph;
    static void dijkstra(){
        long[] dist = new long[n+1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[c] = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>(new Comparator<long[]>(){
            @Override
            public int compare(long[] o1, long[] o2){
                if(o1[1] == o2[1]) return Long.compare(o1[0], o2[0]);
                return Long.compare(o1[1], o2[1]);
            }
        });
        pq.offer(new long[]{c, 0});
        while(!pq.isEmpty()){
            long[] cur = pq.poll();
            int v = (int)cur[0];
            long w = cur[1];
            if(dist[v] != w) continue;
            for(int[] n : graph[v]){
                int nv = n[0];
                int nw = n[1];
                long tw = w + nw;
                if(dist[nv] > tw){
                    dist[nv] = tw;
                    pq.add(new long[]{nv, tw});
                }
            }
        }
        for(int i=1; i<n+1; i++){
            if(dist[i] != Long.MAX_VALUE){
                cnt ++;
                time = Math.max(dist[i], time);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<T+1; tc++){
            cnt = 0; time = 0;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken()); // 시작
            graph = new ArrayList[n+1];
            for(int i=0; i<n+1; i++) graph[i] = new ArrayList<>();
            for(int i=0; i<d; i++){
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                s = Integer.parseInt(st.nextToken());
                graph[b].add(new int[]{a, s});
            }
            dijkstra();
            sb.append(cnt).append(" ").append(time).append("\n");
        }
        bw.write(sb.toString()); bw.flush(); bw.close();
    }
}