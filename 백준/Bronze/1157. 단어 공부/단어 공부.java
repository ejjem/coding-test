import java.io.*;
import java.util.*;

/*
 * a: 97
 * z: 122
 * A: 65
 * Z: 90
 * 알파벳은 26개
 */


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] cnt = new int[26];
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            int idx = 0;
            if((int)c >= 97){ idx = (int)c - 97; }
            else{ idx = (int)c - 65; }
            cnt[idx] += 1;
        }
        //System.out.println(Arrays.toString(cnt));
        int max = -1;
        char ans = ' ';
        for(int i=0; i<26; i++){
            if(cnt[i] > max){
                max = cnt[i];
                ans = (char)(i+65);
            }
            else if(cnt[i] == max){
                ans = '?';
            }
        }
        System.out.println(ans);
    }
}