import java.util.*;
import java.io.*;

class Main {
	static int N, M;
	static int[] lectures;
	
	static boolean check(int middle){
		int cnt = 1;
		int tmp = 0;
		
		for(int i=0; i<N; i++) {
			if(lectures[i] > middle) return false;
			if(tmp + lectures[i] <= middle) {
				tmp += lectures[i];
			}
			else {
				if(cnt == M) return false;
				cnt ++;
				tmp = lectures[i];		
			}
		}
		return true;
	}
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st= new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	lectures = new int[N];
    	st = new StringTokenizer(br.readLine());
    	int end = 0;
    	for(int i=0; i<N; i++) {
    		lectures[i] = Integer.parseInt(st.nextToken());
    		end += lectures[i];
    	}
    	int start = 0; 
    	int answer = 0;
    	while(start <= end) {
    		int middle = start + (end - start)/2;
    		if(check(middle)) {
    			answer = middle;
    			end = middle - 1;
    		}
    		else {
    			start = middle + 1;
    		}
    		//System.out.println(middle);
    	}
    	System.out.println(answer);
    }
}