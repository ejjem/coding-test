import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 필요한 줄 수
        int M = Integer.parseInt(st.nextToken()); // 브랜드 수

        int minPack = Integer.MAX_VALUE;
        int minOne = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int pack = Integer.parseInt(st.nextToken());
            int one = Integer.parseInt(st.nextToken());

            minPack = Math.min(minPack, pack);
            minOne = Math.min(minOne, one);
        }

        int answer = Integer.MAX_VALUE;

        // 1) 전부 낱개로 사는 경우
        answer = Math.min(answer, N * minOne);

        // 2) 묶음 + 낱개 조합
        answer = Math.min(answer, (N / 6) * minPack + (N % 6) * minOne);

        // 3) 남는 줄이 있어도 묶음으로 하나 더 사는 경우
        answer = Math.min(answer, ((N / 6) + 1) * minPack);

        System.out.println(answer);
    }
}