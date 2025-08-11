import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int[] nums;
    static int cnt, N;
    static void two_pointer(int index){
        int target = nums[index];
        int start = 0;
        int end = N - 1;
        while(start < end){
            if(start == index) start++;
            else if(end == index) end --;
            else {
                int tmp = nums[start] + nums[end];
                if(tmp == target){
                    cnt ++;
                    return;
                }
                else if(tmp < target){
                    start ++;
                }
                else if(tmp > target){
                    end --;
                }
            }
        }
    }

    
    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        cnt = 0;
        for(int i=0; i<N; i++){
            two_pointer(i);
        }
        System.out.println(cnt);
    }
}