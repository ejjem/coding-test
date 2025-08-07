import java.util.*;
import java.io.*;

class Solution {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for(int tc=1;tc<T+1;tc++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int[] score = new int[N];
            int[] kcal = new int[N];
            int[] dp =  new int[L+1];
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                score[i] = Integer.parseInt(st.nextToken());
                kcal[i] = Integer.parseInt(st.nextToken());
            }
            for(int idx_arr=0; idx_arr<N; idx_arr++){
                for(int idx_dp=L; idx_dp>kcal[idx_arr] - 1; idx_dp--){
                    dp[idx_dp] = Math.max(dp[idx_dp], dp[idx_dp - kcal[idx_arr]] + score[idx_arr] );
                }
            }
            int maximum = Integer.MIN_VALUE;
            for(int i=0; i<L+1; i++){
                maximum = Math.max(maximum, dp[i]);
            }
            sb.append("#").append(tc).append(" ").append(maximum).append("\n");
        }
        System.out.println(sb);
    }
}