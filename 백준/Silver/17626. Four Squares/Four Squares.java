import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j * j <= i; j++) {
                int sq = j * j;
                dp[i] = Math.min(dp[i], dp[i - sq] + 1);
            }
        }

        System.out.println(dp[N]);
    }
}