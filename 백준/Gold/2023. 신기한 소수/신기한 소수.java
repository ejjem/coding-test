import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static char[] answer;
	static StringBuilder sb;
	static char[] nums = {'1', '2', '3', '5', '7', '9'};
	static boolean isPrime(int n) {
	    if (n < 2) return false;
	    if (n % 2 == 0) return n == 2;  
	    if (n % 3 == 0) return n == 3;  

	    for (int i = 5; i <= n / i; i += 2) {
	        if (n % i == 0) return false;
	    }
	    return true;
	}
	static void DFS(int depth) {
		if(depth == N) {
			for(int i=0; i<N; i++) {
				sb.append(answer[i]);
			}
			sb.append("\n");
			return;
		}
		//System.out.println("depth: " + depth);
		for(char num : nums) {
			int tmp = num - '0';
			for(int i=0; i<depth; i++) {
				tmp += (answer[i] - '0') * Math.pow(10, depth - i);
			}
			if(isPrime(tmp)) {
				answer[depth]  = num;
				DFS(depth+1);
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		answer = new char[N];
		
		DFS(0);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString()); bw.flush(); bw.close();
	}
}
