import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc=0; tc<testcase; tc++){
            int answer = 1;
            Map<String, Integer> map = new HashMap<>();
            int N = Integer.parseInt(br.readLine());
            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String item = st.nextToken();
                String category = st.nextToken();
                if(map.containsKey(category)){
                    map.put(category, map.get(category) + 1);
                }
                else{
                    map.put(category, 1);
                }
            }
            for(String s : map.keySet()){
                answer = answer * (map.get(s) + 1);
            }
            sb.append(answer - 1).append("\n");
        }
        System.out.println(sb);
    }
}