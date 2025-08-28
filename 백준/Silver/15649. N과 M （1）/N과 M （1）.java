import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb;
	static int N, M;
	static boolean[] used;
	static void DFS(int length, int[] arr) {
		if(length == M) {
			for(int i=0; i<M; i++) {
				sb.append(arr[i]).append(" ");
			}
				sb.append("\n");
				return;
		}
		for(int i=1; i<N+1; i++) {
			if(used[i]) continue;
			arr[length] = i;
			used[i] = true;
			DFS(length+1, arr);
			used[i] = false;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();
		used = new boolean[N+1];
		int[] arr = new int[M];
		DFS(0, arr);
		System.out.println(sb);
	}
}