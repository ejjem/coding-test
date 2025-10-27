import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] cnt = new int[26];
        Arrays.fill(cnt, -1);
        String str = br.readLine();
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            int idx = (int)c - (int)'a';
            if(cnt[idx] == -1) cnt[idx] = i;
        }
        for(int i=0; i<26; i++){
            sb.append(cnt[i]).append(" ");
        }
        System.out.println(sb);
    }
}