import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> answer = new HashSet<>();
        for(int i=0;i<10;i++) {
        	int input = Integer.parseInt(br.readLine());
        	answer.add(input%42);
        }
        System.out.println(answer.size());
    }
}