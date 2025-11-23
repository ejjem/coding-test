import java.io.IOException;
import java.io.*;
import java.util.*;

class Main {
    static int[][] dir = { {1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1} };
    static int M, N, H;
    static boolean isPossible(int z, int y, int x){
        if(z < H && z >= 0 && y < N && y >= 0 && x < M && x >= 0) return true;
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로
        H = Integer.parseInt(st.nextToken()); // 높이
        int total = M * N * H;
        int noTomato = 0;
        int Tomato = 0;
        Deque<int[]> deque = new ArrayDeque<>();

        int[][][] board = new int[H][N][M];
        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<M; k++){
                    int tmp = Integer.parseInt(st.nextToken());
                    board[i][j][k] = tmp;
                    if(tmp == -1) noTomato ++;
                    if(tmp == 1) {
                        deque.offerLast(new int[]{i, j, k, 0});
                        Tomato ++;
                    }
                }
            }
        }

        // 조기 종료 조건
        if(Tomato + noTomato == total){
            System.out.println("0"); 
            return;
        }
        int day = -1;
        while(!deque.isEmpty()){
            day ++;
            while(!deque.isEmpty() && deque.peek()[3] == day){
                int[] cur = deque.pollFirst();
                int z = cur[0]; int y = cur[1]; int x = cur[2]; day = cur[3];
                for(int i=0; i<6; i++){
                    int nz = dir[i][0] + z; int ny = dir[i][1] + y; int nx = dir[i][2] + x;
                    if(isPossible(nz, ny, nx) && board[nz][ny][nx] == 0){
                        board[nz][ny][nx] = 1;
                        Tomato ++;
                        deque.offerLast(new int[]{nz, ny, nx, day+1});
                    }
                }
            }
        }
        if(Tomato + noTomato != total){
            System.out.println("-1");
            return;
        }
        System.out.println(day);
        return;
    }
}