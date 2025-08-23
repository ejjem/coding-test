import java.util.*;
import java.io.*;

class Main {
	static int N;
	static char[][] picture;
	static boolean[][] visitedRGB;
	static boolean[][] visitedRRB;
	static ArrayDeque<int[]> q;
	static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static void DFS(int start_y, int start_x, char color, int mode) {
		if(mode == 0) {
			q.offerLast(new int[] {start_y, start_x});
			while(!q.isEmpty()) {
				int[] tmp = q.pollLast();
				int y = tmp[0]; int x = tmp[1];
				for(int i=0; i<4; i++) {
					int dy = dist[i][0]; int dx = dist[i][1];
					if(isPossible(y+dy, x+dx) && !visitedRGB[y+dy][x+dx] && picture[y+dy][x+dx] == color) {
						visitedRGB[y+dy][x+dx] = true;
						q.offerLast(new int[] {y+dy, x+dx});
					}
				}
			}
		}
		else {
			q.offerLast(new int[] {start_y, start_x});
			while(!q.isEmpty()) {
				int[] tmp = q.pollLast();
				int y = tmp[0]; int x = tmp[1];
				for(int i=0; i<4; i++) {
					int dy = dist[i][0]; int dx = dist[i][1];
					if(isPossible(y+dy, x+dx) && !visitedRRB[y+dy][x+dx]) {
						if(color == 'B' && picture[y+dy][x+dx] == 'B') {
							visitedRRB[y+dy][x+dx] = true;
							q.offerLast(new int[] {y+dy, x+dx});
						}
						else if( (color == 'R' || color == 'G') && (picture[y+dy][x+dx] == 'R' || picture[y+dy][x+dx] == 'G')) {
							visitedRRB[y+dy][x+dx] = true;
							q.offerLast(new int[] {y+dy, x+dx});
						}
					}
				}
			}
		}
	}
	static boolean isPossible(int y, int x) {
		if(x >= 0 && y >= 0 && x < N && y < N) return true;
		return false;
	}
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	picture = new char[N][N];
    	for(int i=0; i<N; i++) {
    		String tmp = br.readLine();
    		for(int j=0; j<N; j++) {
    			picture[i][j] = tmp.charAt(j);
    		}
    	}
    	int RGB = 0; int RRB = 0; q = new ArrayDeque<>();
    	visitedRGB = new boolean[N][N]; visitedRRB = new boolean[N][N];
    	
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<N; j++) {
    			if(!visitedRGB[i][j]) {
    				visitedRGB[i][j] = true;
    				DFS(i, j, picture[i][j], 0);
    				RGB ++;
    			}
    			if(!visitedRRB[i][j]) {
    				visitedRRB[i][j] = true;
    				DFS(i, j, picture[i][j], 1);
    				RRB ++;
    			}
    		}
    	}
    	System.out.println(RGB + " " + RRB);
    }
}