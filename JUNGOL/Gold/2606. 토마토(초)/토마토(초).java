import java.io.*;
import java.util.*;

class Main{
    static int[][] dir = {
        {1, 0, 0},
        {-1, 0, 0},
        {0, 1, 0},
        {0, -1, 0},
        {0, 0, 1},
        {0, 0, -1}
    };
    static int[][][] map;
    public static boolean possible(int Z, int Y, int X, int z, int y, int x){
        if(z >= 0 && z < Z && y >= 0 && y < Y && x >= 0 && x < X){
            return true;
        }
        return false;
    }
    public static void main(String[] args) throws IOException{
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // x
        int N = Integer.parseInt(st.nextToken()); // y
        int H = Integer.parseInt(st.nextToken()); // z
        int total = M * N * H;
        map = new int[H][N][M];
        Deque<int[]> queue = new ArrayDeque<>();
        int notTomato = 0;
        int tomato = 0;

        for(int z=0; z<H; z++){
            for(int y=0; y<N; y++){
                st = new StringTokenizer(br.readLine());
                for(int x=0; x<M; x++){
                    map[z][y][x] = Integer.parseInt(st.nextToken());
                    if(map[z][y][x] == 1){
                        tomato ++;
                        queue.offerLast(new int[]{z, y, x, 0});
                    }
                    else if(map[z][y][x] == -1){
                        notTomato ++;
                    }
                }
            }
        }

        while(!queue.isEmpty()){
            int[] cur = queue.pollFirst();
            int z = cur[0];
            int y = cur[1];
            int x = cur[2];
            int day = cur[3];
            for(int i=0; i<6; i++){
                int nz = z + dir[i][0];
                int ny = y + dir[i][1];
                int nx = x + dir[i][2];
                if(possible(H, N, M, nz, ny, nx) && map[nz][ny][nx] == 0){
                    answer = day + 1;
                    map[nz][ny][nx] = 1;
                    tomato ++;
                    queue.offerLast(new int[]{nz, ny, nx, day+1});
                }
            }
        }
        if(total == (tomato + notTomato)) System.out.println(answer);
        else System.out.println(-1);
    } 
}