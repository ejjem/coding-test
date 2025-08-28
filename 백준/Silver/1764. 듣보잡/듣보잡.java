import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
		HashSet<String> s = new HashSet<>();
		for(int i=0; i<N; i++) {
			s.add(br.readLine());
		}
		PriorityQueue<String> pq = new PriorityQueue<>();
		for(int i=0; i<M; i++) {
			String tmp = br.readLine();
			if(s.contains(tmp)) pq.add(tmp);
		}
		sb.append(pq.size()).append("\n");
		while(!pq.isEmpty()) {
			sb.append(pq.poll()).append("\n");
		}
		bw.write(sb.toString()); bw.flush(); bw.close();
	}
}