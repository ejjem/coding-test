import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] numbers = br.readLine().toCharArray();
        int answer = 0;
        for(int i=0;i<N;i++){
            answer += numbers[i] - '0';
        }
        System.out.println(answer);
    }
}