import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb;
    static void swap(int[] nums, int a, int b) {
    	int tmp = nums[a];
    	nums[a] = nums[b];
    	nums[b] = tmp;
    	return;
    }
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        String number = br.readLine();
        int[] nums = new int[number.length()];
        for(int i=0; i<number.length(); i++){
            nums[i] = number.charAt(i) - '0';
        }
        for(int i=0; i<nums.length - 1; i++) {
        	int max = nums[i];
        	int maxIndex = i;
        	for(int j=i+1; j<nums.length; j++) {
        		if(nums[j] > max) {
        			max = nums[j];
        			maxIndex = j;
        		}
        	}
        	swap(nums, i, maxIndex);
        	sb.append(nums[i]);
        }
        sb.append(nums[number.length()-1]);
        System.out.println(sb);
    }
}
