import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br;
	static BufferedWriter bw;
	static StringTokenizer st;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		int[] number = new int[N];
		int[] answer = new int[N];
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
			answer[i] = -1;
		}
		stack.offerLast(0);
		for(int i=1; i<N; i++) {
			while(!(stack.isEmpty()) && number[i] > number[stack.peekLast()] ) {
				answer[stack.pollLast()] = number[i];
			}
			stack.offerLast(i);
		}
		for(int i=0; i<N; i++) {
			sb.append(answer[i]).append(" ");
		}
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
