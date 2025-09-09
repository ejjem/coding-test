import java.io.*;
import java.util.*;

public class Main {    
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	boolean[] check = new boolean[31];
    	for(int i=0; i<28; i++) {
    		check[Integer.parseInt(br.readLine())] = true;
    	}
    	for(int i=1; i<31; i++) {
    		if(!check[i]) System.out.println(i);
    	}
    }
}