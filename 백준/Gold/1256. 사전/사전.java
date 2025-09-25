import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static final long LIM = 1_000_000_000L + 1; // K 비교용 상한
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        long[][] dp = new long[201][201];
        for(int i=0; i<201; i++){
            dp[i][0] = 1;
            dp[i][i] = 1;
            dp[i][1] = i;
        }
        for(int i=1; i<=200; i++){
            for(int j=1; j<=200; j++){
                if(i < j) continue;
                for(int k=1; k<=j; k++){
                        dp[i][k] = dp[i-1][k] + dp[i-1][k-1];
                        if (dp[i][k] > LIM) dp[i][k] = LIM;
                }
            }
        }


        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int T = N+M;
        if(K > dp[N+M][N]){
            System.out.println(-1); return;
        }
        for(int i=0; i<T; i++){
            if(N > 0){
                if(K <= dp[N+M-1][N-1]){
                    sb.append("a");
                    N--;
                }else{
                    sb.append("z");
                    K -= dp[N+M-1][N-1];
                    M--;
                }
            }else{
                sb.append("z");
                M--;
            }
            //System.out.println(i + ": "+ sb);
        }
        System.out.println(sb);
    }
}