import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static HashMap<Integer, ArrayList<Integer>> graph;
	static boolean[] visited;
	static ArrayDeque<Integer> stack;
	static void DFS(int start) {
		visited[start] = true;
		stack.offerLast(start);
		while(!stack.isEmpty()) {
			int tmp = stack.pollLast();
			if(graph.containsKey(tmp)) {
				for(int node : graph.get(tmp)) {
					if(!visited[node]) {
						visited[node] = true;
						stack.offerLast(node);
					}
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
	graph = new HashMap<>();
	for(int i=0; i<M; i++) {
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken()) - 1; int b= Integer.parseInt(st.nextToken()) - 1;
		graph.computeIfAbsent(a, x -> new ArrayList<Integer>()).add(b);
		graph.computeIfAbsent(b, x -> new ArrayList<Integer>()).add(a);
	}
	stack = new ArrayDeque<>();
	visited = new boolean[N];
	int cnt = 0;
	for(int i=0; i<N; i++) {
		if(!visited[i]) {
			DFS(i);
			cnt++;
		}
	}
	System.out.println(cnt);
	}
}
