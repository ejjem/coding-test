import java.util.*;
import java.io.*;

class Solution {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static StringBuilder sb;
	static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		for(int testcase=0; testcase<10; testcase++) {
			int tc = Integer.parseInt(br.readLine());
			//초기화
			int[][] maze = new int[100][100];
			int[] start = new int[2]; int[] end = new int[2];
			boolean[][] visited = new boolean[100][100];
			ArrayDeque<int[]> stack = new ArrayDeque<>();
			int answer = 0;
			//입력 -> 저장
			for(int i=0; i<100; i++) {
				String tmp = br.readLine();
				for(int j=0; j<100; j++) {
					int num = tmp.charAt(j) - '0';
					if(num == 2) {start[0] = i; start[1] = j;}
					else if(num == 3) {end[0] = i; end[1] = j;}
					maze[i][j] = num;
				}
			}
			//탐색
			stack.offerLast(start);
			boolean possible = false;
			while(!stack.isEmpty()) {
				int[] tmp = stack.pollLast();
				int y = tmp[0]; int x = tmp[1];
				for(int i=0; i<4; i++) {
					int dy = dist[i][0]; int dx = dist[i][1];
					if(x + dx >= 0 && x + dx < 100 && y + dy >= 0 && y + dy < 100) {
						if(y+dy == end[0] && x+dx == end[1]) {possible = true; break;}
						else if(maze[y+dy][x+dx] == 0 && !visited[y+dy][x+dx]) {
							visited[y+dy][x+dx] = true;
							stack.offerLast(new int[] {y+dy, x+dx});
						} 
							
					}
				}
				
			}
			if(possible) answer = 1;
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
    }
}

