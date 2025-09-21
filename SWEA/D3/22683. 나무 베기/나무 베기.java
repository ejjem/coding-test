import java.util.*;
import java.io.*;

public class Solution {
    static int N, K, posX, posY, tarX, tarY;
    static char[][] map;
    static boolean[][][][] visited;
    static ArrayDeque<int[]> q; 
    static int[][] dist = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[] changeDir = {0, 1, 2, 1};
    static boolean isPossible(int y, int x){
        if(y >= 0 && y < N && x >= 0 && x < N) return true;
        return false;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<T+1; tc++){
            int answer = -1;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new char[N][N];
            visited = new boolean[N][N][K+1][4];
            for(int i=0; i<N; i++){
                String str = br.readLine();
                for(int j=0; j<N; j++){
                    char c = str.charAt(j);
                    map[i][j] = c;
                    if(c == 'X'){
                        posX = j; posY = i;
                    }
                    else if(c == 'Y'){
                        tarX = j; tarY = i;
                    }
                }
            }
            // dir: 0 -> 상, 1 -> 우, 2 -> 하, 3 -> 좌
            q = new ArrayDeque<>(); // q 내부 int[] : {y 좌표, x좌표, 남은 K, 방향 dir, cnt}
            visited[posY][posX][K][0] = true;
            q.add(new int[]{posY, posX, K, 0, 0});
            while (!q.isEmpty()) {
                int[] cur = q.pop();
                int y = cur[0], x = cur[1], k = cur[2], dir = cur[3], cnt = cur[4];

                // 도착 확인
                if (y == tarY && x == tarX) {
                    answer = cnt;
                    break;
                }

                // 1) 회전 (우)
                int nd = (dir + 1) & 3;
                if (!visited[y][x][k][nd]) {
                    visited[y][x][k][nd] = true;
                    q.add(new int[]{y, x, k, nd, cnt + 1});
                }

                // 2) 회전 (좌)
                nd = (dir + 3) & 3;
                if (!visited[y][x][k][nd]) {
                    visited[y][x][k][nd] = true;
                    q.add(new int[]{y, x, k, nd, cnt + 1});
                }

                // 3) 전진
                int ny = y + dist[dir][0];
                int nx = x + dist[dir][1];
                if (isPossible(ny, nx)) {
                    char nc = map[ny][nx];
                    // 통과 가능: G, X, Y
                    if (nc == 'G' || nc == 'X' || nc == 'Y') {
                        if (!visited[ny][nx][k][dir]) {
                            visited[ny][nx][k][dir] = true;
                            q.add(new int[]{ny, nx, k, dir, cnt + 1});
                        }
                    }
                    // 통과 가능: T (베기 k>0 필요)
                    else if (nc == 'T' && k > 0) {
                        if (!visited[ny][nx][k - 1][dir]) {
                            visited[ny][nx][k - 1][dir] = true;
                            q.add(new int[]{ny, nx, k - 1, dir, cnt + 1});
                        }
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        bw.write(sb.toString()); bw.flush(); bw.close();
    }
}