import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++) {
        	//System.out.println(i);
        	String input = br.readLine();
        	int score = 0;
        	int winning = 0;
        	for(int j=0;j<input.length();j++) {
        		if(input.charAt(j) == 'O') score = score + winning++ + 1;
        		else if(input.charAt(j) == 'X') winning=0;
        		//System.out.printf("중간 점수: %d\n", score);
        	}
        	System.out.println(score);
        }
    }
}