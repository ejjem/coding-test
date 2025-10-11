import java.io.IOException;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long total = 0; int negM = 0; int negA = 0; int posM = 0; int posA = 0;
        PriorityQueue<Integer> neg = new PriorityQueue<>();
        PriorityQueue<Integer> pos = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b){
                return Integer.compare(b, a);
            }
        });
        for(int i=0; i<N; i++){
            int tmp = Integer.parseInt(br.readLine());
            total += tmp;
            if(tmp == 1) continue;
            else if(tmp <= 0) neg.offer(tmp);
            else pos.offer(tmp);
        }
        while(neg.size() >= 2){
            //System.out.println("음수 묶기");
            int cur = neg.poll();
            int cur2 = neg.poll();
            //System.out.println(cur);
            //System.out.println(cur2);
            total = total + cur*cur2 - (cur+cur2);
        }
        while(pos.size()>= 2){
            //System.out.println("양수 묶기");
            int cur = pos.poll();
            int cur2 = pos.poll();
            //System.out.println(cur);
            //System.out.println(cur2);
            posM = cur * cur2;
            posA = cur + cur2;
            total = total + cur*cur2 - (cur+cur2);
        }
        System.out.println(total);
    }
}