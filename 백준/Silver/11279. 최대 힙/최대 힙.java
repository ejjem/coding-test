import java.io.IOException;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        // PriorityQueue<Integer> pq = new PriorityQueue<>(
        //     new Comparator<Integer>(){
        //         @Override
        //         public int compare(Integer a, Integer b){
        //             return Integer.compare(b, a);
        //         }
        //     }
        // );
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            int n = Integer.parseInt(br.readLine());
            if(n == 0){ // 삭제
                if(pq.isEmpty()){
                    sb.append(0).append("\n");
                }
                else{
                    sb.append(pq.poll()).append("\n");
                }
            }
            else{ // 추가
                pq.offer(n);
            }
        }
        bw.append(sb);
        bw.flush(); bw.close();
    }
}