import java.io.*;
import java.util.*;
public class Solution {
	static int N, M, C;
    static int[][] hive;
    static int[][] maximum; 
    static int calc(int y, int x1, int x2) {
    	return minicalc(y, x1, x2, 0, 0, 0);
    }
 
    static int minicalc(int y, int start, int end, int index, int total, int profit) {
    	if(start + index > end) {
    		return profit;
    	}
    	int select = 0;
    	if(total + hive[y][start + index] <= C) {
    		select = minicalc(y, start, end, index+1, total + hive[y][start+index], profit + hive[y][start + index] * hive[y][start + index]);
    	}
    	int notselect = minicalc(y, start, end, index+1, total, profit);
    	return Math.max(select, notselect);
    }
    
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st;
    	StringBuilder sb = new StringBuilder();
    	//////////////////
    	
    	int T = Integer.parseInt(br.readLine());
    	for(int tc=1;tc<T+1;tc++) {
    		st = new StringTokenizer(br.readLine());
    		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());
    		hive = new int[N][N];
    		for(int i=0; i<N; i++) {
    			st = new StringTokenizer(br.readLine());
    			for(int j=0; j<N; j++) {
    				hive[i][j] = Integer.parseInt(st.nextToken());
    			}
    		}
    		maximum = new int[N][N-M+1];
    		// 구간 별 최댓값 계산
    		for(int i=0; i<N; i++) {
    			for(int j=0; j<=N-M; j++) {
    				maximum[i][j] = calc(i, j, j+M-1);
    			}
    		}
    		
    		// 1. 같은 줄에서 2개 선택 시 최대
    		int one = 0;
    		for(int i=0; i<N; i++) {
    			for(int j=0; j<=N-M-M; j++) {
    				for(int k=j+M; k<=N-M; k++) {
    					one = Math.max(one, maximum[i][j] + maximum[i][k]);
    				}
    			}
    		}
    		
    		// 2. 다른 줄에서 2개 선택 시 최대
    		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    		for(int i=0; i<N; i++) {
    			int tmp = 0;
    			for(int j=0; j<=N-M; j++) {
    				tmp = Math.max(tmp, maximum[i][j]);
    			}
    			pq.add(tmp);
    		}
    		int two = pq.poll();
    		two += pq.poll();
    		
    		int answer = Math.max(one, two);
    		sb.append("#").append(tc).append(" ").append(answer).append("\n");
    		
    	}
    	bw.write(sb.toString()); bw.flush(); bw.close();
    }
}


