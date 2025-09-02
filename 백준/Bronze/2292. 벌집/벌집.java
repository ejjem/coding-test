import java.io.*;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	
    	if(N == 1) {System.out.println(1);}
    	else {
    		int start = 2;
    		int end = 7;
        	int cnt = 2;
    		while(true) {
        		if(start <= N && N <= end) {
        			System.out.println(cnt);
        			return;
        		}
        		else {
        			start += 6*(cnt-1);
        			end += 6*cnt;
        			cnt ++;
        		}
        	}
    	}
    	
    }
}

