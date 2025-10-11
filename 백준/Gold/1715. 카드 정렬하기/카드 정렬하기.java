import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }
        int answer = 0;
        while(pq.size() != 1){
            int cur = 0;
            cur += pq.poll();
            cur += pq.poll();
            answer += cur;
            pq.offer(cur);
            //System.out.println(answer);
            ///System.out.println(pq.size());
        }
        System.out.println(answer);
    }
}