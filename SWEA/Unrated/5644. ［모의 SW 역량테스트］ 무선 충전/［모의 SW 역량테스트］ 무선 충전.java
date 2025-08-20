import java.util.*;
import java.lang.*;
import java.io.*;


class Solution {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringBuilder sb;
    static StringTokenizer st;
    static int[] positionA; 
    static int[] positionB;
    static int[] moveA;
    static int[] moveB;
    static int[][] dist = {{0, 0}, {0, -1}, {1, 0}, {0, 1}, {-1, 0}}; 
    static int distance(int xa, int xb, int ya, int yb) {
    	return Math.abs(xa - xb) + Math.abs(ya - yb);
    }
    
    static class BC{
    	int x;
    	int y;
    	int c;
    	int p;
    	
    	BC(int x, int y, int c, int p){
    		this.x = x;
    		this.y = y;
    		this.c = c;
    		this.p = p;
    	}
    	
    }
    
    public static void main(String[] args) throws Exception {
    	br = new BufferedReader(new InputStreamReader(System.in));
    	sb = new StringBuilder();
    	int T = Integer.parseInt(br.readLine());
    	for(int tc=1; tc<T+1; tc++) {
    		int answer = 0;
    		positionA = new int[] {1, 1};
    		positionB = new int[] {10, 10};
    		st = new StringTokenizer(br.readLine());
    		int M = Integer.parseInt(st.nextToken());
    		int A = Integer.parseInt(st.nextToken());
    		moveA = new int[M]; moveB = new int[M];
    		st = new StringTokenizer(br.readLine());
    		for(int i=0;i<M;i++) {
    			moveA[i] = Integer.parseInt(st.nextToken());
    		}
    		st = new StringTokenizer(br.readLine());
    		for(int i=0;i<M;i++) {
    			moveB[i] = Integer.parseInt(st.nextToken());
    		}
    		BC[] BCs = new BC[A];
    		for(int i=0; i<A; i++) {
    			st = new StringTokenizer(br.readLine());
    			int x = Integer.parseInt(st.nextToken());
    			int y = Integer.parseInt(st.nextToken());
    			int c = Integer.parseInt(st.nextToken());
    			int p = Integer.parseInt(st.nextToken());
    			BCs[i] = new BC(x, y, c, p);
    		}
    		
    		// 0초일 때 충전
    		// 1 ~ 20일 때 충전	
    		int idx = 0;
    		boolean flag = false;
    		while(idx < M) {
    			if(flag) {
    				//(X, Y) 기준
    				//A의 X좌표
    				positionA[0] += dist[moveA[idx]][0];
    				//A의 Y좌표	
    				positionA[1] += dist[moveA[idx]][1];
    				//B의 X좌표
    				positionB[0] += dist[moveB[idx]][0];		
    				//B의 Y좌표
    				positionB[1] += dist[moveB[idx]][1];
    			}
    			boolean find = false;
    			boolean[] possibleA = new boolean[A+1];
    			boolean[] possibleB = new boolean[A+1];
    			for(int i=0; i<A; i++) {
    				if(distance(positionA[0], BCs[i].x, positionA[1], BCs[i].y) <= BCs[i].c) {
    					possibleA[i] = true;
    					find = true;
    				}
    				if(distance(positionB[0], BCs[i].x, positionB[1], BCs[i].y) <= BCs[i].c) {
    					possibleB[i] = true;
    					find = true;
    				}
    			}
    			if(find) {
    				int max = 0;
    				for (int i = 0; i <= A; i++) { 
    				    int aGain = 0;

    				    if (i < A) { 
    				        if (!possibleA[i]) continue;  
    				        aGain = BCs[i].p;
    				    }

    				    for (int j = 0; j <= A; j++) { 
    				        int bGain = 0;

    				        if (j < A) {
    				            if (!possibleB[j]) continue;  
    				            bGain = BCs[j].p;
    				        }

    				        int total;
    				        if (i < A && j < A && i == j) {
    				            total = BCs[i].p;
    				        } else {
    				            total = aGain + bGain;
    				        }

    				        if (total > max) max = total;
    				    }
    				}
        			answer += max;
    			}
    			
    			if(!flag) {
    				flag = true;
    			}
    			else {
    				idx ++;
    			}
    		}
    		sb.append("#").append(tc).append(" ").append(answer).append("\n");
    	}
    	bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	bw.write(sb.toString());
    	bw.flush();
    	bw.close();
    }
}
