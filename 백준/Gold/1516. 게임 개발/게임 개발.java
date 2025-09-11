import java.util.*;
import java.io.*;

class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] graph = new ArrayList[N];
        int[] time = new int[N];
        int[] level = new int[N];
        int[] answer = new int[N];
        for(int i=0; i<N; i++) graph[i] = new ArrayList<>();
        
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	time[i] = Integer.parseInt(st.nextToken());
        	while(true) {
        		int n = Integer.parseInt(st.nextToken());
        		if(n == -1) break;
        		graph[n-1].add(i);
        		level[i] ++;
        	}
        }
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i=0; i<N; i++) {
        	if(level[i] == 0) {
        		q.add(i);
        	}
        }
        while(!q.isEmpty()) {
        	int cur = q.pollFirst();
        	answer[cur] += time[cur];
        	for(int n : graph[cur]) {
        		level[n] --;
        		answer[n] = Math.max(answer[n], answer[cur]);
        		if(level[n] == 0) {
        			q.offerLast(n);
        		}
        	}
        }
        for(int i=0; i<N; i++) {
        	sb.append(answer[i]).append("\n");
        }
        bw.write(sb.toString()); bw.flush(); bw.close();
    }
}