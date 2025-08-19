import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
        	nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        int sum = 0;
        for(int i=0; i<N; i++) {
        	sum += nums[i] * (N-i);
        }
        System.out.println(sum);
    }
}
