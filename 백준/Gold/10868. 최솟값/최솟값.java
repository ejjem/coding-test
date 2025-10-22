import java.io.*;
import java.util.*;

class Main {
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int size = 1;
        while(size < N) {size = size * 2;}
        tree = new long[size * 2];        
        Arrays.fill(tree, 1000000001);
        // 트리에 초기값 대입
        for(int i=0; i<N; i++){
            tree[size+i] = Long.parseLong(br.readLine());
        }
        // 트리 초기화
        for(int i=size-1; i>=1; i--){
            tree[i] = Math.min(tree[i*2], tree[i*2+1]);
        }
        //System.out.println(Arrays.toString(tree));
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            long ans = Long.MAX_VALUE;
            int a = Integer.parseInt(st.nextToken()) + size - 1;
            int b = Integer.parseInt(st.nextToken()) + size - 1;
            while(a <= b){
                if(a % 2 == 1) ans = Math.min(ans, tree[a]);
                if(b % 2 == 0) ans = Math.min(ans, tree[b]);
                a = (a + 1) / 2;
                b = (b - 1) / 2;
            }
            sb.append(ans).append("\n");
        }
        bw.write(sb.toString()); bw.flush(); bw.close();
    }
}