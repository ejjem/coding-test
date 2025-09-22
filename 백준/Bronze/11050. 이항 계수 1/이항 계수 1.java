import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] factorial = new long[11];
        factorial[0] = 1;
        for(int i=1; i<11; i++){
            factorial[i] = factorial[i-1]*i;
        }
        //System.out.println(Arrays.toString(factorial));
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        //nCk = n! / (k! * (n-k)!)
        long answer = factorial[N] / (factorial[K] * factorial[N-K]);
        System.out.println(answer);
    }
}