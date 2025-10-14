import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws IOException {
        long s = 1000000000;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long dp[][] = new long[101][10];
        for(int i=0; i<=9; i++){
            dp[1][i] = 1;
        }
        for(int i=2; i<=100; i++){
            dp[i][0] = dp[i-1][1] % s;
            dp[i][9] = dp[i-1][8] % s;
            for(int j=1; j<=8; j++){
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % s;
            }
        }
        long answer = 0;
        for(int i=1; i<=9; i++){
            answer += dp[N][i];
        }
        System.out.println(answer % s);
    }
}