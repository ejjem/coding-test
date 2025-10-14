import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int dp[][] = new int[1001][2];
        dp[1][0] = 1; dp[2][0] = 1; dp[2][1] = 1;
        for(int i=3; i<1001; i++){
            dp[i][0] = (dp[i-1][0] + dp[i-1][1]) % 10007;
            dp[i][1] = (dp[i-2][0] + dp[i-2][1]) % 10007;
        }
        int answer = (dp[N][0] + dp[N][1]) % 10007;
        System.out.println(answer);
    }
}