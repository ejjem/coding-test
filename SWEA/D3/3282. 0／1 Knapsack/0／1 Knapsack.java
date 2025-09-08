import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<T+1;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); int K = Integer.parseInt(st.nextToken());
			int[] volums = new int[N]; int[] costs = new int[N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				volums[i] = Integer.parseInt(st.nextToken()); costs[i] = Integer.parseInt(st.nextToken());
			}
			int[] dp = new int[K + 1];
			for(int i=0; i<N; i++) {
				for(int j=K; j>=0; j--) {
					if(j - volums[i] < 0) break;
					if(dp[j] < dp[j-volums[i]] + costs[i]) {dp[j]= dp[j-volums[i]] + costs[i];}
				}
				
			}
			int answer = 0;
			for(int i=0; i<=K; i++) {
				answer = Math.max(dp[i], answer);
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString()); bw.flush(); bw.close();
	}

}
