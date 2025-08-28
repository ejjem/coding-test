import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        boolean[] notPrimes = new boolean[1001];
        notPrimes[0] = true; notPrimes[1] = true;
        for(int i=2; i<=32; i++){
            if(!notPrimes[i]){
                int index = 2;
                while(i * index <= 1000){
                    notPrimes[i*index] = true;
                    index++;
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for(int i=0; i<N; i++){
            if(!notPrimes[Integer.parseInt(st.nextToken())]) cnt ++;
        }
        System.out.println(cnt);
    }
}