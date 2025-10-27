import java.io.IOException;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if(a[1] == b[1]) return a[0] - b[0];
                return a[1] - b[1];
            }
        });
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            pq.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        int[] first = pq.poll();
        int cnt = 1;
        int now = first[1];
        //System.out.println(first[0] + " " + first[1]);
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int start = cur[0]; int end = cur[1];
            if(start >= now){
                cnt += 1;
                now = end;
                //System.out.println(start + " " + end);
            }
        }
        System.out.println(cnt);
    }
}