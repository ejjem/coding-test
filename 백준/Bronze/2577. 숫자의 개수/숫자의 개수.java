import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 1;
        for(int i=0;i<3;i++){
            num *= Integer.parseInt(br.readLine());
        }
        String number = Integer.toString(num);
        int[] count = new int[10];
        for(int i=0; i<number.length(); i++){
            char ch = number.charAt(i);
            int idx = ch - '0';
            count[idx] += 1;
        }
        for(int i=0; i<10; i++){
            System.out.println(count[i]);
        }
    }
}