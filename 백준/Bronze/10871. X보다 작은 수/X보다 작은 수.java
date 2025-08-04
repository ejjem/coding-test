import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int target = 0;
        for(int i=0; i<N; i++){
            target = Integer.parseInt(st.nextToken());
            if (target < X){
                list.add(target);
            }
        }
        for(int i = 0; i < list.size(); i++){
            System.out.printf("%d ", list.get(i));
        }
    }
}