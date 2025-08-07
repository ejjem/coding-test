import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] arr = new long[N];
        long[] arr2 = new long[M];
        arr[0] = Integer.parseInt(st.nextToken());
        for(int idx=1; idx<N; idx++){
            arr[idx] = arr[idx-1] + Integer.parseInt(st.nextToken());
        }
        int tmp = 0;
        long answer = 0;
        for(int idx=0; idx<N; idx++){
            tmp = (int) (arr[idx] % M );
            if(tmp == 0) answer += 1;
            arr2[tmp] ++;
        }
        
        for(int idx=0; idx<M; idx++){
            if(arr2[idx] > 1){
                answer += ( arr2[idx] * (arr2[idx] - 1) / 2 );
            }
        }
        System.out.println(answer);
    }
}
