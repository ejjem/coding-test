import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()); // 출발점 x
            int y1 = Integer.parseInt(st.nextToken()); // 출발점 y
            int x2 = Integer.parseInt(st.nextToken()); // 도착점 x
            int y2 = Integer.parseInt(st.nextToken()); // 도착점 y

            int n = Integer.parseInt(br.readLine()); // 행성계의 개수
            int count = 0; // 경계 통과 횟수

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int cx = Integer.parseInt(st.nextToken()); // 행성계 중심 x
                int cy = Integer.parseInt(st.nextToken()); // 행성계 중심 y
                int r = Integer.parseInt(st.nextToken());  // 행성계 반지름

                // 출발점이 원 내부에 있는지 확인
                boolean isStartInside = isInside(x1, y1, cx, cy, r);
                // 도착점이 원 내부에 있는지 확인
                boolean isEndInside = isInside(x2, y2, cx, cy, r);

                // 두 점의 상태가 다를 경우 (한 점은 내부, 한 점은 외부에 있을 경우)
                // XOR 연산자(^)를 사용하면 if (isStartInside != isEndInside)와 동일한 효과를 낸다.
                if (isStartInside ^ isEndInside) {
                    count++;
                }
            }
            sb.append(count).append('\n');
        }
        System.out.print(sb);
    }

    /**
     * 점 (x, y)가 중심이 (cx, cy)이고 반지름이 r인 원의 내부에 있는지 판별하는 메서드
     */
    public static boolean isInside(int x, int y, int cx, int cy, int r) {
        // (x - cx)^2 + (y - cy)^2 < r^2 공식을 사용
        // Math.pow()보다 직접 곱하는 것이 성능상 더 빠르다.
        long distanceSquared = (long)(x - cx) * (x - cx) + (long)(y - cy) * (y - cy);
        long radiusSquared = (long)r * r;

        return distanceSquared < radiusSquared;
    }
}