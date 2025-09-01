import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] board;
    static int cnt0, cnt1;
    static void search(int y, int x, int size, int value){
        if(size == 1){
            if(value == 1) {cnt1 ++;}
            else{cnt0 ++;}
            return;
        }
        boolean flag = true;
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(board[y+i][x+j] != value) {flag = false; break;}
            }
            if(!flag) break;
        }
        if(!flag){
            search(y, x, size/2, board[y][x]);
            search(y, x+size/2, size/2, board[y][x+size/2]);
            search(y+size/2, x, size/2, board[y+size/2][x]);
            search(y+size/2, x+size/2, size/2, board[y+size/2][x+size/2]);
        }
        else{
            if(value == 1) {cnt1 ++;}
            else{cnt0 ++;}
            return;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cnt0 = 0; cnt1 = 0;
        if(board[0][0] == 0){search(0, 0, N, 0);}
        else{search(0, 0, N, 1);}
        
        System.out.println(cnt0);
        System.out.println(cnt1);
    }
}

