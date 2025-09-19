import java.util.*;
import java.io.*;

class Main {
	static int N, M;
	static int[][] graph;
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	graph = new int[N][N];
    	for(int i=0; i<M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int u = Integer.parseInt(st.nextToken()) - 1;
    		int v = Integer.parseInt(st.nextToken()) - 1;
    		graph[u][v] = 1;
    		graph[v][u] = 1;
    	}
    		
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
    	
    	int min = Integer.MAX_VALUE;
    	int answer = 0;
    	for(int i=0; i<N; i++) {
    		int tmp = 0;
    		for(int j=0; j<N; j++) {
    			tmp += graph[i][j];
    		}
    		if(min > tmp) {
    			min = tmp;
    			answer = i+1;
    		}
    	}
    	System.out.println(answer);
    }
}