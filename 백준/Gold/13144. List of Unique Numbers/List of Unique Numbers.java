import java.io.*;
import java.util.*;

class Main {
    static int[] nums;
    static int N;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int[] cnt = new int[100000 + 1];
        int end = 0; long answer = 0;
        for(int start=0;start<N;start++){
            while(end < N && cnt[nums[end]] == 0){
                cnt[nums[end]]++;
                end++;
            } 
            answer += end - start;
            cnt[nums[start]]--;
        }
        System.out.println(answer);
    }
}