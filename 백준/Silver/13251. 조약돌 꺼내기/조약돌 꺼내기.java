import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        if(M == 1){
            System.out.println(1.0);
            return;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] colors = new int[M];
        int N = 0;
        double answer = 0;
        for(int i=0; i<M; i++){
            colors[i] = Integer.parseInt(st.nextToken());
            N += colors[i];
        }
        int K = Integer.parseInt(br.readLine());
        if(K == 1){
            System.out.println(1.0);
            return;
        }
        for(int i=0; i<M; i++){
            int n = colors[i];
            double tmp = 1;
            int cnt = 0;
            for(int j=0;; j++){
                if(cnt == K) break;
                //System.out.println( (n-j) + " / " + (N-j));
                tmp = tmp * (n-j) / (N-j) ; 
                cnt++;
            }
            answer += tmp;
        }
        System.out.println(answer);
    }
}