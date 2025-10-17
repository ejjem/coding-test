import java.io.*;
import java.util.*;

class Main {
    static int N, M, K;
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int size = 1;
        while(size < N){ size <<= 1;}
        tree = new long[size * 2];
        // 리프 노드 시작 인덱스는 size
        for(int idx=0; idx<N; idx++){
            tree[size + idx] = Long.parseLong(br.readLine());
        }
        // 트리 초기화
        for(int idx=size-1; idx>0; idx--){
            tree[idx] = tree[idx*2] + tree[idx*2+1];
        }
        // 업데이트 or 질의 반영
        for(int idx=0; idx<M+K; idx++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            switch(a){
                case 1: // 업데이트: b번째 수를 c로 변경
                    tree[size + b - 1] = c;
                    for(int i=(size + b - 1)/2; i > 0; i = i/2){
                        tree[i] = tree[i*2] + tree[i*2+1];
                    }
                    break;
                case 2: // 질의: b부터 c까지의 구간 합 출력
                    int start_index = b + size - 1;
                    int end_index = (int)c + size - 1;
                    long total = 0;
                    while(start_index <= end_index){ // end_index < start_index일 때 종료
                        if(start_index % 2 == 1) total += tree[start_index];
                        if(end_index %2 == 0) total += tree[end_index];
                        start_index = (start_index + 1) / 2;
                        end_index = (end_index - 1) / 2;
                    }
                    sb.append(total).append("\n");
                    break;
            }
        }
        bw.write(sb.toString()); bw.flush(); bw.close();
    }
}