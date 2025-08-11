import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        //System.out.println(Arrays.toString(nums));
        int start = 0;
        int end = N-1;
        int cnt = 0;
        while(start < end){
            int tmp = nums[start] + nums[end];
            if(tmp == M){
                cnt ++;
                start ++;
                end --;
            }
            else if(tmp < M){
                start ++;
            }
            else if(tmp > M){
                end --;
            }
        }
        System.out.println(cnt);
    }
}