import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br;
    static StringBuilder sb;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            int[] score = new int[N];
            int[] kcal  = new int[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                score[i] = Integer.parseInt(st.nextToken());
                kcal[i]  = Integer.parseInt(st.nextToken());
            }

            int[] dp = new int[L + 1];
            for (int i = 0; i < N; i++) {
                int s = score[i], k = kcal[i];
                for (int cap = L; cap >= k; cap--) {
                    dp[cap] = Math.max(dp[cap], dp[cap - k] + s);
                }
            }
            sb.append('#').append(tc).append(' ').append(dp[L]).append('\n');
        }
        System.out.print(sb);
    }
}
