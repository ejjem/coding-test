import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine().trim());

        int[][] people = new int[N][2]; // [i][0]=몸무게, [i][1]=키
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            people[i][0] = Integer.parseInt(st.nextToken());
            people[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] rank = new int[N];
        Arrays.fill(rank, 1);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (people[j][0] > people[i][0] && people[j][1] > people[i][1]) {
                    rank[i]++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(rank[i]);
            if (i + 1 < N) sb.append(' ');
        }
        System.out.print(sb.toString());
    }
}
