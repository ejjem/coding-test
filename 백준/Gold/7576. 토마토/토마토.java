import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[][] board;
    static int M, N;
    static int noTomato, Tomato;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int cnt;
    static class Point{
    	int x;
    	int y;
    	int cnt;
    	
    	Point(int y, int x, int cnt){
    		this.x = x;
    		this.y = y;
    		this.cnt = cnt;
    	}
    }
    
    
    public static void main(String[] args) throws Exception{
    	br = new BufferedReader(new InputStreamReader(System.in));
    	st = new StringTokenizer(br.readLine());
    	int M = Integer.parseInt(st.nextToken());
    	int N = Integer.parseInt(st.nextToken());
    	board = new int[N][M];
    	noTomato = 0;
    	ArrayDeque<Point> queue = new ArrayDeque<>();
    	for(int i=0;i<N;i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0;j<M;j++) {
    			int tmp = Integer.parseInt(st.nextToken());
    			if(tmp == -1) {
    				board[i][j] = -1;
    				noTomato ++;
    			}
    			if(tmp == 1) {
    				board[i][j] = 1;
    				Tomato ++;
    				queue.offerLast(new Point(i, j, 0));
    			}
    		}
    	}
    	cnt = 0;
    	while(!queue.isEmpty()) {
    		Point tmp = queue.pollFirst();
    		int x = tmp.x;
    		int y = tmp.y;
    		cnt = tmp.cnt;
    		
    		for(int i=0; i<4; i++) {
    			int dxx = dx[i]; int dyy = dy[i];
    			if(x + dxx >= 0 && x + dxx < M && y + dyy >= 0 && y + dyy < N) {
    				if(board[y+dyy][x+dxx] == 0) {
    					queue.offerLast(new Point(y+dyy, x+dxx, cnt+1));
    					board[y+dyy][x+dxx] = 1;
    					Tomato ++;
    				}
    					
    			}
    		}
    		
    		
    	}
    	
    	if( (Tomato + noTomato) == N * M) {
    		System.out.println(cnt);
    	}
    	else System.out.println(-1);
    	
    	
    }
}