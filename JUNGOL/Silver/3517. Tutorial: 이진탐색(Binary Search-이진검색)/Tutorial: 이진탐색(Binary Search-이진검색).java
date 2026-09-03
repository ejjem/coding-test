import java.io.*;
import java.util.*;

class Main{

    public static int binarySearch(int[] nums, int target, int high){
        int low = 0;
        while(low <= high){
            int mid = (low + high) / 2;
            if(target == nums[mid]) return mid;

            if(nums[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int Q = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<Q; i++){
            int target = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(nums, target, N));
            if(i != Q) sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}