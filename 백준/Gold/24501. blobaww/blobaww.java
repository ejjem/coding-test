import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static final long NUM = 1000000007L;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] matrix = new char[N][M];
        int[][] Ecnt = new int[N][M];
        int[][] Mcnt = new int[N][M];
        long dp = 0;
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                matrix[i][j] = str.charAt(j);
            }
        }
        // 구간합으로 E 채우기
        if(matrix[0][0] == 'E') Ecnt[0][0] = 1;
        for(int i=1; i<M; i++){
            Ecnt[0][i] += Ecnt[0][i-1];
            if(matrix[0][i] == 'E') Ecnt[0][i] += 1;
        }
        for(int i=1; i<N; i++){
            Ecnt[i][0] += Ecnt[i-1][0];
            if(matrix[i][0] == 'E') Ecnt[i][0] += 1;
        }
        for(int i=1; i<N; i++){
            for(int j=1; j<M; j++){
                Ecnt[i][j] = Ecnt[i-1][j] + Ecnt[i][j-1] - Ecnt[i-1][j-1];
                if(matrix[i][j] == 'E') Ecnt[i][j] += 1;
            }
        }
        // 구간합으로 M 채우기
        if(matrix[N-1][M-1] == 'M') Mcnt[N-1][M-1] = 1;
        for(int i=N-2; i>=0; i--){
            Mcnt[i][M-1] += Mcnt[i+1][M-1];
            if(matrix[i][M-1] == 'M') Mcnt[i][M-1] += 1;
        }
        for(int i=M-2; i>=0; i--){
            Mcnt[N-1][i] += Mcnt[N-1][i+1];
            if(matrix[N-1][i] == 'M') Mcnt[N-1][i] += 1;
        }
        for(int i=N-2; i>=0; i--){
            for(int j=M-2; j>=0; j--){
                Mcnt[i][j] = Mcnt[i+1][j] + Mcnt[i][j+1] - Mcnt[i+1][j+1];
                if(matrix[i][j] == 'M') Mcnt[i][j] += 1;
            }
        }

        // 검증
        /*
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                System.out.print(Ecnt[i][j] + " ");
            }
            System.out.println();
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                System.out.print(Mcnt[i][j] + " ");
            }
            System.out.println();
        }
        */
        
        // 최종 순회
        // matrix[i][j] = 'S' 이면서 Ecnt[i][j] > 0, Mcnt[i][j] > 0 인 곳 더하기
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(matrix[i][j] == 'S' && Ecnt[i][j] > 0 && Mcnt[i][j] > 0){
                    dp = (dp + (1L * Ecnt[i][j] * Mcnt[i][j]) % NUM) % NUM;
                }
            }
        }
        System.out.println(dp);
    }
}