import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] nums;
    static void QuickSort(int start, int end, int K) {
    	if(start < end) {
    		int pivot = partition(start, end);
    		if(pivot == K) return;
    		else if(K < pivot) QuickSort(start, pivot - 1, K);
    		else QuickSort(pivot+1, end, K);
    		}
    }
    
    static int partition(int start, int end) {
    	if(start + 1 == end) {
    		if(nums[start] > nums[end]) Swap(start, end);
    		return end;
    	}
    	int middle = (start + end) / 2;
    	Swap(start, middle);
    	int pivot = nums[start];
    	int i = start + 1, j = end;
    	while(i<=j) {
    		while(j >= start + 1 && pivot < nums[j]) j--;
    		while(i <= end && pivot > nums[i]) i++;
    		if(i<=j) Swap(i++, j--);
    	}
    	nums[start] = nums[j];
    	nums[j] = pivot;
    	return j;
    }
    
    static void Swap(int a, int b) {
    	int tmp = nums[a]; nums[a] = nums[b]; nums[b] = tmp;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); int K = Integer.parseInt(st.nextToken());
        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) nums[i] = Integer.parseInt(st.nextToken());
        
        QuickSort(0, N-1, K-1);
        System.out.println(nums[K-1]);
       
    }
}