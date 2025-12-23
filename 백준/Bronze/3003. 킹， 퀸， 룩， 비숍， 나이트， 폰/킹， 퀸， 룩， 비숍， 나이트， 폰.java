import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 1. 상수(Constant) 사용: 변하지 않는 값은 상수로 선언하여 가독성과 안정성을 높입니다.
    // final 키워드는 이 배열이 다른 값으로 재할당되는 것을 막아줍니다.
    private static final int[] CORRECT_PIECE_COUNTS = {1, 1, 2, 2, 2, 8};

    public static void main(String[] args) throws IOException {
        // 2. 더 빠른 입력을 위한 BufferedReader 사용
        // try-with-resources 구문을 사용하여 자원을 자동으로 해제합니다. (안정성)
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            
            // 3. 한 줄을 통째로 읽고 공백으로 분리 (효율성)
            // Scanner의 nextInt()를 여러 번 호출하는 것보다 한 번에 읽는 것이 더 빠릅니다.
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            // 4. 출력을 효율적으로 관리하기 위한 StringBuilder 사용 (성능)
            // System.out.print()를 반복문 안에서 호출하면 성능 저하의 원인이 될 수 있습니다.
            // 결과를 StringBuilder에 모았다가 마지막에 한 번만 출력하는 것이 좋습니다.
            StringBuilder sb = new StringBuilder();

            for (int correctCount : CORRECT_PIECE_COUNTS) {
                // 입력받은 값을 정수로 변환
                int foundCount = Integer.parseInt(st.nextToken());
                
                // 필요한 피스 개수를 계산하여 StringBuilder에 추가
                sb.append(correctCount - foundCount).append(" ");
            }

            // 5. 최종 결과 출력
            // trim()을 사용하여 마지막 공백을 제거합니다.
            System.out.println(sb.toString().trim());
        }
    }
}