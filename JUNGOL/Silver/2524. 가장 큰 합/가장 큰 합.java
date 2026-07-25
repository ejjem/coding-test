import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int value = 0;
        Deque<Integer> window = new ArrayDeque<>();
        for(int idx=0; idx<k; idx++){
            int tmp = Integer.parseInt(br.readLine());
            value += tmp;
            window.offerLast(tmp);
        }
        int answer = value;
        for(int idx=k; idx<n; idx++){
            int tmp = Integer.parseInt(br.readLine());
            int out = window.pollFirst();
            window.offerLast(tmp);
            value -= out;
            value += tmp;
            answer = Math.max(answer, value);
        }
        System.out.println(answer);
    }
}