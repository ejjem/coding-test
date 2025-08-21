import java.util.*;
import java.io.*;

public class Solution {
	static StringBuilder sb;
	static int[][] dist = {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
	static int N;
	static int[][] cafe;

	static int loop(int y, int x, int a, int b) {
		if (a <= 0 || b <= 0) return -1;
		boolean[] visited = new boolean[101];
		int start_x = x, start_y = y;
		visited[cafe[y][x]] = true;
		int[] distance = {a, b, a, b};
		for (int d = 0; d < 4; d++) {
			for (int i = 0; i < distance[d]; i++) {
				y += dist[d][0];
				x += dist[d][1];
				if (y < 0 || y >= N || x < 0 || x >= N) return -1;
				if (y == start_y && x == start_x) {
					if (d == 3 && i == distance[d] - 1) return a + b + a + b;
					return -1;
				}
				int tmp = cafe[y][x];
				if (visited[tmp]) return -1;
				visited[tmp] = true;
			}
		}
		return -1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T + 1; tc++) {
			int answer = -1;
			N = Integer.parseInt(br.readLine());
			cafe = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) cafe[i][j] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int a = 1; a < N; a++) {
						for (int b = 1; b < N; b++) {
							int tmp = loop(i, j, a, b);
							if (answer < tmp) answer = tmp;
						}
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
