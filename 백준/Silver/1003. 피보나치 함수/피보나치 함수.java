import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    // DP 테이블을 static으로 선언하여 여러 테스트 케이스에서 한 번만 계산하도록 함
    static int[][] dp = new int[41][2];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 1. DP 테이블의 기저 상태(초기값) 설정
        dp[0][0] = 1; // N=0일 때 0 호출 횟수
        dp[0][1] = 0; // N=0일 때 1 호출 횟수
        dp[1][0] = 0; // N=1일 때 0 호출 횟수
        dp[1][1] = 1; // N=1일 때 1 호출 횟수

        // 2. 반복문을 통해 DP 테이블 채우기 (바텀업 방식)
        // N의 최대값 40까지 미리 계산
        for (int i = 2; i <= 40; i++) {
            // 점화식 적용
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }

        // 3. 테스트 케이스 수 T 입력
        int T = Integer.parseInt(br.readLine());

        // 4. 각 테스트 케이스 N에 대해 결과 출력
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            // 미리 계산된 값을 StringBuilder에 추가
            sb.append(dp[N][0]).append(" ").append(dp[N][1]).append("\n");
        }

        // 5. 최종 결과 한 번에 출력
        System.out.print(sb);
    }
}
