import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 데이터 세팅
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dxs = {0, +1, 0, -1};
        int[] dys = {+1, 0, -1, 0};
        int start_x = 0; int end_x = M;
        int start_y = 0; int end_y = N;
        int x = 0; int y = 0;
        /*
        for(int count=0;count<R;count++){
            start_x = 0; end_x = M;
            start_y = 0; end_y = N;
            int save = 0; int next = 0;
            while(start_x != end_x && start_y != end_y){
                x = start_x; y = start_y;
                save = -1;
                for(int idx = 0; idx<4; idx++){
                    int dx = dxs[idx];
                    int dy = dys[idx];
                    if(save == -1) save = board[y][x];
                    while(x + dx < end_x && x + dx >= start_x && y + dy < end_y && y + dy >= start_y){
                        next = save;
                        save = board[y + dy][x + dx];
                        board[y + dy][x + dx] = next;
                        x += dx;
                        y += dy;
                    }
                }
                start_x ++; start_y ++; end_x --; end_y --; 
            }
        }
        */
        start_x = 0; end_x = M;
        start_y = 0; end_y = N;
        int save, next;

        while (start_x < end_x - 1 && start_y < end_y - 1) {
            int width = end_x - start_x;
            int height = end_y - start_y;
            int len = 2 * (width + height - 2);   
            int rot = R % len;                           

            for (int r = 0; r < rot; r++) {            
                x = start_x; y = start_y;
                save = -1;
                for (int idx = 0; idx < 4; idx++) {
                    int dx = dxs[idx];
                    int dy = dys[idx];
                    if (save == -1) save = board[y][x];
                    while (x + dx < end_x && x + dx >= start_x &&
                        y + dy < end_y && y + dy >= start_y) {
                        next = save;
                        save = board[y + dy][x + dx];
                        board[y + dy][x + dx] = next;
                        x += dx;
                        y += dy;
                    }
                }
            }

            start_x++; start_y++; end_x--; end_y--;
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                System.out.print(board[i][j]);
                if(j != M-1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}