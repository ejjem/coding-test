import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        long[] tri = new long[100];
        tri[0] = 1; tri[1] = 1; tri[2] = 1;
        tri[3] = 2; tri[4] = 2;
        for(int i=5; i<100; i++){
            tri[i] = tri[i-1] + tri[i-5];
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc=0; tc<T; tc++){
            int N = Integer.parseInt(br.readLine());
            System.out.println(tri[N-1]);
        }
        
    }
}