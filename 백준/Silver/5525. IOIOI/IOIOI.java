import java.io.IOException;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();
        int i = 0;
        int count = 0;
        int answer = 0;
        while(i < M){
            count = 0;
            if(S.charAt(i) == 'I' && i+2 < M){
                while(i+2 < M){
                    if(S.charAt(i+1) == 'O' && S.charAt(i+2) == 'I'){
                        i += 2;
                        count ++;
                        if(count >= N) answer ++;
                    }
                    else{
                        break;
                    }
                }
            }
            if(count == 0) i++;
        }
        System.out.println(answer);
    }
}