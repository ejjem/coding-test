import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int cnt = 0;
    	for(int i=1; i<=N; i++) {
    		if(i%5 == 0) {
    			int target = i;
    			int n = 0;
    			while(target % 5 == 0) {
    				target /= 5;
    				n++;
    			}
    			cnt += n;
    		}
    	}
    	System.out.println(cnt);
    }
}