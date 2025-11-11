import java.io.IOException;
import java.io.*;
import java.util.*;
class Main {

    static int calc(int r, int c, int size){
        int result = 0;
        if(r < size && c >= size) result = 1;
        else if(r >= size && c < size) result = 2;
        else if(r >= size && c >= size) result = 3;
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int cnt = 0;
        while(--N != -1){
            int size = (int)Math.pow(2, N);
            int pos = calc(r, c, size);
            if(N != 0) cnt += pos * size * size;
            else if(N == 0) cnt += pos + 1;
            if(r >= size) r -= size;
            if(c >= size) c -= size;
        }
        System.out.println(cnt-1);
    }
}