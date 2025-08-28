import java.util.*;
import java.io.*;

public class Solution {
	static int[][] origin;
	static int[][] test;
	static int N, W, H;
	static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; 
	static int answer, originTotal;
	static int boom(int[][] board, int sx) {
		int cnt = 0;
		ArrayDeque<int[]> stack = new ArrayDeque<>();
		int sy = 0;
		for(int i=0;i<H;i++) {
			if(board[i][sx] != 0) {
				cnt = 1;
				sy = i; break;}
		}
		if(cnt == 0) return 0;
		if(board[sy][sx] == 1) {board[sy][sx] = 0; return cnt;}
		stack.offerLast(new int[] {sy, sx, board[sy][sx]});
		board[sy][sx] = 0;
		while(!stack.isEmpty()) {
			int[] tmp = stack.pollLast();
			int y = tmp[0]; int x = tmp[1]; int power = tmp[2]; 
				for(int i=0; i<4; i++) {
					int dy = dist[i][0]; int dx = dist[i][1];
					for(int p=1; p<power;p++) {
						if(isPossible(y+p*dy, x+p*dx) && board[y+p*dy][x+p*dx] != 0) {
							if(board[y+p*dy][x+p*dx] == 1) {cnt += 1; board[y+p*dy][x+p*dx] = 0;}
							else {cnt += 1; stack.offerLast(new int[] {y+p*dy, x+p*dx, board[y+p*dy][x+p*dx]}); board[y+p*dy][x+p*dx] = 0;}
						}
					}
				}
			
		}
		return cnt;
	}
	
	static void reload(int[][] board) {
		for(int j=0;j<W;j++) {
			ArrayList<Integer> check = new ArrayList<>();
			for(int i=H-1;i>=0;i--) {
				if(board[i][j] != 0) check.add(board[i][j]);
			}
			int idx = 0;
			for(int i=H-1;i>=0;i--) {
				if(idx < check.size()) {
					board[i][j] = check.get(idx++);
				}
				else {
					board[i][j] = 0;
				}
			}
		}
	}
	static boolean isPossible(int y, int x) {
		if(x >= 0 && x < W && y >= 0 && y < H) return true;
		return false;
	}
	
	static void DFS(int depth, int[][] board, int tmp) {
		if(depth == N) {
			answer = Math.min(answer, originTotal - tmp); 
			return;
		}
		for(int i=0; i<W; i++) {
			int[][] tmpBoard = new int[H][W];
			for(int idx=0; idx<H; idx++) {
				tmpBoard[idx] = Arrays.copyOf(board[idx], W);
			}
			int nextTmp = tmp + boom(tmpBoard, i);
			reload(tmpBoard);
			DFS(depth+1, tmpBoard, nextTmp);
		}
	}	
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<T+1;tc++) {
			answer = Integer.MAX_VALUE;
			originTotal = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); W = Integer.parseInt(st.nextToken()); H = Integer.parseInt(st.nextToken());
			origin = new int[H][W];
			for(int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					origin[i][j] = Integer.parseInt(st.nextToken());
					if(origin[i][j] != 0) originTotal ++;
				}
			}
			DFS(0, origin, 0);
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		
		bw.write(sb.toString()); bw.flush(); bw.close();
	}
}