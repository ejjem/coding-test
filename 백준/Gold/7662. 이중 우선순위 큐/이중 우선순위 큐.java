import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=0; tc<T; tc++){
            TreeMap<Integer, Integer> tm = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());
            for(int i=0; i<k; i++){
                st = new StringTokenizer(br.readLine());
                char operation = st.nextToken().charAt(0);
                int n = Integer.parseInt(st.nextToken());
                switch (operation) {
                    case 'I': // 삽입
                        tm.put(n, tm.getOrDefault(n, 0) + 1);
                        break;
                    case 'D':
                        if(!tm.isEmpty()){
                            int key;
                            if(n == 1){ // 최댓값 삭제
                                key = tm.lastKey();
                            }
                            else{ // 최솟값 삭제
                                key = tm.firstKey();
                            }
                            if(tm.get(key) == 1){
                                tm.remove(key);
                            }
                            else{
                                tm.put(key, tm.get(key) - 1);
                            }
                        }
                        break;
                }
            }
            if(tm.isEmpty()){
                sb.append("EMPTY").append("\n");
            }
            else{
                sb.append(tm.lastKey()).append(" ").append(tm.firstKey()).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush(); bw.close();
    }
}