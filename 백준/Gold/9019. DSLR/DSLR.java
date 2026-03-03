import java.io.*;
import java.util.*;

public class Main {
    static int D(int x) { return (x * 2) % 10000; }
    static int S(int x) { return (x == 0) ? 9999 : x - 1; }
    static int L(int x) { return (x % 1000) * 10 + (x / 1000); }
    static int R(int x) { return (x % 10) * 1000 + (x / 10); }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            boolean[] vis = new boolean[10000];
            int[] prev = new int[10000];
            char[] how = new char[10000];
            Arrays.fill(prev, -1);

            ArrayDeque<Integer> q = new ArrayDeque<>();
            q.offer(A);
            vis[A] = true;

            while (!q.isEmpty() && !vis[B]) {
                int cur = q.poll();

                int n = D(cur);
                if (!vis[n]) {
                    vis[n] = true;
                    prev[n] = cur;
                    how[n] = 'D';
                    q.offer(n);
                }

                n = S(cur);
                if (!vis[n]) {
                    vis[n] = true;
                    prev[n] = cur;
                    how[n] = 'S';
                    q.offer(n);
                }

                n = L(cur);
                if (!vis[n]) {
                    vis[n] = true;
                    prev[n] = cur;
                    how[n] = 'L';
                    q.offer(n);
                }

                n = R(cur);
                if (!vis[n]) {
                    vis[n] = true;
                    prev[n] = cur;
                    how[n] = 'R';
                    q.offer(n);
                }
            }

            StringBuilder ans = new StringBuilder();
            int cur = B;
            while (cur != A) {
                ans.append(how[cur]);
                cur = prev[cur];
            }
            out.append(ans.reverse()).append('\n');
        }

        System.out.print(out);
    }
}