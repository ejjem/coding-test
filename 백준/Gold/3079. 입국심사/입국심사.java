import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[] time;
    static boolean ok(long mid){
        long cnt = 0;
        for(int t : time){
            cnt += mid / t;
            if(cnt >= M) return true;
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        time = new int[N];
        int max = 0;
        for(int i=0;i<N;i++){
            time[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, time[i]);
        }
        long start = 0; long end = (long)max * M;
        long answer = 0;
        while(start <= end){
            long mid = start + (end - start) / 2;
            if(ok(mid)){ // 줄여보자
                answer = mid;
                end = mid - 1;
            }
            else{ // 더 키우자
                start = mid + 1;
            }
        }
        System.out.println(answer);
    }
}