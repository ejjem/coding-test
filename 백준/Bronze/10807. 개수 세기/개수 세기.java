import java.io.*;
import java.util.*;

public class Main {
    
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] cnt = new int[201];
        // - 100 ~ 100 -> + 100 -> 0 ~ 200
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
        	cnt[Integer.parseInt(st.nextToken()) + 100] += 1;
        }
        int n = Integer.parseInt(br.readLine()) + 100;
        System.out.println(cnt[n]);
        
    }
}