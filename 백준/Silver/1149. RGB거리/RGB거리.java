import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] expensive = new int[N][3];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				expensive[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] dp = new int[N][3];
		for(int i=0; i<3; i++) {
			dp[0][i] = expensive[0][i];
		}
		for(int i=1; i<N; i++) {
			dp[i][0] = expensive[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = expensive[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] = expensive[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
		}
		int answer = Math.min(dp[N-1][0], dp[N-1][1]);
		answer = Math.min(dp[N-1][2], answer);
		System.out.println(answer);
	}
}
