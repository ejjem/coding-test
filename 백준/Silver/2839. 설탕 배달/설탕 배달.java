import java.io.IOException;
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] possible = new int[N+1];
        Arrays.fill(possible, -1);
        possible[N] = 0;
        for(int i=N; i>=0; i--) {
            if(possible[i] != -1) {
                if(i-5 >= 0){
                    if(possible[i-5] == -1){
                    possible[i-5] = possible[i] + 1;
                    }
                    else{
                        possible[i-5] = Math.min(possible[i-5], possible[i] + 1);
                    }
                }
                if(i-3 >= 0){
                    if(possible[i-3] == -1){
                        possible[i-3] = possible[i] + 1;
                        }
                    else{
                        possible[i-3] = Math.min(possible[i-3], possible[i] + 1);
                    }
                }
            }
            //System.out.println(Arrays.toString(possible));
        }
        System.out.println(possible[0]);
    }
}