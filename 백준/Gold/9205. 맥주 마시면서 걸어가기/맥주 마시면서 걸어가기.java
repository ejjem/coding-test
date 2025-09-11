import java.util.*;
import java.io.*;

class Main {
	static int[] current;
	static int[] target;
	static int[][] places;
	static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<T+1; tc++) {
        	int n = Integer.parseInt(br.readLine());
        	current = new int[2]; target = new int[2];
        	places = new int[n+2][2];
        	st = new StringTokenizer(br.readLine());
        	places[0][0] = Integer.parseInt(st.nextToken()); places[0][1] = Integer.parseInt(st.nextToken());
        	current[0] = places[0][0]; current[1] = places[0][1];
        	for(int i=1; i<n+1; i++) {
        		st = new StringTokenizer(br.readLine());
        		places[i][0] = Integer.parseInt(st.nextToken()); places[i][1] = Integer.parseInt(st.nextToken());
        	}
        	st = new StringTokenizer(br.readLine());
        	places[n+1][0] = Integer.parseInt(st.nextToken()); places[n+1][1] = Integer.parseInt(st.nextToken());
        	target[0] = places[n+1][0]; target[1] = places[n+1][1];
        	visited = new boolean[n+2];
        	visited[0] = true;
        	ArrayDeque<int[]> q = new ArrayDeque<>();
        	for(int i=1; i<n+2; i++) {
        		int dist = Math.abs(current[0] - places[i][0]) + Math.abs(current[1] - places[i][1]);
        		if(dist <= 1000) {
        			visited[i] = true;
        			q.offerLast(new int[] {places[i][0], places[i][1]});
        		}
        	}
        	boolean possible = false;
        	while(!q.isEmpty()) {
        		int[] cur = q.pollLast();
        		int x = cur[0]; int y = cur[1];
        		if(x == target[0] && y == target[1]) {
        			possible = true; break;
        		}
        		for(int i=0; i<n+2; i++) {
        			if(visited[i]) continue;
        			int dist = Math.abs(x - places[i][0]) + Math.abs(y - places[i][1]);
            		if(dist <= 1000) {
            			visited[i] = true;
            			q.offerLast(new int[] {places[i][0], places[i][1]});
            		} 
        		}
        	}
        	if(possible) sb.append("happy").append("\n");
        	else sb.append("sad").append("\n");
        }
        bw.write(sb.toString()); bw.flush(); bw.close(); br.close();
    }
}