import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[] dp = new int[T + 1];
        dp[0] = 1;

        for (int c = 0; c < k; c++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int coin = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            int[] next = new int[T + 1];

            // 같은 나머지를 가지는 금액끼리 처리
            for (int remainder = 0; remainder < coin && remainder <= T; remainder++) {
                int windowSum = 0;

                for (int money = remainder; money <= T; money += coin) {
                    // 새로운 dp[money]가 범위에 들어옴
                    windowSum += dp[money];

                    // 사용할 수 있는 동전 개수를 초과한 항은 제거
                    int removedMoney = money - coin * (count + 1);

                    if (removedMoney >= 0) {
                        windowSum -= dp[removedMoney];
                    }

                    next[money] = windowSum;
                }
            }

            dp = next;
        }

        System.out.println(dp[T]);
    }
}