import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    static BufferedReader br;
    static StringBuilder sb;
    static int end;
    
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        end = (1 << 10) - 1;
        for(int tc=1; tc<T+1; tc++){
            int N = Integer.parseInt(br.readLine());
            int tmp = 0;
            int cnt = 1;
            while(true){
                char[] ch = String.valueOf(N * cnt).toCharArray();
                for(int i=0; i<ch.length; i++) {
                	int num = ch[i] - '0';
                	tmp = tmp | (1 << num);
                }
                if(tmp == end) break;
                cnt ++;
            }
            sb.append("#").append(tc).append(" ").append(cnt * N).append("\n");
        }
        System.out.println(sb);
    }
}