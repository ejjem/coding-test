import java.util.*;
import java.io.*;

public class Solution {
	static int[][] tunnel;
	static boolean[][] visited;
	static boolean[][] tunnelStructure;
	static int N, M, R, C, L;
	static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String[] args) throws Exception{
		tunnelStructure = new boolean[8][4];
		tunnelStructure[1] = new boolean[] {true, true, true, true}; // 1111
		tunnelStructure[2] = new boolean[] {true, true, false, false}; //1100
		tunnelStructure[3] = new boolean[] {false, false, true, true}; //0011
		tunnelStructure[4] = new boolean[] {true, false, false, true}; //1001
		tunnelStructure[5] = new boolean[] {false, true, false, true}; //0101
		tunnelStructure[6] = new boolean[] {false, true, true, false}; //0110
		tunnelStructure[7] = new boolean[] {true, false, true, false}; //1010		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<T+1;tc++) {
			int answer = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			tunnel = new int[N][M];
			visited = new boolean[N][M];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					tunnel[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int time = 1;
			ArrayDeque<int[]> q = new ArrayDeque<>();
			q.offerLast(new int[] {R, C, 1});
			visited[R][C] = true;
			while(time < L) {
				while(!q.isEmpty() && q.peek()[2] == time) {
					int[] tmp = q.pollFirst();
					int y = tmp[0]; int x = tmp[1]; int t = tmp[2];
					for(int i=0; i<4; i++) {
						if(tunnelStructure[tunnel[y][x]][i]) {
							int dy = dist[i][0]; int dx = dist[i][1];
							int ny = y + dy; int nx = x + dx;
							if(ny >= 0 && ny < N && nx >= 0 && nx < M && tunnel[ny][nx] != 0 && !visited[ny][nx]) {
								// i=0일 때 j=1 필요
								// i=1일 때 j=0 필요
								// i=2일 때 j=3 필요
								// i=3일 때 j=2 필요
								switch(i) {
								case(0):
									if(tunnelStructure[tunnel[ny][nx]][1]) {
										visited[ny][nx] = true; q.add(new int[] {ny, nx, time+1});
									}
									break;
								case(1):
									if(tunnelStructure[tunnel[ny][nx]][0]) {
										visited[ny][nx] = true; q.add(new int[] {ny, nx, time+1});
									}
									break;
								case(2):
									if(tunnelStructure[tunnel[ny][nx]][3]) {
										visited[ny][nx] = true; q.add(new int[] {ny, nx, time+1});
									}
									break;
								case(3):
									if(tunnelStructure[tunnel[ny][nx]][2]) {
										visited[ny][nx] = true; q.add(new int[] {ny, nx, time+1});
									}
									break;
								}
							}
							
						}
					}
				}
				time ++;
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(visited[i][j]) answer ++;
				}
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString()); bw.flush(); bw.close();
	}

}
