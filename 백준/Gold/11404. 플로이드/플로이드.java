import java.util.*;
import java.io.*;

class Main {
	static int N, M;
	static int[][] graph;
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	N = Integer.parseInt(br.readLine());
    	M = Integer.parseInt(br.readLine());
    	graph = new int[N][N];
    	for(int i=0; i<M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int u = Integer.parseInt(st.nextToken()) - 1;
    		int v = Integer.parseInt(st.nextToken()) - 1;
    		int w = Integer.parseInt(st.nextToken());
    		if(graph[u][v] == 0) graph[u][v] = w;
    		else graph[u][v] = Math.min(graph[u][v], w);
    		/*
    		if(graph[v][u] == 0) graph[v][u] = w;
    		else graph[v][u] = Math.min(graph[v][u], w);
    		*/
    	}
    	//for(int i=0; i<N; i++) System.out.println(Arrays.toString(graph[i]));
    	for(int k=0; k<N; k++) {
    		for(int i=0; i<N; i++) {
    			for(int j=0; j<N; j++) {
    				if(i == j) continue;
    				if(graph[i][k] != 0 && graph[k][j] != 0) {
    					if(graph[i][j] == 0) graph[i][j] = graph[i][k] + graph[k][j];
    					else graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
    				}
    			}
    		}
    	}
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<N; j++) {
    			sb.append(graph[i][j]).append(" ");
    		}
    		sb.append("\n");
    	}
    	bw.write(sb.toString()); bw.flush(); bw.close();
    }
}