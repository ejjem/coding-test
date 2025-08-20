import java.util.*;
import java.io.*;


class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static char[][] map;
    static boolean[][] visited;
    static ArrayDeque<Point> queue;   
    static ArrayDeque<Point> water;   
    static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static class Point{
    	int x;
    	int y;
    	int cnt;
    	Point(int y, int x, int cnt){
    		this.y=y;
    		this.x=x;
    		this.cnt=cnt;
    	}
    }
    static Point target;
    
    public static void main(String[] args) throws Exception {
    	br = new BufferedReader(new InputStreamReader(System.in));
    	st = new StringTokenizer(br.readLine());
    	int R = Integer.parseInt(st.nextToken());
    	int C = Integer.parseInt(st.nextToken());
    	map = new char[R][C];
    	queue = new ArrayDeque<>();
    	water = new ArrayDeque<>();
    	for(int i=0; i<R; i++) {
    		String tmp = br.readLine();
    		for(int j=0; j<C; j++) {
    			switch(tmp.charAt(j)) {
    			case 'D':
    				target = new Point(i, j, 0);
    				break;
    			case 'S':
    				queue.offerLast(new Point(i, j, 0));
    				break;
    			case '*':
    				water.offerLast(new Point(i, j, 0));
    				break;
    			}
    			map[i][j] = tmp.charAt(j);
    		}
    	}
    	int time = 0;
    	while(true) {
    		while(!water.isEmpty() && water.peekFirst().cnt == time) {
    			Point water_tmp = water.pollFirst();
        		int water_x = water_tmp.x;
        		int water_y = water_tmp.y;
        		int water_cnt = water_tmp.cnt;
        		for(int i=0; i<4; i++) {
        			int dx = dist[i][1];
        			int dy = dist[i][0];
        			if(water_x + dx >= 0 && water_x + dx < C && water_y + dy >= 0 && water_y + dy < R) {
        				if(map[water_y+dy][water_x+dx] == '.' || map[water_y+dy][water_x+dx] == '-') {
        					map[water_y+dy][water_x+dx] = '*';
        					water.offerLast(new Point(water_y+dy, water_x+dx, water_cnt+1));
        				}
        			}
        		}
    		}
    		while(!queue.isEmpty() && queue.peekFirst().cnt == time) {
    			Point p_tmp = queue.pollFirst();
        		int x = p_tmp.x;
        		int y = p_tmp.y;
        		int cnt = p_tmp.cnt;
        		for(int i=0; i<4; i++) {
        			int dx = dist[i][1];
        			int dy = dist[i][0];
        			if(x + dx >= 0 && x + dx < C && y + dy >= 0 && y + dy < R) {
        				if(x+dx == target.x && y+dy == target.y) {
        					System.out.println(cnt+1);
        					return;
        				}
        				else if(map[y+dy][x+dx] == '.') {
        					map[y+dy][x+dx] = '-';
        					queue.offerLast(new Point(y+dy, x+dx, cnt+1));
        				}
        			}
        		}
        		if(queue.isEmpty()) {
        			System.out.println("KAKTUS");
        			return;
        		}
        		
        		/*
        		for(int i=0; i<R; i++) {
        			System.out.println(Arrays.toString(map[i]));
        		}
        		System.out.println("-----");
        		*/
    		}
    		time ++;
    	}
    }
}

