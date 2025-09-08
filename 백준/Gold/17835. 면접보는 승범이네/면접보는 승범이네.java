import java.io.*;
import java.util.*;

public class Main {
	static List<int[]>[] graph;
	static int[] target;
	static int N, M, K;
	static long[] dijkstraAll(int[] start, int N) {
		long[] dist = new long[N];
		Arrays.fill(dist, -1);
		PriorityQueue<long[]> pq = new PriorityQueue<>(new Comparator<long[]>() {
			@Override
			public int compare(long[] o1, long[] o2) {
				return Long.compare(o1[1], o2[1]);
			}
		});
		for(int n : start) {
			dist[n] = 0;
			pq.add(new long[] { (long)n, 0});
		}
		
		while(!pq.isEmpty()) {
			long[] cur = pq.poll();
			int e = (int)cur[0]; long w = cur[1];
			if(dist[e] != w) continue; //stale skip
			for(int[] next : graph[e]) {
				int ne = next[0]; int nw = next[1];
				long totalw = w + nw;
				if(dist[ne] == -1) {
					dist[ne] = totalw;
					pq.add(new long[] {ne, totalw});
				}
				else if(dist[ne] > totalw) {
					dist[ne] = totalw;
					pq.add(new long[] {ne, totalw});
				}
			}
		}
		
		return dist;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N];
		target = new int[K];
		for(int i=0; i<N; i++) graph[i] = new ArrayList<>();
		//1-based
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int U = Integer.parseInt(st.nextToken())-1; int V = Integer.parseInt(st.nextToken())-1; int C = Integer.parseInt(st.nextToken());
			//graph[U].add(new int[] {V, C});
			graph[V].add(new int[] {U, C});
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) {
			target[i] = Integer.parseInt(st.nextToken()) - 1;
		}
		ArrayList<Integer> answer = new ArrayList<>();
		long min = 0;
		int minIndex = 0;
		long[] dist = dijkstraAll(target, N);
		for(int i=0; i<N; i++) {
			if(min < dist[i]) {
				min = dist[i];
				minIndex = i+1;
			}
		}
		sb.append(minIndex).append("\n").append(min);
		bw.write(sb.toString()); bw.flush(); bw.close();
	}
}
