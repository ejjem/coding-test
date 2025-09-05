import java.io.*;
import java.util.*;

public class Solution {
	static int N, K;
	static int[][] mount;
	static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	static int search(int y, int x) {
		int max = 0;
		boolean[][] visited = new boolean[N][N];
		visited[y][x] = true;
		max = Math.max(max, minisearch(y, x, visited, 1, true));
		return max;
	}
	static int minisearch(int y, int x, boolean[][] visited, int count, boolean can) {
		int best = count;
		for(int i=0; i<4; i++) {
			int dy = dist[i][0]; int dx = dist[i][1];
			int ny = y + dy; int nx = x + dx;
			if(ny >= 0 && ny < N && nx >= 0 && nx < N && !visited[ny][nx]) {
				if(mount[y][x] > mount[ny][nx]) {
					visited[ny][nx] = true;
					best = Math.max(best, minisearch(ny, nx, visited, count + 1, can));
					visited[ny][nx] = false;
				}
				else {
					if(can && mount[ny][nx] - mount[y][x] + 1 <= K) {
						int origin = mount[ny][nx];
						mount[ny][nx] = mount[y][x] - 1;
						visited[ny][nx] = true;
						best = Math.max(best, minisearch(ny, nx, visited, count + 1, false));
						mount[ny][nx] = origin;
						visited[ny][nx] = false;
					}
				}
			}
		}
		return best;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<T+1;tc++) {
			int answer = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());
			mount = new int[N][N];
			ArrayList<int[]> sp = new ArrayList<>();
			int max = 0;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					mount[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, mount[i][j]);
				}
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(mount[i][j] == max) sp.add(new int[] {i, j});
				}
			}
			for(int i=0; i<sp.size(); i++) {
				int[] cur = sp.get(i);
				answer = Math.max(answer, search(cur[0], cur[1]));
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString()); bw.flush(); bw.close();
	}
}