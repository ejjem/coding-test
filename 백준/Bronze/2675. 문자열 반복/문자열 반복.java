import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            String origin = st.nextToken();
            StringBuilder sb = new StringBuilder();
            for(int idx=0;idx<origin.length();idx++) {
            	char ch = origin.charAt(idx);
            	for(int cnt=0;cnt<N;cnt++) {
            		sb.append(ch);
            	}
            }
            String answer = sb.toString();
            System.out.println(answer);
        }
    }
}