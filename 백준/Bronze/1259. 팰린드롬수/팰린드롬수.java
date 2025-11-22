import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        while(true){
            String num = br.readLine();
            if(num.equals("0")) break;
            int i;
            for(i=0; i<num.length()/2; i++){
                if(num.charAt(i) != num.charAt(num.length() - 1 - i)) break;
            }
            if(i == num.length()/2) sb.append("yes").append("\n");
            else sb.append("no").append("\n");
        }
        bw.write(sb.toString()); bw.flush(); bw.close();
    }
}