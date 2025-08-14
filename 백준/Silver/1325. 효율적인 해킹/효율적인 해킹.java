import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static StringBuilder sb;
	static int N, M;
	static List<List<Integer>> graph;
	static int maximum;
	static int[] answer;
	static ArrayDeque<Integer> stack;
	static int[] visited;
	
	static int dfs(int start, int stamp) {
		int cnt = 0;
		stack.clear();
		stack.add(start);
		visited[start] = stamp;
		while(!stack.isEmpty()) {
			int target = stack.pollLast();
			cnt ++;
			for(int n : graph.get(target)) {
				if(visited[n] != stamp) {
					visited[n] = stamp;
					stack.offerLast(n);
				}
			}
		}
		return cnt;
	}
	
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			graph.add(new ArrayList<>());
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			graph.get(b).add(a);
		}
		
		maximum = 0;
		answer = new int[N];
		stack = new ArrayDeque<>();
		visited = new int[N];
		
		for(int i=0; i<N; i++) {
			int result = dfs(i, i+1);
			answer[i] = result;
			maximum = Math.max(result, maximum);
		}
		for(int i=0; i<N; i++) {
			if(answer[i] == maximum) sb.append(i + 1).append(" ");
		}
		
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
