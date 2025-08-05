import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        // a: 97, z: 122
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	HashMap<Character, Integer> map = new HashMap<>();
    	for(int i = 97; i<123; i++) {
    		char alph = (char)i;
    		map.put(alph, -1);
    	}
    	String target = br.readLine();
    	for(int idx=0;idx<target.length();idx++) {
    		char ch = target.charAt(idx);
    		if(map.get(ch) == -1) map.replace(ch, idx);
    	}
    	for(int i = 97; i<123; i++) {
    		char alph = (char)i;
    		System.out.print(map.get(alph) + " ");
    	}
    }
}