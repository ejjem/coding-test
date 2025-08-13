import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static BufferedReader br;
    
    public static void main(String[] args) throws Exception{
    	br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	ArrayDeque<Integer> deque = new ArrayDeque<>();
    	for(int i=1; i<N+1; i++) {
    		deque.offerLast(i);
    	}
    	while(!(deque.size() == 1)) {
    		deque.pollFirst();
    		int tmp = deque.pollFirst();
    		deque.offerLast(tmp);
    	}
    	System.out.println(deque.pollLast());
    }
}
