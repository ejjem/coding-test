import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[][] visited;
    static int N;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int x, y, target_x, target_y;
    static int answer;
    
    static class Point {
    	int x;
    	int y;
    	int index;
    	int cnt;
    	
    	Point(int x, int y, int cnt){
    		this.x = x;
    		this.y = y;
    		this.cnt = cnt;
    	}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}
    	
		public int getCnt() {
			return cnt;
		}
    }
    
    public static void main(String[] args) throws Exception{
    	br = new BufferedReader(new InputStreamReader(System.in));
    	int T = Integer.parseInt(br.readLine());
    	for(int tc=1; tc<T+1; tc++) {
    		N = Integer.parseInt(br.readLine());
    		visited = new int[N][N];
    		st = new StringTokenizer(br.readLine());
    		x = Integer.parseInt(st.nextToken());
    		y = Integer.parseInt(st.nextToken());
    		st = new StringTokenizer(br.readLine());
    		target_x = Integer.parseInt(st.nextToken());
    		target_y = Integer.parseInt(st.nextToken());
    		visited[target_x][target_y] = 2;
    		ArrayDeque<Point> queue = new ArrayDeque<>();
    		queue.offerLast(new Point(x, y, 0));
    		while(true) {
    			Point point = queue.pollFirst();
    			int x = point.getX();
    			int y = point.getY();
    			int cnt = point.getCnt();
    			if(visited[x][y] == 2) {
    				System.out.println(cnt);
    				break;
    			}
    			else if (visited[x][y] == 1) continue;
    			else {
    				visited[x][y] = 1;
        			for(int i=0; i<8; i++) {
        				int dxx = dx[i];
        				int dyy = dy[i];
        				if( x + dxx >= 0 && x + dxx < N && y + dyy >= 0 && y + dyy < N) {
        					queue.offerLast(new Point(x + dxx, y + dyy, cnt + 1));
        				}
        			}
    			}
    		}
    	}
    }
}