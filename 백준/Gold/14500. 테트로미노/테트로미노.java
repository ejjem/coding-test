import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[][] map;

    static int[][][] tetro = {
        {{0, 0}, {0, 1}, {0, 2}, {0, 3}},
        {{0, 0}, {0, 1}, {1, 0}, {1, 1}},
        {{0, 0}, {1, 0}, {2, 0}, {2, 1}},
        {{0, 0}, {1, 0}, {1, 1}, {2, 1}},
        {{0, 0}, {0, 1}, {0, 2}, {1, 1}},
        {{0, 0}, {1, 0}, {2, 0}, {2, -1}},
        {{0, 0}, {1, 0}, {1, -1}, {2, -1}}
    };

    static boolean isPossible(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }

    static int getSum(int sy, int sx, int[][] shape, int mode) {
        int sum = 0;

        for (int i = 0; i < 4; i++) {
            int y = shape[i][0];
            int x = shape[i][1];

            int ny = 0, nx = 0;

            if (mode == 0) {         // 원본
                ny = sy + y;
                nx = sx + x;
            } else if (mode == 1) {  // 180도 회전
                ny = sy - y;
                nx = sx - x;
            } else if (mode == 2) {  // 90도 회전
                ny = sy - x;
                nx = sx + y;
            } else if (mode == 3) {  // 270도 회전
                ny = sy + x;
                nx = sx - y;
            }

            if (!isPossible(ny, nx)) return 0;
            sum += map[ny][nx];
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 7; k++) {
                    for (int mode = 0; mode < 4; mode++) {
                        answer = Math.max(answer, getSum(i, j, tetro[k], mode));
                    }
                }
            }
        }

        System.out.println(answer);
    }
}