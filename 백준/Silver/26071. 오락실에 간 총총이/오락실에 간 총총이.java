import java.io.IOException;
import java.io.*;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int row_min = Integer.MAX_VALUE;
        int row_max = Integer.MIN_VALUE;
        int col_min = Integer.MAX_VALUE;
        int col_max = Integer.MIN_VALUE;
        int cnt = 0;
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                char c = str.charAt(j);
                if(c == 'G'){
                    if(j > row_max) row_max = j;
                    if(j < row_min) row_min = j;
                    if(i > col_max) col_max = i;
                    if(i < col_min) col_min = i;
                }
            }
        }

        if(row_min != row_max) cnt += Math.min(row_max, (N-1) - row_min);
        if(col_min != col_max)cnt += Math.min(col_max, (N-1) - col_min);
        
        System.out.println(cnt);
    }
}