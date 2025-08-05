import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        while(true){
            try{
                st.nextToken();
                answer ++;
            }
            catch(Exception e){
                System.out.println(answer);
                return;
            }
        }
    }
}