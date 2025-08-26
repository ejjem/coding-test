import java.util.*;
import java.io.*;

public class Main {	
	static boolean find = false;
	static int N, M;
	static HashMap<Integer, ArrayList<Integer>> graph;
	static boolean[] visited;
	static void DFS(int start, int depth) {
		if(depth == 4) {find = true; return;}
        if(find) return;
		if(graph.containsKey(start)) {
			for(int n : graph.get(start)) {
				if(!visited[n]) {
					visited[n] = true;
					DFS(n, depth+1);
					visited[n] = false;
				}
			}
		
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new HashMap<>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.computeIfAbsent(a, k->new ArrayList<>()).add(b);
			graph.computeIfAbsent(b, k->new ArrayList<>()).add(a);
		}
		visited = new boolean[N]; 
		for(int i=0; i<N; i++) {
            if(find) break;
			if(!visited[i]) {
				visited[i] = true;
				DFS(i, 0);
				visited[i] = false;
			}
		}
		if(find) System.out.println(1);
		else System.out.println(0);
	}
}
