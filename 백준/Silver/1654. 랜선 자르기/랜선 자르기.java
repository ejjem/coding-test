import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long[] lines = new long[K];
        long max = 0;
        for(int i=0;i<K;i++){
            lines[i] = Long.parseLong(br.readLine());
            max = Math.max(max, lines[i]);
        }
        long start = 1; long end = max;
        long answer = 0;
        while(start <= end){
            long cnt = 0;
            long mid = start + (end - start)/2;
            for(long n : lines){
                    cnt += (n / mid);
                }
                if(cnt >= N){ //더 길게 잘라보자
                    answer = mid;
                    start = mid + 1;
                }
                else{ //더 짧게 잘라보자
                    end = mid - 1;
                }
        }
        System.out.println(answer);
    }
}