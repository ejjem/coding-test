import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		class Node {
			int number;
			int depth;
			Node(int number, int depth){
				this.number = number;
				this.depth = depth;
			}
		}
		
		for(int tc=1; tc<11; tc++) {
			int answer = 0;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			//System.out.println(start);
			HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N/2;i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
			}
			ArrayDeque<Node> q = new ArrayDeque<>();
			int[] visited = new int[101];
			q.offerLast(new Node(start, 1));
			visited[start] = 1;
			int depth = 1;
			while(!q.isEmpty()) {
				while(!q.isEmpty() && q.peekFirst().depth == depth) {
					Node tmp_node = q.pollFirst();
					//System.out.println("---");
					//System.out.println(tmp_node.number);
					int tmp = tmp_node.number;
					if(graph.containsKey(tmp)) {
						for(int n : graph.get(tmp)) {
							if(visited[n] == 0) {
								visited[n] = depth + 1;
								q.offerLast(new Node(n, depth+1));
							}
						}
					}
				}
				depth ++;
			}
			for(int i=0; i<101; i++) {
				if(visited[i] == depth-1 && answer < i) answer = i;
			}
			//System.out.println(Arrays.toString(visited));
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}


