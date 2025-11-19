import java.io.*;
import java.util.*;

class Main {
    static HashMap<String, Integer> map;
    static HashSet<String> set;
    static List<String> tags;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for(int idx=0; idx<tc; idx++){
            int answer = 1;
            int n = Integer.parseInt(br.readLine());
            set = new HashSet<>();
            map = new HashMap<>();
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                String item = st.nextToken();
                String tag = st.nextToken();
                set.add(tag);
                if(map.containsKey(tag)){
                    int tmp = map.get(tag);
                    map.put(tag, tmp+1);
                }
                else{
                    map.put(tag, 1);
                }
            }
            for(String str : set){
                answer = answer * (map.get(str)+1);
            }
            sb.append(answer - 1).append("\n");
        }
        bw.write(sb.toString()); bw.flush(); bw.close();
    }
}