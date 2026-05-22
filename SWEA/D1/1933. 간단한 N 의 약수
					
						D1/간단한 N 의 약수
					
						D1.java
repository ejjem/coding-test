import java.io.*;
import java.util.*;
class Solution {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        sb.append(1);
        for(int i=2; i<=N; i++){
            if(N % i == 0){
                sb.append(" ").append(i);
            }
        }
        bw.append(sb);
        bw.close();
	}
}