import java.util.*;
import java.io.*;


class Main {

    static int N;
    static int[] L;
    static int[] J;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        
        L = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }
        
        J = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            J[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 100, 0);

        System.out.print(result);
    }

    static void dfs(int start, int health, int happy) {
        if (health <= 0) return;
        else result = Math.max(result, happy);

        for (int i = start; i < N; i++) {
            dfs(i + 1, health - L[i], happy + J[i]);
        }
    }
}