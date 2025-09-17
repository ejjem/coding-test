import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static Edge[] edges;
    static class Edge{
    	int start;
    	int end;
    	long weight;
    	
    	Edge(int start, int end, long weight){
    		this.start = start;
    		this.end = end;
    		this.weight = weight;
    	}
    }
    static long[] dist;
    
    static boolean bellmanFord(int start) {
    	boolean updated = false;
    	dist = new long[N+1];
    	Arrays.fill(dist, Long.MAX_VALUE);
    	dist[start] = 0;
    	
    	// N-1 만
    	for(int i=1; i<N; i++) {
    		updated = false;
    		for(Edge e : edges) {
    			int u = e.start; int v = e.end; long w = e.weight;
    			if (dist[u] == Long.MAX_VALUE) continue;
    			long nw = dist[u] + w;
    			if(nw < dist[v]) {
    				dist[v] = nw;
    				updated = true;
    			}
    		}
    		if(!updated) break;
    	}
    	for(Edge e : edges) {
			int u = e.start; int v = e.end; long w = e.weight;
			if (dist[u] == Long.MAX_VALUE) continue;
			if(dist[u] + w < dist[v]) return false;
		}
    	return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        edges = new Edge[M];
        for(int i=0; i<M; i++) {
        	 st = new StringTokenizer(br.readLine());
        	 int u = Integer.parseInt(st.nextToken());
        	 int v = Integer.parseInt(st.nextToken());
        	 long w = Long.parseLong(st.nextToken());
        	 edges[i] = new Edge(u, v, w);
        }
        boolean possible = bellmanFord(1);
        if(!possible) {
        	sb.append(-1);
        }else {
        	for(int i=2; i<=N; i++) {
        		if(dist[i] == Long.MAX_VALUE) sb.append(-1).append("\n");
        		else sb.append(dist[i]).append("\n");
        	}
        }
        bw.write(sb.toString()); bw.flush(); bw.close();
    }
}