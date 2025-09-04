import java.util.*;
import java.io.*;

public class Main {
	static int[] nums;
	static int N, M;
	static int answer;
	static boolean find;
	static void combination(int count, int index, int total) {
		if(find || total > M) return;
		if(count == 3) {
			if(total == M) {
				find = true; answer = total;
			}
			else if(total < M) {
				answer = Math.max(answer, total);
			}
			return;
		}
		if(index >=N) return;
		
		combination(count+1, index+1, total + nums[index]);
		combination(count, index+1, total);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		answer = 0; find = false;
		combination(0, 0, 0);
		System.out.println(answer);
	}
}
