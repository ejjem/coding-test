import java.io.IOException;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        int i;
        for(i=666; ; i++){
            String number = Integer.toString(i);
            if(number.contains("666")) {
                if(++cnt == N) break;
            }
        }
        System.out.println(i);
    }
}