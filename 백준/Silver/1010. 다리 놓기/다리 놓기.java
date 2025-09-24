import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static long answer;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        long[][] dp = new long[31][31];
        for(int i=0; i<31; i++){
            dp[i][0] = 1;
            dp[i][i] = 1;
            dp[i][1] = i;
        }
        for(int i=1; i<=30; i++){
            for(int j=1; j<=30; j++){
                if(i < j) continue;
                for(int k=1; k<=j; k++){
                        dp[i][k] = dp[i-1][k] + dp[i-1][k-1];
                }
            }
        }
        for(int tc=1; tc<T+1; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            sb.append(dp[M][N]).append("\n");
        }
        bw.write(sb.toString()); bw.flush(); bw.close();
    }
}