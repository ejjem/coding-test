import java.io.*;
import java.util.*;

public class Main {
	static int[][] ssal = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int[][] mmal = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken()); int H = Integer.parseInt(st.nextToken());
		int[] end = {H-1, W-1};
		boolean[][] board = new boolean[H][W];
		int[][][] visited = new int[H][W][K+1];
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				Arrays.fill(visited[i][j], -1);
			}
		}
		for(int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<W; j++) {
				if(st.nextToken().equals("1")) board[i][j] = false;
				else board[i][j] = true;
			}
		}
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offerLast(new int[] {0, 0, 0});
		Arrays.fill(visited[0][0], 0);
		while(!q.isEmpty()) {
			int[] cur = q.pollFirst();
			int y = cur[0]; int x = cur[1]; int m = cur[2];
			if(y == end[0] && x == end[1]) { System.out.println(visited[y][x][m]); return;}
			for(int i=0; i<ssal.length; i++) {
				int ny = y + ssal[i][0]; int nx = x + ssal[i][1];
				if(ny < 0 || ny >= H || nx < 0 || nx >= W || !board[ny][nx]) continue;
				if(visited[ny][nx][m] == -1) {
					visited[ny][nx][m] = visited[y][x][m] + 1;
					q.add(new int[] {ny, nx, m});
				}
				else if(visited[ny][nx][m] > visited[y][x][m] + 1) {
					visited[ny][nx][m] = visited[y][x][m] + 1;
					q.add(new int[] {ny, nx, m});
				}
				
			}
			if(m < K) {
				for(int i=0; i<mmal.length; i++) {
					int ny = y + mmal[i][0]; int nx = x + mmal[i][1];
					if(ny < 0 || ny >= H || nx < 0 || nx >= W || !board[ny][nx]) continue;
					if(visited[ny][nx][m+1] == -1) {
						visited[ny][nx][m+1] = visited[y][x][m] + 1;
						q.offerLast(new int[] {ny, nx, m+1});
					}
					else if(visited[ny][nx][m+1] > visited[y][x][m] + 1) {
						visited[ny][nx][m+1] = visited[y][x][m] + 1;
						q.add(new int[] {ny, nx, m+1});
					}
				}
			}
		}
		
		System.out.println(-1);
	}
}
