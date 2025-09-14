import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<T+1; tc++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] dp = new int[N+1][K+1];
            int[] volumes = new int[N+1];
            int[] costs = new int[N+1];
            for(int i=1; i<N+1; i++){
                st = new StringTokenizer(br.readLine());
                volumes[i] = Integer.parseInt(st.nextToken());
                costs[i] = Integer.parseInt(st.nextToken());
            }
            for(int i=1; i<N+1; i++){
                for(int j=0; j<=K; j++){
                    // 1. i번째 아이템 선택 x
                    dp[i][j] = dp[i-1][j];
                    // 2. i번째 아이템 선택
                    if(volumes[i] <= j){
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][j-volumes[i]] + costs[i]);
                    }
                }
            }
            int answer = dp[N][K];
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        bw.write(sb.toString()); bw.flush(); bw.close();
    }
}