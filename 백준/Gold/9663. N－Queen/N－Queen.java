import java.io.*;
import java.util.*;


class Main {
    static int N;
    static int answer;
    static boolean isPossible(int[] board, int depth){
        for(int i=0; i<depth; i++){
                if( (depth - i) == Math.abs(board[i] - board[depth]) || board[i] == board[depth]) return false;
        }
        return true;
    }
    static void DFS(int depth, int[] board){
        if(depth == N){ answer ++; return; }
        for(int i=0; i<N; i++){
            board[depth] = i;
            if(isPossible(board, depth)){
                DFS(depth+1, board);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        N = Integer.parseInt(br.readLine());
        int[] board = new int[N];
        answer = 0;
        DFS(0, board);
        System.out.println(answer);

    }
}