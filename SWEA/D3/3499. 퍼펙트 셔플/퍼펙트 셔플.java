import java.util.*;
import java.io.*;

class Solution {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<T+1; tc++) {
        	int N = Integer.parseInt(br.readLine());
        	st = new StringTokenizer(br.readLine());
        	String[] save = new String[N];
        	for(int i=0; i<N; i++) {
        		save[i] = st.nextToken();
        	}
        	sb.append("#").append(tc).append(" ");
        	if(N%2 == 0) {
        		for(int i=0; i<N/2; i++) {
        			sb.append(save[i]).append(" ");
        			sb.append(save[i+N/2]).append(" ");
        		}
        		sb.append("\n");
        	}
        	else {
        		for(int i=0; i<N/2; i++) {
        			sb.append(save[i]).append(" ");
        			sb.append(save[i+N/2+1]).append(" ");
        		}
        		sb.append(save[N/2]);
        		sb.append("\n");
        	}
        }
        bw.write(sb.toString()); bw.flush(); bw.close();
    }
}