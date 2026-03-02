import java.io.IOException;
import java.io.*;
import java.util.*;

class Main {
    static int[][] dist = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] start = new int[2];
        int count = 0;
        char[][] map = new char[N][M];
        for(int i=0; i<N; i++){
            String input = br.readLine();
            for(int j=0; j<M; j++){
                char c = input.charAt(j);
                if(c == 'I') {start[0] = i; start[1] = j; map[i][j] = '.';}
                else {map[i][j] = c;}
            }
        }
        Deque<int[]> q = new ArrayDeque<>();
        q.offerLast(start);
        while(!q.isEmpty()){
            int[] cur = q.pollFirst();
            int y = cur[0]; int x = cur[1];
            for(int i=0; i<4; i++){
                int dy = dist[i][0] + y; 
                int dx = dist[i][1] + x;
                if(dy >= 0 && dy < N && dx >= 0 && dx < M){
                    if(map[dy][dx] == '.' || map[dy][dx] == 'X') continue;
                    else{
                        if(map[dy][dx] == 'P') {count ++;}
                        map[dy][dx] = '.';
                        q.offerLast(new int[]{dy, dx});
                    }
                }
            }
        }
        if(count == 0){
            System.out.println("TT");
        }
        else{
            System.out.println(count);
        }
    }
}