import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());

            boolean[][] reach = new boolean[N][N];

            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                reach[a][b] = true;
            }

            for (int k = 0; k < N; k++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (reach[i][j]) continue; // 이미 true면 건너뜀
                        if (reach[i][k] && reach[k][j]) {
                            reach[i][j] = true;
                        }
                    }
                }
            }
            int answer = 0;
            for (int i = 0; i < N; i++) {
                int known = 0;
                for (int j = 0; j < N; j++) {
                    if (i == j) continue;
                    if (reach[i][j] || reach[j][i]) known++;
                }
                if (known == N - 1) answer++;
            }
            sb.append('#').append(tc).append(' ').append(answer).append('\n');
        }
        System.out.print(sb.toString());
    }
}
