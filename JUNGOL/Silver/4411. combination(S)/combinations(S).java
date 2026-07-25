import java.io.*;
import java.util.*;


class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        // int answer = combination(n, k, 0, 0);
        answer = 0;
        combination(n, k, 0, 0);
        System.out.println(answer);
    }

    static int answer;
    static void combination(int n, int k, int index, int count){
        if(count == k){
            answer ++; 
            return;
        }
        if(index == n){
            return;
        }
        combination(n, k, index+1, count);
        combination(n, k, index+1, count+1);
        return;
    }

    /*
    static int combination(int n, int k, int index, int count){
        if(count == k){
            return 1;
        }
        if(index == n){
            return 0;
        }
        int total = 0;
        total += combination(n, k, index+1, count);
        total += combination(n, k, index+1, count+1);
        return total;
    }
    */
}
