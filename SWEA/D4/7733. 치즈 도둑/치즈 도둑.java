import java.util.*;
import java.io.*;

class Solution {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringBuilder sb;
    static StringTokenizer st;
    static int N;
    static int[][] cheese;
    static boolean[][] visited;
    static ArrayDeque<Point> queue;
    static int answer, cnt;
    static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static class Point{
    	int x;
    	int y;
    	Point(int y, int x){
    		this.y=y;
    		this.x=x;
    	}
    }
    static void BFS(int day, Point point) {
    	queue = new ArrayDeque<>();
    	queue.offerLast(point);
    	visited[point.y][point.x] = true;
    	while(!queue.isEmpty()) {
    		Point tmp = queue.pollFirst();
    		int x = tmp.x; int y = tmp.y;
        	for(int i=0; i<4; i++) {
        		int dx = dist[i][1]; int dy = dist[i][0];
        		if(x + dx >= 0 && x + dx < N && y + dy >= 0 && y + dy < N) {
        			if(!visited[y+dy][x+dx] && cheese[y+dy][x+dx] > day) {
        				visited[y+dy][x+dx] = true;
        				queue.offerLast(new Point(y+dy, x+dx));
        			}
        		}
        	}
    	}

    }
    
    public static void main(String[] args) throws Exception {
    	br = new BufferedReader(new InputStreamReader(System.in));
    	sb = new StringBuilder();
    	int T = Integer.parseInt(br.readLine());
    	for(int tc=1;tc<T+1;tc++){
    		N = Integer.parseInt(br.readLine());
    		cheese = new int[N][N];
    		answer = 1;
    		for(int i=0; i<N; i++) {
    			st = new StringTokenizer(br.readLine());
    			for(int j=0; j<N; j++) {
    				cheese[i][j] = Integer.parseInt(st.nextToken());
    			}
    		}
    		
    		
    		for(int day=1;day<=100;day++){
    			visited = new boolean[N][N];
    			cnt = 0;
    			for(int i=0; i<N; i++) {
    				for(int j=0; j<N; j++) {
    					if(!visited[i][j] && cheese[i][j] > day) {
    						BFS(day, new Point(i, j)); 
    						cnt+=1;
    					}
    				}
    			}
    			if(answer<cnt) answer = cnt;
    		}
    		sb.append("#").append(tc).append(" ").append(answer).append("\n");
    	}
    	bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	bw.write(sb.toString());
    	bw.flush();
    	bw.close();
    }
}
