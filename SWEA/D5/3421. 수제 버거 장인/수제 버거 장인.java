import java.io.*;
import java.util.*;

public class Solution {
    static int N, M;
    static int[] conflict;
    static long ans;

    static void dfs(int idx, int chosen) {
    	// 종료 조건 
        if (idx == N) { ans++; return; }
        // 선택 x
        dfs(idx + 1, chosen);
        // 가능할 경우 선택 
        if ( (chosen & conflict[idx]) == 0 ) {
            dfs(idx + 1, chosen | (1 << idx));
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            conflict = new int[N];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                conflict[a] |= 1 << b;
                conflict[b] |= 1 << a;
            }
            ans = 0;
            dfs(0, 0);
            sb.append('#').append(tc).append(' ').append(ans).append('\n');
        }
        System.out.print(sb);
    }
}