import java.io.*;
import java.util.*;

/*
    dp[day][coupon] = day일까지 모두 처리했고, coupon장을 가지고 있을 때의 최소 비용
    dp[0][0] = 아직 1일차를 처리하기 전 
    dp[N][coupon] = N일까지 모두 처리한 종료 상태
*/

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<Integer> excepts = new HashSet<>();

        if (M > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                excepts.add(Integer.parseInt(st.nextToken()));
            }
        }

        int INF = Integer.MAX_VALUE;
        int MAX_COUPON = N + 1;

        int[][] dp = new int[N + 1][MAX_COUPON + 1];

        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], INF);
        }

        dp[0][0] = 0;

        for (int day = 0; day < N; day++) {
            for (int coupon = 0; coupon <= MAX_COUPON; coupon++) {

                if (dp[day][coupon] == INF) continue;

                int curMoney = dp[day][coupon];
                int currentDay = day + 1;

                // 리조트에 가지 않는 날
                if (excepts.contains(currentDay)) {
                    dp[day + 1][coupon] = Math.min(dp[day + 1][coupon], curMoney);
                    continue;
                }

                // 1일 이용권
                dp[day + 1][coupon] = Math.min(dp[day + 1][coupon], curMoney + 10000);

                // 3일 이용권
                int next3 = Math.min(N, day + 3);
                if (coupon + 1 <= MAX_COUPON) {
                    dp[next3][coupon + 1] = Math.min(dp[next3][coupon + 1], curMoney + 25000);
                }

                // 5일 이용권
                int next5 = Math.min(N, day + 5);
                if (coupon + 2 <= MAX_COUPON) {
                    dp[next5][coupon + 2] = Math.min(dp[next5][coupon + 2], curMoney + 37000);
                }

                // 쿠폰 3장으로 하루 이용
                if (coupon >= 3) {
                    dp[day + 1][coupon - 3] = Math.min(dp[day + 1][coupon - 3], curMoney);
                }
            }
        }

        int answer = INF;

        for (int coupon = 0; coupon <= MAX_COUPON; coupon++) {
            answer = Math.min(answer, dp[N][coupon]);
        }

        System.out.println(answer);
    }
}