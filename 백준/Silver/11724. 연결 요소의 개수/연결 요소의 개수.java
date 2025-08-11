import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static boolean[] visited;
	static boolean[][] graph;
	static int cnt;
	static ArrayDeque<Integer> stack;
	static int N;
	static int M;
	
	static void dfs(int start) {
		if(visited[start] == true) return;
		else {
			visited[start] = true;
			for(int i=0; i< N; i++) {
				if(start != i && graph[start][i] == true) {
					if(!visited[i]) stack.offerLast(i);
				}
			}
			while(true) {
				if(stack.isEmpty()) return;
				else {
				int target = stack.pollLast();
				dfs(target);
				}
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException, Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new boolean[N][N];
		visited = new boolean[N];
		stack = new ArrayDeque<>();
		cnt = 0;
		for(int i=0; i<N; i++) {
			graph[i][i] = true;
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			graph[u][v] = true;
			graph[v][u] = true;
		}
		for(int i=0; i<N; i++) {
			if(visited[i] == true) continue;
			else {
				cnt ++;
				dfs(i);
			}
		}
		System.out.println(cnt);
	}

}
