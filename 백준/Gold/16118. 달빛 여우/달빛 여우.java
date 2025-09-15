import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static List<int[]>[] graph;

    static long[][] dijkstraWolf() {
        long[][] dist = new long[N+1][2];
        for (int i = 0; i < N+1; i++) {
            dist[i] = new long[] { -1L, -1L };
        }
        dist[1] = new long[] { 0L, -1L };

        PriorityQueue<long[]> pq = new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return Long.compare(o1[1], o2[1]);
            }
        });

        pq.offer(new long[] { 1L, 0L, 4L });
        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int e = (int) cur[0];
            long w = cur[1];
            int speed = (int) cur[2];

            int flag = (speed == 4) ? 0 : 1; // speed==4 -> 다음 이동 빠른 차례
            if (dist[e][flag] != w) continue;

            for (int[] n : graph[e]) {
                int ne = n[0];
                int nw = n[1];
                long add = (speed == 4) ? (1L * nw) : (4L * nw);
                long totalw = w + add;

                if (speed == 4) {
                    if (dist[ne][1] == -1 || dist[ne][1] > totalw) {
                        dist[ne][1] = totalw;
                        pq.offer(new long[] { ne, totalw, 1L });
                    }
                } else {
                    if (dist[ne][0] == -1 || dist[ne][0] > totalw) {
                        dist[ne][0] = totalw;
                        pq.offer(new long[] { ne, totalw, 4L });
                    }
                }
            }
        }
        return dist;
    }

    static long[] dijkstraFox() {
        long[] dist = new long[N+1];
        Arrays.fill(dist, -1L);
        dist[1] = 0L;

        PriorityQueue<long[]> pq = new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return Long.compare(o1[1], o2[1]);
            }
        });

        pq.offer(new long[] { 1L, 0L, 2L });
        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int e = (int) cur[0];
            long w = cur[1];
            int speed = (int) cur[2]; // 항상 2

            if (dist[e] != w) continue;

            for (int[] n : graph[e]) {
                int ne = n[0];
                int nw = n[1];
                long totalw = w + 2L * nw; // 여우는 항상 +2*w
                if (dist[ne] == -1) {
                    dist[ne] = totalw;
                    pq.offer(new long[] { ne, totalw, speed });
                } else if (dist[ne] > totalw) {
                    dist[ne] = totalw;
                    pq.offer(new long[] { ne, totalw, speed });
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[] { v, w });
            graph[v].add(new int[] { u, w });
        }
        long[][] wolf = dijkstraWolf();
        long[] fox = dijkstraFox();
        int answer = 0;
        for (int i = 2; i < N+1; i++) {
            long w0 = wolf[i][0], w1 = wolf[i][1];
            long wolfBest;
            if (w0 == -1 && w1 == -1) wolfBest = -1;
            else if (w0 == -1)        wolfBest = w1;
            else if (w1 == -1)        wolfBest = w0;
            else                      wolfBest = Math.min(w0, w1);

            if (fox[i] != -1 && (wolfBest == -1 || fox[i] < wolfBest)) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
