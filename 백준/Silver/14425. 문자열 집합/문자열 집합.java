import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static class Node{
        Node[] next = new Node[26];
        boolean isEnd;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Node root = new Node(); 
        for(int i=0; i<N; i++){
            Node now = root;
            String str = br.readLine();
            for(int j=0; j<str.length(); j++){
                char c = str.charAt(j);
                if(now.next[c-'a'] == null){
                    now.next[c-'a'] = new Node();
                }
                now = now.next[c-'a'];
                if(j == str.length()-1){
                    now.isEnd = true;
                }
            }
        }
        int cnt = 0;
        for(int i=0; i<M; i++){
            Node now = root;
            String str = br.readLine();
            for(int j=0; j<str.length(); j++){
                char c = str.charAt(j);
                if(now.next[c-'a'] == null){
                    break;
                }
                now = now.next[c-'a'];
                if(j == str.length()-1 && now.isEnd){
                    cnt ++;
                }
            }
        }
        System.out.println(cnt);
    }
}