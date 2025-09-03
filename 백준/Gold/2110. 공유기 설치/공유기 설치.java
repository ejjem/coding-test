import java.io.*;
import java.util.*;

class Main {
    static int N, C;
    static long[] home;

    static boolean can(long d) { // 최소 간격 d로 C개 이상 설치 가능?
        int cnt = 1;
        long last = home[0];
        for (int i = 1; i < N; i++) {
            if (home[i] - last >= d) {
                cnt++;
                last = home[i];
                if (cnt >= C) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        home = new long[N];
        for (int i = 0; i < N; i++) home[i] = Long.parseLong(br.readLine());
        Arrays.sort(home);

        long start = 1, end = home[N - 1] - home[0], ans = 0;
        while (start <= end) {
            long mid = start + ((end - start) / 2);
            if (can(mid)) { // 가능, 더 키워보기
                ans = mid;
                start = mid + 1;
            } else {        // 불가능, 줄이기
                end = mid - 1;
            }
        }
        System.out.println(ans);
    }
}