import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static StringBuilder sb;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        for(int i=0;i<N;i++){
            numbers[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(numbers);
        sb = new StringBuilder();
        for(int i=0; i<N; i++){
            sb.append(numbers[i]).append("\n");
        }
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}