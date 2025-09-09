import java.io.*;
import java.util.*;

public class Main {    
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static boolean flag;
	static int[] group;
	static int[] check;
	static int V, E;
	static void DFS(int s) {
		visited[s] = true;
		for(int n : graph[s]) {
			if(!visited[n]) {
				check[n] = (check[s] + 1) % 2;
				DFS(n);
			}
			else if(check[n] == check[s]) {
				flag = false;
				break;
			}
		}
	}
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	int T = Integer.parseInt(br.readLine());
    	for(int tc=0; tc<T; tc++) {
    		st = new StringTokenizer(br.readLine());
    		V = Integer.parseInt(st.nextToken()); E = Integer.parseInt(st.nextToken());
    		graph = new ArrayList[V];
    		check = new int[V];
    		for(int i=0; i<V; i++) graph[i] = new ArrayList<>();
    		for(int i=0; i<E; i++) {
    			st = new StringTokenizer(br.readLine());
    			int s = Integer.parseInt(st.nextToken()) - 1; int e = Integer.parseInt(st.nextToken()) - 1;
    			graph[s].add(e);
    			graph[e].add(s);
    		}
    		flag = true;
    		visited = new boolean[V];
    		for(int i=0; i<V; i++) {
    			if(flag) DFS(i);
    		}
    		if(flag) sb.append("YES").append("\n");
    		else sb.append("NO").append("\n");
    	}
    	bw.write(sb.toString()); bw.flush(); bw.close();
    }
}