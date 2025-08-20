import java.util.*;
import java.lang.*;
import java.io.*;


class Solution {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringBuilder sb;
    static StringTokenizer st;
    // position_: 사용자의 위치
    static int[] positionA; 
    static int[] positionB;
    // move_: 사용자의 이동 방향
    static int[] moveA;
    static int[] moveB;
    // 상하좌우
    static int[][] dist = {{0, 0}, {0, -1}, {1, 0}, {0, 1}, {-1, 0}}; 
    // 거리 계산 메서드
    static int distance(int xa, int xb, int ya, int yb) {
    	return Math.abs(xa - xb) + Math.abs(ya - yb);
    }
    // 무선 충전기 클랫
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
    		// 위치 초기화
    		positionA = new int[] {1, 1};
    		positionB = new int[] {10, 10};
    		
    		// 입력값 저장
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
    		
    		
    		
    		int idx = 0;
    		// flag는 0초(시작 위치) 충전량 계산용
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
    			
    			boolean[] possibleA = new boolean[A];
    			boolean[] possibleB = new boolean[A];
    			boolean find = false;
    			
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
    			
    			// 게산 로직, 누구 1명이라도 충전할 수 있을 때 계산
    			if(find) {
    				int max = 0;
    				for (int i = 0; i<A; i++) {
    				    int aGain = 0;
    				    if (possibleA[i]) aGain = BCs[i].p;
    				    for (int j = 0; j<A; j++) {
    				        int bGain = 0;
        				    if (possibleB[j]) bGain = BCs[j].p;
    				        int total;
    				        if (i == j && possibleA[i] && possibleB[j]) total = BCs[i].p;
    				        else {
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