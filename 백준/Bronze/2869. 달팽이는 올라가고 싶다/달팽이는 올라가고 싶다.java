import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long V = Long.parseLong(st.nextToken());
        long cnt = 1;
        if(V <= A){
            System.out.println(cnt);
            return;
        }
        else{
            V -= A;
            long day = V / (A - B);
            if(day == 0){
                cnt++;
                System.out.println(cnt);
                return;    
            }
            else{
                cnt += day;
                if( (V % (A - B)) == 0){
                    System.out.println(cnt);
                    return;    
                }else{
                    cnt++;
                    System.out.println(cnt);
                    return; 
                }
            }
        }
    }
}