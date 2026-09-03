import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] choo = {1, 2, 4, 8, 16}; // 1, 2, 4, 8, 16
        int[] chooCnt = new int[5];
        for(int i=0; i<=4; i++){
            chooCnt[i] = Integer.parseInt(st.nextToken());
        }
        int N = Integer.parseInt(st.nextToken());

        for(int i=4; i>=0; i--){
            int curChoo = choo[i];
            while(chooCnt[i] > 0 && N >= curChoo){
                N -= curChoo;
                chooCnt[i] -= 1;
                answer ++;
            }
        }
        if(N == 0){
            System.out.println(answer);
        }
        else{
            System.out.println("impossible");
        }
    }
}