import java.io.IOException;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N == 0) System.out.println(0);
        else{
            double total = 0;
            int n = (int) Math.round( ( (double) N / 100) * 15 );
            int[] levels = new int[N];
            for(int i=0; i<N; i++){
                levels[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(levels);
            int start = n;
            int end = N - n - 1;
            for(int i=start; i<=end; i++){
                total += levels[i];
            }
            System.out.println(Math.round( total / (end - start + 1)));
        }
    }
}