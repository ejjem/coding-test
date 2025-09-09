import java.util.*;
import java.io.*;

public class Solution {
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;        
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<T+1; tc++) {
        	int N = Integer.parseInt(br.readLine());
        	st = new StringTokenizer(br.readLine());
        	int[] nums = new int[N];
        	for(int i=0; i<N; i++) {
        		nums[i] = Integer.parseInt(st.nextToken());
        	}
        	int[] dp = new int[N];
        	Arrays.fill(dp, 1);
        	int answer = 0;
        	for(int i=0; i<N; i++) {
        		for(int j=0; j<i; j++) {
        			if(nums[i] >= nums[j]) dp[i] = Math.max(dp[i], dp[j]+1);
        		}
        		answer = Math.max(answer, dp[i]);
        	}
        	//System.out.println(Arrays.toString(dp));
        	sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        bw.write(sb.toString()); bw.flush(); bw.close();
    }
}

