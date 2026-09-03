import java.io.*;
import java.util.*;

class Main{
    static int white;
    static int blue;
    static int[][] map;
    public static void search(int x, int y, int len){
        boolean square = true;
        int color = map[y][x];
        for(int i=y; i<y+len; i++){
            for(int j=x; j<x+len; j++){
                if(map[i][j] != color){
                    square = false;
                    break;
                }
            }
            if(!square) break;
        }
        if(square){
            if(color == 0) white++;
            else blue++;
        }
        else{
            int nextLen = len / 2;
            search(x, y, nextLen);
            search(x+nextLen, y, nextLen);
            search(x, y+nextLen, nextLen);
            search(x+nextLen, y+nextLen, nextLen);
        }
    }

    public static void main(String[] args) throws IOException{
        white = 0;
        blue = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        search(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }
}