import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        StringBuilder answer = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] sum_array = new int[N];
        sum_array[0] = Integer.parseInt(st.nextToken());
        for(int idx=1; idx<N; idx++){
            sum_array[idx] = sum_array[idx-1] + Integer.parseInt(st.nextToken());
        }
        for(int idx=0; idx<M; idx++){
            st = new  StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            if (i == 1){
                answer.append(sum_array[j-1]);
            }
            else answer.append(sum_array[j-1] - sum_array[i-2]);
            answer.append("\n");
        }
        System.out.println(answer);
    }
}