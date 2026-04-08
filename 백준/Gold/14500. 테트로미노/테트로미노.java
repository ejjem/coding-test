import java.io.*;
import java.util.*;

/* 
가장 왼쪽 위가 (i, j)라 할 때 테트로미노는 총 5가지:
    [(i, j), (i, j+1), (i, j+2), (i, j+3)]
    [(i, j), (i, j+1), (i+1, j), (i+1, j+1)]
    [(i, j), (i+1, j), (i+2, j), (j+2, j+1)]
    [(i, j), (i+1, j), (i+1, j+1), (i+2, j+1)]
    [(i, j), (i, j+1), (i, j+2), (i+1, j+1)]
이 중 딱 1개만 놓아서 최댓값 산출
N, M <= 500 -> 전체 순회 시 250,000
시간 제한 2초 -> 2억번 가능, 완탐 여러번 해도 상관 없어보임.
한 꼭지점에서 테트로미노 확인 -> 4방향으로 4번 진행. 1칸 당 16. (실제론 더 적음)
16 * 5 * 250,000 = 20,000,000. 걍 완탐 때려도 될듯?
1*4 기준으로
우측: [(i, j), (i, j+1), (i, j+2), (i, j+3)]
좌측: [(i, j), (i, j-1), (i, j-2), (i, j-3)]
하단: [(i, j), (i+1, j), (i+2, j), (i+3, j)]
상단: [(i, j), (i-1, j), (i-2, j), (i-3, j)]
=> [(0, 0), (0, 1), (0, 2), (0, 3)] 으로 두고 변환해서 사용
*/

class Main {
    static int N, M;
    static int[][] map;
    static int[][][] tatro = {
        {{0, 0}, {0, 1}, {0, 2}, {0, 3}},
        {{0, 0}, {0, 1}, {1, 0}, {1, 1}},
        {{0, 0}, {1, 0}, {2, 0}, {2, 1}},
        {{0, 0}, {1, 0}, {1, 1}, {2, 1}},
        {{0, 0}, {0, 1}, {0, 2}, {1, 1}},
        {{0, 0}, {1, 0}, {2, 0}, {2, -1}},
        {{0, 0}, {1, 0}, {1, -1}, {2, -1}}
    };
    static boolean isPossible(int y, int x){
        if(y >=0 && y < N && x >= 0 && x < M) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int tmp = 0;
        int answer = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                for(int k=0; k<7; k++){
                    int y = i; int x = j;
                    tmp = 0;

                    // 우측
                    for(int l=0; l<4; l++){
                        int dy = tatro[k][l][0];
                        int dx = tatro[k][l][1];
                        if(isPossible(y + dy, x + dx)){
                            tmp += map[y+dy][x+dx];
                        }
                        else{
                            tmp = 0;
                            break;
                        }
                    }
                    answer = Math.max(answer, tmp);                    
                    tmp = 0;

                    // 좌측
                    for(int l=0; l<4; l++){
                        int dy = -1 * tatro[k][l][0];
                        int dx = -1 * tatro[k][l][1];
                        if(isPossible(y + dy, x + dx)){
                            tmp += map[y+dy][x+dx];
                        }
                        else{
                            tmp = 0;
                            break;
                        }
                    }
                    answer = Math.max(answer, tmp);                    
                    tmp = 0;

                    // 상단
                    for(int l=0; l<4; l++){
                        int dx = -1 * tatro[k][l][0];
                        int dy = -1 * tatro[k][l][1];
                        if(isPossible(y + dy, x + dx)){
                            tmp += map[y+dy][x+dx];
                        }
                        else{
                            tmp = 0;
                            break;
                        }
                    }
                    answer = Math.max(answer, tmp);                    
                    tmp = 0;

                    // 하단
                    for(int l=0; l<4; l++){
                        int dx = tatro[k][l][0];
                        int dy = tatro[k][l][1];
                        if(isPossible(y + dy, x + dx)){
                            tmp += map[y+dy][x+dx];
                        }
                        else{
                            tmp = 0;
                            break;
                        }
                    }
                    answer = Math.max(answer, tmp);                    
                    tmp = 0;
                }
            }
        }
        System.out.println(answer);
    }
}