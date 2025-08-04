import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tmp = 0;
        int answer = 0;
        for(int i = 0; i < 5; i++){
            tmp = Integer.parseInt(st.nextToken());
            answer += Math.pow(tmp, 2);
        }
        System.out.println(answer%10);
    }
}