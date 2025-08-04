import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] poketmon = new String[N + 1];
        Map<String, Integer> poketmon_number = new HashMap<>();
        for(int i = 1; i < N+1; i++){
            poketmon[i] = br.readLine();
            poketmon_number.put(poketmon[i], i);
        }
        for(int i = 0; i < M; i++){
            String input = br.readLine();
            if (Character.isDigit(input.charAt(0))){ // 번호로 검색
                System.out.println(poketmon[Integer.parseInt(input)]);
            }
            else{
                System.out.println(poketmon_number.get(input));
            }
        }
    }
}