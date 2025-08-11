import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static StringTokenizer st;
    
    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String DNA = br.readLine();
        st = new StringTokenizer(br.readLine());
        int[] minimum = new int[4];
        
        //A, C, G, T
        for(int i=0; i< 4; i++){
            minimum[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] now = new int[4];
        for(int i=0; i<P; i++){
            char ch = DNA.charAt(i);
            switch(ch){
            case 'A': now[0] ++;
                        break;
            case 'C': now[1] ++;
                        break;
            case 'G': now[2] ++;
                        break;
            case 'T': now[3] ++;
                        break;
            }
        }
        
        int start = 0;
        int end = P;
        int cnt = 0;
        
        while(true){
            cnt ++;
            for(int i=0; i<4; i++){
                if(minimum[i] > now[i]){
                    cnt --;
                    break;
                }
            }

            if(end == S) break;
            
            // 빼기
            char ch1 = DNA.charAt(start);
            switch(ch1){
            case 'A': now[0] --;
                    break;
            case 'C': now[1] --;
                    break;
            case 'G': now[2] --;
                    break;
            case 'T': now[3] --;
                    break;
            }
            
            //넣기
            char ch2 = DNA.charAt(end);
            switch(ch2){
            case 'A': now[0] ++;
                    break;
            case 'C': now[1] ++;
                    break;
            case 'G': now[2] ++;
                    break;
            case 'T': now[3] ++;
                    break;
            }
            start ++;
            end ++;
        }
        System.out.println(cnt);
    }
}