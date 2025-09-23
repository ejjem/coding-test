import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[][] dp = new long[15][15];
        for(int i=1; i<15; i++){
            dp[0][i] = i;
        }
        for(int i=1; i<15; i++){
            for(int j=1; j<15; j++){
                for(int k=1; k<=j; k++){
                    dp[i][j] += dp[i-1][k];
                }
            }
        }

        for(int tc=1; tc<T+1; tc++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[k][n]);
        }
    }
}