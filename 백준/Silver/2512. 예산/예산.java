import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] req = new int[N];
		int min = Integer.MAX_VALUE;
		int max = 0;
		for(int i=0; i<N; i++) {
			req[i] = Integer.parseInt(st.nextToken());
			max = Math.max(req[i], max);
		}
		long total = Long.parseLong(br.readLine());
		int start = 0; int end = max;
		int answer = 0;
		while(start <= end) {
			int mid = start + (end - start) / 2;
			long sum = 0;
			for(int i=0;i<N;i++) {
				if(mid >= req[i]) sum += req[i];
				else sum += mid;
			}
			if(sum <= total) {
				//System.out.println(mid);
				answer = mid;
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
		System.out.println(answer);
	}
}
