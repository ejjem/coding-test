import java.io.*;
import java.util.*;

class Main {

    static final int MOD = 880_228;
    static int[][] memo = new int[101][101];

    static int func(int x, int y) {
        if (x <= 0) {
            return y;
        }

        if (y <= 0) {
            return x;
        }

        if (memo[x][y] != -1) {
            return memo[x][y];
        }

        long result = 1L
                + func(x - 1, y - 1)
                + func(x, y - 1)
                + func(x - 1, y);

        return memo[x][y] = (int) (result % MOD);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        System.out.println(func(X, Y));
    }
}
