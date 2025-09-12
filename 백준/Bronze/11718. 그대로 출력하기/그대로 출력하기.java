import java.util.*;
import java.io.*;

class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String str;
        while((str = br.readLine()) != null) {
        	//System.out.println(str);
        	sb.append(str).append("\n");
        }
        br.close();
        bw.write(sb.toString()); bw.flush(); bw.close();
    }
}