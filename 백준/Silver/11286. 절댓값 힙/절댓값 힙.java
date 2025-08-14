import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static class Value implements Comparable<Value> {
		int val;
		Value(int val){
			this.val = val;
		}
		
		@Override
		public int compareTo(Value o) {
			int abs_val = Math.abs(val);
			int abs_o = Math.abs(o.val);
			if(abs_val == abs_o) {
				return this.val - o.val;
			}
			else return abs_val - abs_o;
		}
	}
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Value> pq = new PriorityQueue<>();
		// 0 -> 배열에서 절댓값이 가장 작은 값 출력
		// 그 외 -> 배열에 값 추가
		sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			int option = Integer.parseInt(br.readLine());
			if(option == 0) {
				if(pq.isEmpty()) sb.append(0).append("\n");
				else {
					sb.append(pq.poll().val).append("\n");
				}
			}
			else {
				pq.offer(new Value(option));
			}
		}
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
