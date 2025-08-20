import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringBuilder sb;
    static StringTokenizer st;
    static int a, b, c;
    public static void main(String[] args) throws Exception{
    	br = new BufferedReader(new InputStreamReader(System.in));
    	while(true) {
    		st = new StringTokenizer(br.readLine());
        	a = Integer.parseInt(st.nextToken());
        	b = Integer.parseInt(st.nextToken());
        	c = Integer.parseInt(st.nextToken());
        	if(a == 0 && b == 0 && c == 0) {
        		return;
        	}
        	int min1 = 0; int min2 = 0;
        	int max = Math.max(a, b);
        	max = Math.max(max, c);
        	if(max == a) {
        		min1 = b; min2 = c;
        	}
        	else if(max == b) {
        		min1 = c; min2 = a;
        	}
        	else if(max == c) {
        		min1 = a; min2 = b;
        	}
        	
        	if(max * max == (min1 * min1) + (min2 * min2)) {
        		System.out.println("right");
        	} else {
        		System.out.println("wrong");
        	}
    	}
    }
}
