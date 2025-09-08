import java.io.*;
import java.util.*;

public class Main {    
	static int[][] board;
	static int[][] visited;
	static int N, M;
	static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
    	board = new int[N][M]; visited = new int[N][M];
    	int[] start = new int[2];
    	for(int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		Arrays.fill(visited[i], -1);
    		for(int j=0; j<M; j++) {
    			board[i][j] = Integer.parseInt(st.nextToken());
    			if(board[i][j] == 2) {start[0] = i; start[1] = j;}
    			else if(board[i][j] == 0) {visited[i][j] = 0;}
    		}
    	}
    	ArrayDeque<int[]> q = new ArrayDeque<>();
    	visited[start[0]][start[1]] = 0;
    	q.offerLast(new int[] {start[0], start[1]});
    	while(!q.isEmpty()) {
    		int[] cur = q.pollFirst();
    		int y = cur[0]; int x = cur[1];
    		for(int i=0; i<4; i++) {
    			int ny = y + dist[i][0]; int nx = x + dist[i][1];
    			if(ny < 0 || ny >= N || nx < 0 || nx >= M || board[ny][nx] == 0) continue;
    			else {
    				if(visited[ny][nx] == -1 || visited[ny][nx] > visited[y][x] + 1) {
    					visited[ny][nx] = visited[y][x] + 1;
    					q.offerLast(new int[] {ny, nx});
    				}
    			}
    		}
    	}
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<M-1; j++) {
    			sb.append(visited[i][j]).append(" ");
    		}
    		sb.append(visited[i][M-1]).append("\n");
    	}
    	bw.write(sb.toString()); bw.flush(); bw.close();
    }
}