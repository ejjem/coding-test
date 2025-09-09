import java.util.*;
import java.io.*;

public class Main {
    static int answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()); int c = Integer.parseInt(st.nextToken());
        int[] sushis = new int[N];
        for(int i=0; i<N; i++) {
        	sushis[i] = Integer.parseInt(br.readLine());
        }
        int[] checked = new int[d+1];
        checked[c] ++;
        int kind = 1;
        for(int i=0; i<k; i++) {
        	int sushi = sushis[i];
        	if(checked[sushi] == 0) kind++;
        	checked[sushi] ++;
        }
        int max = kind;
        for(int i=1; i<N; i++) {
        	int start = i; int end = (i + k - 1) % N;
        	checked[sushis[start-1]] --;
        	if(checked[sushis[start-1]] == 0) kind --;
        	checked[sushis[end]] ++;
        	if(checked[sushis[end]] == 1) kind ++;
        	max = Math.max(kind, max);
        }
        System.out.println(max);
    }
}

