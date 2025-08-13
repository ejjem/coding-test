import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringBuilder sb;
    
    public static void main(String[] args) throws Exception{
    	br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	sb = new StringBuilder();
    	ArrayDeque<Integer> deque = new ArrayDeque<>();
    	deque.offerLast(1);
    	sb.append("+").append("\n");
    	int top = 1;
    	int num = 2;
    	for(int i=0; i<N; i++) {
    		int tmp = Integer.parseInt(br.readLine());
    		if (tmp > top) {
    			while( !(tmp == top) ) {
    				deque.offerLast(num++);
    				top = deque.peekLast();
    				sb.append("+").append("\n");
    			}
    			deque.pollLast();
    			if(!deque.isEmpty()) top = deque.peekLast();
    			else top = -1;
				sb.append("-").append("\n");
    		}
    		else if(tmp == top) {
    			deque.pollLast();
    			if(!deque.isEmpty()) top = deque.peekLast();
    			else top = -1;
    			sb.append("-").append("\n");
    		}
    		else {
    			System.out.println("NO");
    			return;
    		}
    	}
    	bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	bw.write(sb.toString());
    	bw.flush();
    	bw.close();
    }
}