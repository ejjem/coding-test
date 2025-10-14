import java.io.*;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] Ts = new int[N];
        int[] Ps = new int[N];
        int[] dp = new int[N+1];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            Ts[i] = Integer.parseInt(st.nextToken());
            Ps[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<N; i++){
            int T = Ts[i]; int P = Ps[i];
            // 1) 상담 O
            if(i+T <= N){
                dp[i+T] = Math.max(dp[i+T], dp[i] + P);
            }
            // 2) 상담 X
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }
        System.out.println(dp[N]);
    }
}