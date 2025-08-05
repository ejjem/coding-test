import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int H = 0; int W = 0; int N = 0; int a = 0; int b = 0;
        for(int i=0;i<T;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            if (N%H == 0){
                a = H;
                b = N/H;
            }  
            else{
                a = N % H;
                b = (N / H + 1);
            }
            if(b <= 9)  System.out.println(Integer.toString(a) + "0" + Integer.toString(b));
            else System.out.println(Integer.toString(a) + Integer.toString(b));   
        }
    }
}