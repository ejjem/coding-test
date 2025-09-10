import java.io.*;
import java.util.*;

public class Main {    
	static boolean[][] visited;
	static boolean[] liter;
	static ArrayDeque<int[]> stack;
	static int[] move(int x, int y, int Y) {
		int[] result = new int[2];
		result[0] = 0; result[1] = x + y;
		if(x + y > Y) {
			result[0] = x + y - Y;
			result[1] = Y;
		}
		return result;
	}
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	int A = Integer.parseInt(st.nextToken());
    	int B = Integer.parseInt(st.nextToken());
    	int C = Integer.parseInt(st.nextToken());
    	visited = new boolean[A+1][B+1];
    	visited[0][0] = true;
    	liter = new boolean[C+1];
    	liter[C] = true;
    	stack = new ArrayDeque<>();
    	stack.offerLast(new int[] {0, 0, C});
    	while(!stack.isEmpty()) {
    		int[] cur = stack.pollLast();
    		int[] tmp = new int[1];
    		int a = cur[0]; int b = cur[1]; int c = cur[2];
    		if(!liter[c] && a == 0) liter[c] = true;
    		if(a != 0) {
    			// A -> B
    			tmp = move(a, b, B);
        		if(!visited[tmp[0]][tmp[1]]) {
        			visited[tmp[0]][tmp[1]] = true;
        			stack.offerLast(new int[] {tmp[0], tmp[1], c});
        		}
        		// A -> C
        		tmp = move(a, c, C);
        		if(!visited[tmp[0]][b]) {
        			visited[tmp[0]][b] = true;
        			stack.offerLast(new int[] {tmp[0], b, tmp[1]});
        		}
    		}
    		if(b != 0) {
    			// B -> A
    			tmp = move(b, a, A);
        		if(!visited[tmp[1]][tmp[0]]) {
        			visited[tmp[1]][tmp[0]] = true;
        			stack.offerLast(new int[] {tmp[1], tmp[0], c});
        		}
    			// B -> C
        		tmp = move(b, c, C);
        		if(!visited[a][tmp[0]]) {
        			visited[a][tmp[0]] = true;
        			stack.offerLast(new int[] {a, tmp[0], tmp[1]});
        		}
    		}
    		if(c != 0) {
    			// C -> A
    			tmp = move(c, a, A);
        		if(!visited[tmp[1]][b]) {
        			visited[tmp[1]][b] = true;
        			stack.offerLast(new int[] {tmp[1], b, tmp[0]});
        		}
    			// C -> B
        		tmp = move(c, b, B);
        		if(!visited[a][tmp[1]]) {
        			visited[a][tmp[1]] = true;
        			stack.offerLast(new int[] {a, tmp[1], tmp[0]});
        		}
    		}
    	}
    	for(int i=0; i<C+1; i++) {
    		if(liter[i]) sb.append(i).append(" ");
    	}
    	bw.write(sb.toString()); bw.flush(); bw.close();
    }
}