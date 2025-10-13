import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[][] tree;
    static void preOrder(int now){
        if(now == -1){
            return;
        }
        System.out.print((char)(now+'A'));
        preOrder(tree[now][0]);
        preOrder(tree[now][1]);
    }
    static void inOrder(int now){
        if(now == -1){
            return;
        }
        inOrder(tree[now][0]);
        System.out.print((char)(now+'A'));
        inOrder(tree[now][1]);
    }
    static void postOrder(int now){
        if(now == -1){
            return;
        }
        postOrder(tree[now][0]);
        postOrder(tree[now][1]);
        System.out.print((char)(now+'A'));
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        tree = new int[N][2];
        for(int i=0; i<N; i++){
            Arrays.fill(tree[i], -1);
        }
        // A -> 0 이니까 
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int parent = st.nextToken().charAt(0) - 'A';
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            if(left != '.') tree[parent][0] = left - 'A';
            if(right != '.') tree[parent][1] = right - 'A';
        }
        /*
        for(int i=0; i<N; i++){
            System.out.println(Arrays.toString(tree[i]));
        }
        */
        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
    }
}