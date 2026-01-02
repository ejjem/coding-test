import java.io.IOException;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        Deque queue = new ArrayDeque<Integer>();
        for(int i=0; i<tc; i++){
            st = new StringTokenizer(br.readLine());
            String inst = st.nextToken();
            switch(inst){
                case "push":
                    int n = Integer.parseInt(st.nextToken());
                    queue.offerLast(n);
                break;
                case "pop":
                    if(queue.isEmpty()) System.out.println(-1);
                    else System.out.println(queue.pollFirst());
                break;

                case "size":
                    System.out.println(queue.size());
                break;

                case "empty":
                    if(queue.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                break;

                case "front":
                    if(queue.isEmpty()) System.out.println(-1);
                    else System.out.println(queue.peekFirst());
                break;

                case "back":
                    if(queue.isEmpty()) System.out.println(-1);
                    else System.out.println(queue.peekLast());
                break;
            }
        }
    }
}