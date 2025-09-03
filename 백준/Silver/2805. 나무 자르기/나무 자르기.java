import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
		int[] trees = new int[N];
		st = new StringTokenizer(br.readLine());
		int maxTree = 0;
		for(int i=0; i<N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			maxTree = Math.max(maxTree, trees[i]);
		}
		int start = 0; int end = maxTree;
        int answer = 0;
        while(start <= end){
            int mid = start + (end - start) / 2;
            long sum = 0;
            for(int tall : trees){
                if(tall > mid) sum += tall - mid;
            }
            if(sum >= M){
                answer = mid;
                start = mid + 1;
            }
            else end = mid - 1;
        }
		System.out.println(answer);
	}
}
