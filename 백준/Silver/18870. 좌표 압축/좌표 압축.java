import java.io.IOException;
import java.io.*;
import java.util.*;

class Main {
    static class Node{
        int num;
        int index;
        Node(int num, int index){
            this.num = num;
            this.index = index;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        List<Node> nodes = new ArrayList<>();
        int[] answer = new int[N];
        for(int i=0; i<N; i++){
            nodes.add(new Node(Integer.parseInt(st.nextToken()), i));
        }
        Collections.sort(nodes, new Comparator<Node>(){
            @Override
            public int compare(Node a, Node b){
                return Integer.compare(a.num, b.num);
            }
        });
        Node first = nodes.get(0);
        answer[first.index] = 0;
        int tmp = first.num;
        int c = 0;
        for(int i=1; i<N; i++){
            Node cur = nodes.get(i);
            if(cur.num != tmp) {c++; tmp = cur.num;}
            answer[cur.index] = c;
        }
        for(int i=0; i<N; i++){
            sb.append(answer[i]);
            if(i != N-1) sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}