import java.io.*;
import java.util.*;

public class Solution {

    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};

    static final int[][] reflect = {
            {0, 0, 0, 0},
            {2, 3, 1, 0},
            {1, 3, 0, 2},
            {3, 2, 0, 1},
            {2, 0, 3, 1},
            {2, 3, 0, 1}
    };

    static int N;
    static int[][] a;
    static int[][] worm;
    static int[] wormCnt;

    static int simulate(int sr, int sc, int dir) {
        int r = sr, c = sc, score = 0;
        while (true) {
            r += dy[dir];
            c += dx[dir];
            int v = a[r][c];
            if ((r == sr && c == sc) || v == -1) return score;
            if (1 <= v && v <= 5) {
                dir = reflect[v][dir];
                score++;
            } else if (6 <= v && v <= 10) {
                int r1 = worm[v][0], c1 = worm[v][1], r2 = worm[v][2], c2 = worm[v][3];
                if (r == r1 && c == c1) { r = r2; c = c2; }
                else { r = r1; c = c1; }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine().trim());

            a = new int[N + 2][N + 2];
            worm = new int[11][4];
            wormCnt = new int[11];

            for (int i = 0; i < N + 2; i++) {
                a[0][i] = 5;
                a[N + 1][i] = 5;
                a[i][0] = 5;
                a[i][N + 1] = 5;
            }

            for (int r = 1; r <= N; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int c = 1; c <= N; c++) {
                    int v = Integer.parseInt(st.nextToken());
                    a[r][c] = v;
                    if (v >= 6 && v <= 10) {
                        int idx = wormCnt[v];
                        wormCnt[v]++;
                        worm[v][idx * 2] = r;
                        worm[v][idx * 2 + 1] = c;
                    }
                }
            }

            int ans = 0;

            for (int r = 1; r <= N; r++) {
                for (int c = 1; c <= N; c++) {
                    if (a[r][c] != 0) continue;
                    for (int d = 0; d < 4; d++) {
                        ans = Math.max(ans, simulate(r, c, d));
                    }
                }
            }

            out.append('#').append(tc).append(' ').append(ans).append('\n');
        }

        System.out.print(out.toString());
    }
}