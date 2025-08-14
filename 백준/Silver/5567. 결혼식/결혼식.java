import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	static int N, M;
	static List<List<Integer>> graph;
	static ArrayDeque<int[]> stack;
	static boolean[] visited;
	
	static int dfs(int start, int start_depth) {
		int cnt = -1;
		stack.add(new int[] {start, start_depth});
		visited[start] = true;
		while(!stack.isEmpty()) {
			int[] target = stack.pollLast();
			cnt ++;
			if(target[1] != 2) {
				for(int n : graph.get(target[0])) {
					if(!visited[n]) {
						visited[n] = true;
						stack.offerLast(new int[]{n, target[1]+1});
					}
				}
			}
			
		}
		return cnt;
	}
	
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		graph = new ArrayList<>();
		for(int i=0; i<N; i++) {
			graph.add(new ArrayList<>());
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		stack = new ArrayDeque<>();
		visited = new boolean[N];
		
		System.out.println(dfs(0, 0));

	
	}
}
