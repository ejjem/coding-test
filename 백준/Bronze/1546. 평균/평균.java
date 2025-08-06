import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int maximum = Integer.MIN_VALUE;
        double total = 0;
        for(int i=0; i<N; i++){
            int tmp = Integer.parseInt(st.nextToken());
            total += (double)tmp;
            if(maximum < tmp){
                maximum = tmp;
            }
        }
        System.out.println( (total/maximum * 100)/N);
    }
}