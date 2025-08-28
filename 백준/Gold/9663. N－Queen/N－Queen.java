import java.io.*;
import java.util.*;


class Main {
    static int N;
    static int answer;
    static boolean[] col, diag1, diag2;
    static void DFS(int depth){
        if(depth == N){ answer ++; return; }
        for(int i=0; i<N; i++){
            int d1 = depth + i;
            int d2 = depth - i + N - 1;
            if(col[i] || diag1[d1] || diag2[d2]) continue;
            
            col[i] = diag1[d1] = diag2[d2] = true;
            DFS(depth + 1);
            col[i] = diag1[d1] = diag2[d2] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        N = Integer.parseInt(br.readLine());
        col = new boolean[N];
        diag1 = new boolean[2*N - 1];
        diag2 = new boolean[2*N - 1];
        answer = 0;
        DFS(0);
        System.out.println(answer);

    }
}