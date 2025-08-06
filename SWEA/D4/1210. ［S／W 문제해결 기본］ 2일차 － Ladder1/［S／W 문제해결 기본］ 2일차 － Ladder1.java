import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test = 0; test < 10; test++) {
            int tc = Integer.parseInt(br.readLine());
            int[][] ladder = new int[100][100];

            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    ladder[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int start = 0;
            for (int i = 0; i < 100; i++) {
                if (ladder[99][i] == 2) {
                    start = i;
                    break;
                }
            }

            int y = 99;
            while (true) {
                if (y == 0) break;

                if (start - 1 >= 0 && ladder[y][start - 1] == 1) {
                    while (start - 1 >= 0 && ladder[y][start - 1] == 1) {
                        start--;
                    }
                } else if (start + 1 < 100 && ladder[y][start + 1] == 1) {
                    while (start + 1 < 100 && ladder[y][start + 1] == 1) {
                        start++;
                    }
                }

                y--;
            }

            System.out.println("#" + tc + " " + start);
        }
    }
}