import java.util.*;
import java.io.*;

class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int N;
	static int[][] board;
	static boolean[][] visited;
	static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static ArrayDeque<int[]> q;
	static void BFS(int i, int j, int h) {
		q.offerLast(new int[] {i, j});
		visited[i][j] = true;
		while(!q.isEmpty()) {
			int[] tmp = q.pollFirst();
			int y = tmp[0]; int x = tmp[1];
			for(int idx=0;idx<4;idx++) {
				int dy = dist[idx][0]; int dx = dist[idx][1];
				if(check(y+dy, x+dx) && !visited[y+dy][x+dx] && board[y+dy][x+dx] > h) {
					visited[y+dy][x+dx] = true;
					q.offerLast(new int[] {y+dy, x+dx});
				}
			}
		}
	}
	static boolean check(int y, int x) {
		if(x >= 0 && x < N && y >= 0 && y < N) return true;
		return false;
	}
	
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		int answer = 0;
		int max = 0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(max < board[i][j]) max = board[i][j];
			}
		}
		q = new ArrayDeque<>();
		for(int h=0;h<=max;h++) {
			visited = new boolean[N][N];
			int cnt = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(!visited[i][j] && board[i][j] > h) {
						cnt ++;
						BFS(i, j, h);
					}
				}
			}
			if(answer < cnt) answer = cnt;
		}
		
		
		System.out.println(answer);
    }
}

