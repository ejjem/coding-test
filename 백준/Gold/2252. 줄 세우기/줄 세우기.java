import java.util.*;
import java.io.*;

class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] graph = new ArrayList[N];
        int[] level = new int[N];
        for(int i=0; i<N; i++) {
        	graph[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int s = Integer.parseInt(st.nextToken()) - 1;
        	int e = Integer.parseInt(st.nextToken()) - 1;
        	graph[s].add(e);
        	level[e] ++;
        }
        ArrayDeque<Integer> q = new ArrayDeque<>();
        ArrayList<Integer> answer = new ArrayList<>();
        boolean[] visited = new boolean[N];
        for(int i=0; i<N; i++) {
        	if(level[i] == 0) {
        		q.offerLast(i);
        		visited[i] = true;
            	answer.add(i);
        	}
        }
        while(!q.isEmpty()) {
        	int cur = q.pollFirst();
        	for(int n : graph[cur]) {
        		level[n] --;
        		if(level[n] == 0 && !visited[n]) {
        			visited[n] = true;
        			q.offerLast(n);
        			answer.add(n);
        		}
        	}
        }
        for(int i=0; i<answer.size(); i++) {
        	sb.append(answer.get(i) + 1).append(" ");
        }
        bw.write(sb.toString()); bw.flush(); bw.close();
    }
}