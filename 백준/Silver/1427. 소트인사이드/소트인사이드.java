import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        String number = br.readLine();
        Integer[] nums = new Integer[number.length()];
        for(int i=0; i<number.length(); i++){
            nums[i] = number.charAt(i) - '0';
        }
        Arrays.sort(nums, Collections.reverseOrder());
        for(int i=0; i<nums.length; i++) {
        	sb.append(nums[i]);
        }
        System.out.println(sb);
    }
}
