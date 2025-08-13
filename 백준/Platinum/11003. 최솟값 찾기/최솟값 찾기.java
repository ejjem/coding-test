import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb;
    static int N, L;
    
    public static void main(String[] args) throws Exception{
    	br = new BufferedReader(new InputStreamReader(System.in));
    	st = new StringTokenizer(br.readLine());
    	sb = new StringBuilder();
    	N = Integer.parseInt(st.nextToken());
    	L = Integer.parseInt(st.nextToken());
    	ArrayDeque<int[]> window = new ArrayDeque<>();
    	int size = 1;
    	st = new StringTokenizer(br.readLine());
    	
    	// {index, value}
    	window.offerLast(new int[] {0, Integer.parseInt(st.nextToken())});
    	sb.append(window.peekFirst()[1]).append(" ");
    	for(int i=1; i<N; i++) {
    		int tmp = Integer.parseInt(st.nextToken());
    		
    		// window에 삽입
    		// 1. 최솟값 정렬
    		while(true) {
    			if(!window.isEmpty() && window.peekLast()[1] >= tmp) {
    				window.pollLast();
    				size --;
    			}else {
    				window.offerLast(new int[] {i, tmp});
    				size ++;
    				break;
    			}
    		}
    		// 2. 사이즈 확인
    		while(size > L || (i - window.peekFirst()[0]) >= L) {
    			window.pollFirst();
    			size --;
    		}
    		/*
    		System.out.println("--------");
    		System.out.println(i + "번째");
    		for (int[] e : window) {
    		    System.out.println(Arrays.toString(e));
    		}
    		*/
    		
    		// 최솟값 출력
        	sb.append(window.peekFirst()[1]).append(" ");
    	}
    	bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	bw.write(sb.toString());
    	bw.flush();
    	bw.close();
    }
}