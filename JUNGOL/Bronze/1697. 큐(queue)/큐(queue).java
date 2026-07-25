import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char command = st.nextToken().charAt(0);
            if(command == 'i'){ // 삽입
                int n = Integer.parseInt(st.nextToken());
                queue.offerLast(n);
            }
            else if(command == 'o'){ // 삭제 및 출력
                if(queue.isEmpty()){
                    System.out.println("empty");
                }
                else{
                    System.out.println(queue.pollFirst());
                }
            }
            else if(command == 'c'){ // 사이즈 출력
                System.out.println(queue.size());
            }
        }
    }
}