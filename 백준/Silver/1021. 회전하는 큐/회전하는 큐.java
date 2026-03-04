import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) dq.addLast(i);

        st = new StringTokenizer(br.readLine());
        int ans = 0;

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());

            int idx = 0;
            for (int x : dq) {
                if (x == target) break;
                idx++;
            }

            int left = idx;
            int right = dq.size() - idx;

            if (left <= right) {
                for (int k = 0; k < left; k++) dq.addLast(dq.pollFirst());
                ans += left;
            } else {
                for (int k = 0; k < right; k++) dq.addFirst(dq.pollLast());
                ans += right;
            }

            dq.pollFirst();
        }

        System.out.println(ans);
    }
}