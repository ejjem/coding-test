import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb;
    static int answer;
    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<T+1;tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] trees = new int[N];
            int maximum = Integer.MIN_VALUE;
            answer = 0;
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
                trees[i] = Integer.parseInt(st.nextToken());
                maximum = Math.max(maximum, trees[i]);
            }
            int needTogrow = 0; // 키워야 하는 나무 수
            int possible = 0; // 2씩 자라도 괜찮은 나무 수
            int flag = 0; // 전날 1 자랐는지, 2 자랐는지
            for(int tree : trees) {
                int tmp = maximum - tree;
                possible += tmp / 2;
                needTogrow += tmp;
            }
            while(needTogrow > 0) {
                if(possible > 0 && needTogrow >= 2) {
                    if(needTogrow >= 3) {
                        needTogrow -= 3;
                        possible --;
                        // 1 2
                        if(flag != 1) {
                            answer += 2;
                            flag = 2;
                        }
                    }
                    else {
                        needTogrow -= 2;
                        possible --;
                        if(flag == 1) {
                            answer += 1;
                            flag = 2;
                        }
                        else {
                            answer += 2;
                            flag = 2;
                        }
                    }
                }
                else {
                    needTogrow --;
                    if(flag != 1) {
                        answer += 1;
                        flag = 1;
                    }
                    else {
                        answer += 2;
                        flag = 1;
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
