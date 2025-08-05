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
        int minimum = Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            int tmp = Integer.parseInt(st.nextToken());
            if(minimum > tmp){
                minimum = tmp;
            }
            if(maximum < tmp){
                maximum = tmp;
            }
        }
        System.out.printf("%d %d", minimum, maximum);
    }
}