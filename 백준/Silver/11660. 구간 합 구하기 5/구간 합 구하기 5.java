import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        StringBuilder answer = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] sum_board = new int[N][N];
        
        st = new StringTokenizer(br.readLine());
        sum_board[0][0] = Integer.parseInt(st.nextToken());
        for(int i=1; i<N; i++){
            sum_board[0][i] = sum_board[0][i-1] + Integer.parseInt(st.nextToken()); 
        }
        
        for(int i=1; i<N; i++){
            st = new StringTokenizer(br.readLine());
            sum_board[i][0] = sum_board[i-1][0] + Integer.parseInt(st.nextToken());
            for(int j=1; j<N; j++){
                sum_board[i][j] = sum_board[i-1][j] + sum_board[i][j-1] - sum_board[i-1][j-1] + Integer.parseInt(st.nextToken());
            }
        }

        for(int tc=0; tc<M; tc++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;
            
            if(x1 == 0 && y1 == 0){
                answer.append(sum_board[x2][y2]);   
            }
            else if(x1 == 0){
                answer.append(sum_board[x2][y2] - sum_board[x2][y1-1]);
            }
            else if(y1 == 0){
                answer.append(sum_board[x2][y2] - sum_board[x1-1][y2]);
            }
            else{
                answer.append(sum_board[x2][y2] - sum_board[x2][y1-1] - sum_board[x1-1][y2] + sum_board[x1-1][y1-1]);
            }
            answer.append("\n");
        }
        System.out.println(answer);
    }
}