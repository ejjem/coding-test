import java.io.*;
import java.util.*;

public class Main {    
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	String str = br.readLine();
    	// 대문자 : 97 ~ 122
    	// 소문자: 65 ~ 90
    	for(int i=0; i<str.length(); i++) {
    		char c = str.charAt(i);
    		if( 97 <= (int) c && (int) c <= 122) { // 대문자
    			sb.append((char) (c - 32));
    		}
    		else if ( 65 <= (int) c && (int) c <= 90) {
    			sb.append((char) (c + 32));
    		}
    	}
    	System.out.println(sb);
    }
}