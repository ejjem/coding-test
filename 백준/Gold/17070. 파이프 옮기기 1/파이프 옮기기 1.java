import java.util.*;
import java.io.*;

/*
 pipe위치: (y, x)
 pipe의 상태: 0(가로), 1(세로), 2(대각선)
 -> 각 상태별로 움직일 수 있는 동작이 다름
 	0(가로): dist[0], dist[2] 가능
 	1(세로): dist[0], dist[1] 가능
 	2(세로): dist[0], dist[1], dist[2] 가능
 	그냥 하드코딩 하는게 나려나?
 
 움직이는 동작: dist[0](가로), dist[1], dist[2]
 	dist[0]: (y, x+1)이 빈 칸
 	dist[1]: (y+1, x)가 빈 칸
 	dist[2]: (y, x+1), (y+1, x), (y+1, x+1)이 빈 칸
 */



public class Main {
    static int N;
    static int[][] map;
    static long[][][] mem; 
    static void moveH(int bY, int bX, int fY, int fX, int s) {
        if (fX + 1 < N && map[fY][fX + 1] == 0) {
            mem[fY][fX + 1][0] += mem[fY][fX][s];
        }
    }
    static void moveV(int bY, int bX, int fY, int fX, int s) {
        if (fY + 1 < N && map[fY + 1][fX] == 0) {
            mem[fY + 1][fX][1] += mem[fY][fX][s];
        }
    }
    static void moveD(int bY, int bX, int fY, int fX, int s) {
        if (fY + 1 < N && fX + 1 < N &&
            map[fY][fX + 1] == 0 && map[fY + 1][fX] == 0 && map[fY + 1][fX + 1] == 0) {
            mem[fY + 1][fX + 1][2] += mem[fY][fX][s]; // ← x+1로 수정
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        mem = new long[N][N][3];
        mem[0][1][0] = 1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (map[y][x] == 1) continue;
                if (mem[y][x][0] > 0) { // 가로로 (y,x)에 도착
                    moveH(0,0,y,x,0);
                    moveD(0,0,y,x,0);
                }
                if (mem[y][x][1] > 0) { // 세로로 (y,x)에 도착
                    moveV(0,0,y,x,1);
                    moveD(0,0,y,x,1);
                }
                if (mem[y][x][2] > 0) { // 대각으로 (y,x)에 도착
                    moveH(0,0,y,x,2);
                    moveV(0,0,y,x,2);
                    moveD(0,0,y,x,2);
                }
            }
        }

        long ans = mem[N-1][N-1][0] + mem[N-1][N-1][1] + mem[N-1][N-1][2];
        System.out.println(ans);
    }
}
