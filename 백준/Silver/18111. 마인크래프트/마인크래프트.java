import java.io.IOException;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 세로
        int M = Integer.parseInt(st.nextToken()); // 가로
        int B = Integer.parseInt(st.nextToken()); // 시작 인벤토리 내 블록 갯수
        int[][] map = new int[N][M];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                map[i][j] = tmp;
                max = Math.max(max, tmp);
                min = Math.min(min, tmp);
            }
        }

        int answerTime = Integer.MAX_VALUE;
        int answerHeight = -1;

        for (int h = min; h <= max; h++) {
            int time = 0;
            int inventory = B;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int cur = map[i][j];

                    if (cur > h) {
                        int remove = cur - h;
                        time += remove * 2;
                        inventory += remove;
                    } else if (cur < h) {
                        int add = h - cur;
                        time += add;
                        inventory -= add;
                    }
                }
            }

            if (inventory >= 0) {
                if (time < answerTime || (time == answerTime && h > answerHeight)) {
                    answerTime = time;
                    answerHeight = h;
                }
            }
        }

        System.out.println(answerTime + " " + answerHeight);
    }
}