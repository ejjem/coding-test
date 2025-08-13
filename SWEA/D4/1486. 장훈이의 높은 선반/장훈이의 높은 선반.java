import java.util.*;
import java.lang.*;
import java.io.*;


class Solution {
    static BufferedReader br;
    static StringTokenizer st;
    static BufferedWriter bw;
    static StringBuilder sb;
    static int N, B;
    static long[] tall;
    static long answer;
    static boolean end;
    static void dfs(int index, long sum) {
    	if(end) return;
    	if(sum == B) {
    		answer = B;
    		end = true;
    		return;
    	}
    	else if(sum > B) {
    		answer = Math.min(answer, sum);
    		return;
    	}
    	
    	if(index == N) return;
    	
    	
    	dfs(index+1, sum + tall[index]);
    	dfs(index+1, sum);
    }
    
    
    public static void main(String[] args) throws Exception{
    	br = new BufferedReader(new InputStreamReader(System.in));
    	sb = new StringBuilder();
    	int T = Integer.parseInt(br.readLine());
    	
    	for(int tc=1;tc<T+1;tc++) {
    		st = new StringTokenizer(br.readLine());
    		N = Integer.parseInt(st.nextToken());
    		B = Integer.parseInt(st.nextToken());
    		st = new StringTokenizer(br.readLine());
    		tall = new long[N];
    		end = false;
    		for(int i=0;i<N;i++) {
    			tall[i] = Long.parseLong(st.nextToken());
    		}
    		answer = Long.MAX_VALUE;
        	dfs(0, 0);
        	sb.append("#").append(tc).append(" ").append(answer - B).append("\n");
    	}
    	System.out.println(sb);
    }
}
