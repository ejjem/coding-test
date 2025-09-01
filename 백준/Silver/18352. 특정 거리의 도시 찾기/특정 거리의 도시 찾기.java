import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<Integer>[] g = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g[a].add(b);                 // 방향 그래프
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);
        dist[X] = 0;

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(X);

        while (!q.isEmpty()) {
            int u = q.poll();
            if (dist[u] == K) continue;  // K보다 더 먼 층은 굳이 확장하지 않음
            for (int v : g[u]) {
                if (dist[v] != -1) continue;
                dist[v] = dist[u] + 1;
                q.offer(v);
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean found = false;
        for (int i = 1; i <= N; i++) {
            if (dist[i] == K) {
                sb.append(i).append('\n');
                found = true;
            }
        }
        System.out.print(found ? sb.toString() : "-1\n");
    }
}