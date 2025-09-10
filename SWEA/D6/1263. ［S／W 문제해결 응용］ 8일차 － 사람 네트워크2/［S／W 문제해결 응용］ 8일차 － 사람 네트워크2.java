import java.io.*;
import java.util.*;
 
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int answer = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[][] graph = new int[N][N];
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(Integer.parseInt(st.nextToken()) == 1) graph[i][j] = 1;
                    else if(i != j) graph[i][j] = 10000;
                }
            }
             
            for(int k=0; k<N; k++) {
                for(int i=0; i<N; i++) {
                    for(int j=0; j<N; j++) {
                    	graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    }
                }
            }
            for(int i=0; i<N; i++) {
                int tmp = 0;
                for(int j=0; j<N; j++) {
                    tmp += graph[i][j];
                }
                answer = Math.min(answer, tmp);
            }
            sb.append('#').append(tc).append(' ').append(answer).append('\n');
        }
        System.out.print(sb.toString());
    }
}