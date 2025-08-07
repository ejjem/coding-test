import java.util.*;
import java.io.*;

class Solution {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for(int tc=1;tc<T+1;tc++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] fly = new int[N][N];
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    fly[i][j] = Integer.parseInt(st.nextToken());
                }
            }
    
            int maximum = Integer.MIN_VALUE;
            int fly_sum = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    fly_sum = 0;
                    for(int ii=0; ii<M; ii++){
                        for(int jj=0; jj<M; jj++){
                            if(i+ii < N && j+jj < N) fly_sum += fly[i+ii][j+jj];
                        }
                    }
                    if(fly_sum > maximum) maximum = fly_sum;
                }
            }
            sb.append("#").append(tc).append(" ").append(maximum).append("\n");
        }
        System.out.println(sb);
    }
}