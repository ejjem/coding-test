import java.util.*;
import java.io.*;

public class Solution {
	
	static int distance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1-x2) + Math.abs(y1-y2);
	}
	
	static boolean NextPermutation(int[] selected) {
		int n = selected.length;
		int pivot = n - 2;
		
		while(pivot >= 0 && selected[pivot] >= selected[pivot + 1]) pivot --;
		if(pivot < 0) return false;
		
		int successor = n-1;
		while (selected[successor] <= selected[pivot]) successor--;
		
		swap(selected, pivot, successor);
		reverse(selected, pivot + 1, n - 1);
		
		return true;
		
	}
	static void swap(int[] selected, int a, int b) {
		int tmp = selected[a];
		selected[a] = selected[b];
		selected[b] = tmp;
		
	}
	
	static void reverse(int[] selected, int start, int end) {
		while(start < end) {
			swap(selected, start++, end--);
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<T+1;tc++) {
			int answer = 0;
			int N = Integer.parseInt(br.readLine());
			int[] Xs = new int[N+2]; int[] Ys = new int[N+2];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N+2; i++) {
				Xs[i] = Integer.parseInt(st.nextToken());
				Ys[i] = Integer.parseInt(st.nextToken());
			}
			// N개
			int[] indexes = new int[N];
			for(int i=0; i<N; i++) {
				indexes[i] = i+2; 
			}
			
			int x = Xs[0]; int y = Ys[0];
			for(int i=0; i<N; i++) {
				int target = indexes[i];
				answer += distance(x, y, Xs[target], Ys[target]);
				x = Xs[target]; y = Ys[target];
			}
			answer += distance(x, y, Xs[1], Ys[1]);
			
			while(NextPermutation(indexes)) {
				x = Xs[0]; y = Ys[0];
				int tmp = 0;
				boolean flag = false;
				for(int i=0; i<N; i++) {
					int target = indexes[i];
					tmp += distance(x, y, Xs[target], Ys[target]);
					if(tmp >= answer) {
						flag = true;
						break;
					}
					x = Xs[target]; y = Ys[target];
				}
				if(flag) continue;
				tmp += distance(x, y, Xs[1], Ys[1]);
				if(tmp < answer) answer = tmp;
			}
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush(); bw.close();
	}
}
