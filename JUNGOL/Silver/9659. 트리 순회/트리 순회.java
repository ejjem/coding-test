import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int root = 1;

        List<Integer>[] child = new ArrayList[N + 1];
        int[] parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            child[i] = new ArrayList<>();
        }

        StringTokenizer st;

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int cid = Integer.parseInt(st.nextToken());
            int pid = Integer.parseInt(st.nextToken());

            child[pid].add(cid);
            parent[cid] = pid;
        }

        int target = Integer.parseInt(br.readLine());

        // 1. 루트와의 거리
        int rootDist = 0;
        int cur = target;

        while (cur != root) {
            cur = parent[cur];
            rootDist++;
        }

        // 2. 본인 포함 자손노드 개수
        // 3. 가장 먼 자손노드와의 거리
        int subTreeSize = 0;
        int downDist = 0;

        Deque<int[]> queue = new ArrayDeque<>();
        queue.offerLast(new int[]{target, 0});

        while (!queue.isEmpty()) {
            int[] curNode = queue.pollFirst();

            int n = curNode[0];
            int d = curNode[1];

            subTreeSize++;
            downDist = Math.max(downDist, d);

            for (int next : child[n]) {
                queue.offerLast(new int[]{next, d + 1});
            }
        }

        // 4. 가장 먼 노드와의 거리
        int farDist = 0;

        Deque<int[]> queue2 = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];

        queue2.offerLast(new int[]{target, 0});
        visited[target] = true;

        while (!queue2.isEmpty()) {
            int[] curNode = queue2.pollFirst();

            int n = curNode[0];
            int d = curNode[1];

            farDist = Math.max(farDist, d);

            // 부모 방향
            if (parent[n] != 0 && !visited[parent[n]]) {
                visited[parent[n]] = true;
                queue2.offerLast(new int[]{parent[n], d + 1});
            }

            // 자식 방향
            for (int next : child[n]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue2.offerLast(new int[]{next, d + 1});
                }
            }
        }

        System.out.println(rootDist);
        System.out.println(subTreeSize);
        System.out.println(downDist);
        System.out.println(farDist);
    }
}