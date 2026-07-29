/*
    dp
    n원을 만드는데 사용된 동전들의 갯수를 카운팅하면서, 해당 n원을 만드는데 최소 동전 갯수만 기록

*/
import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] coins = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            coins[i] = Integer.parseInt(st.nextToken());
        }
        int W = Integer.parseInt(br.readLine());
        int[] dp = new int[W+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(int i=0; i<N; i++){
            int coin = coins[i];
            for(int j=0; j<W+1; j++){
                if(dp[j] == -1 || (j+coin) > W) continue;
                else{
                    if(dp[j+coin] == -1) dp[j + coin] = dp[j] + 1;
                    else dp[j + coin] = Math.min(dp[j + coin], dp[j] + 1);
                }
                
            }
        }
        if(dp[W] == -1) System.out.println("impossible");
        else System.out.println(dp[W]);
    }
}