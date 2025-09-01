import java.util.*;
import java.io.*;

public class Solution {
    static int[][] board;
    static boolean[][] visited;
    static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static HashSet<String> answer;
    static void DFS(int y, int x, int depth, int[] tmp){
        if(depth == 7){
            StringBuilder tmpSB = new StringBuilder();
            for(int i=0;i<=6;i++){
                tmpSB.append(tmp[i]);
            }
            String str = tmpSB.toString();
            //if(!answer.contains(str)) System.out.println(str);
            answer.add(str);
            return;
        }
        if(depth == 0){
            tmp[depth] = board[y][x];
            depth++;
        }
        for(int i=0; i<4; i++){
            int ny = y + dist[i][0]; int nx = x + dist[i][1];
            if(ny >= 0 && ny < 4 && nx >= 0 && nx < 4){
                tmp[depth] = board[ny][nx];
                DFS(ny, nx, depth+1, tmp);
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<T+1;tc++){
            board = new int[4][4];
            for(int i=0;i<4;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<4;j++){
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            answer = new HashSet<>();
            for(int i=0;i<4;i++){
                for(int j=0;j<4;j++){
                    int[] tmp = new int[7];
                    DFS(i, j, 0, tmp);
                }
            }
            sb.append("#").append(tc).append(" ").append(answer.size()).append("\n");

        }
        bw.write(sb.toString()); bw.flush(); bw.close();
    }
}
