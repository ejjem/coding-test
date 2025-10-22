import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        long con = 1000000007;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int size = 1;
        while(size < N) {size = size * 2;}
        long[] tree = new long[size*2];
        Arrays.fill(tree, 1);
        for(int i=0; i<N; i++){
            tree[size+i] = Long.parseLong(br.readLine());
        }
        for(int i=size-1; i>=1; i--){
            tree[i] = tree[2*i] * tree[2*i+1] % con;
        }
        //System.out.println(Arrays.toString(tree));
        for(int i=0; i<M+K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            switch(a){
                case 1:
                    int idx = size + b - 1;
                    tree[idx] = c;
                    idx = idx / 2;
                    while(idx >= 1){
                        tree[idx] = tree[2*idx] * tree[2*idx+1] % con;
                        idx = idx / 2;
                    }
                    break;
                case 2:
                    long ans = 1;
                    int start_index = b + size - 1;
                    int end_index = (int) c + size - 1;
                    while(start_index <= end_index){
                        if(start_index % 2 == 1) ans = ans * tree[start_index] % con;
                        if(end_index % 2 == 0) ans = ans * tree[end_index] % con;
                        start_index = (start_index + 1) / 2;
                        end_index = (end_index - 1) / 2;
                    }
                    sb.append(ans).append("\n");
                    break;
            }
        }
        bw.write(sb.toString()); bw.flush(); bw.close();
    }
}