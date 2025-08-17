import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br;
    
    static class Node implements Comparable<Node>{
        int index;
        int value;

        Node(int index, int value){
            this.index = index;
            this.value = value;
        }
        public int compareTo(Node o) {
            return this.value - o.value; // 오름차순
        }

    }
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] list = new Node[N];
        for(int i=0; i<N; i++){
            list[i] = new Node(i, Integer.parseInt(br.readLine()));
        }
        Arrays.sort(list);
        int maximum = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            int tmp = list[i].index - i;
            if(maximum < tmp){
                maximum = tmp;
            }
        }
        System.out.println(maximum + 1);
    }
}