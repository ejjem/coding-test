import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br;
	static StringBuilder sb;
	static StringTokenizer st;
	static int N, L;
	static int answer;
	static ArrayList<info> infos;
	
	private static void solution(int index, int total_score, int total_kcal) {
		if(index == N) {
			answer = Math.max(answer, total_score);
			return;
		}
		
		solution(index + 1, total_score, total_kcal);
		info tmp = infos.get(index);
		int T_tmp = tmp.getscore();
		int K_tmp = tmp.getkcal();
		if ( (total_kcal + K_tmp) <= L) {
			solution(index + 1, total_score + T_tmp, total_kcal + K_tmp);
		}
	}
	
	static class info{
		int score;
		int kcal;
		
		info(int score, int kcal){
			this.score = score;
			this.kcal = kcal;
		}
		int getscore() {
			return this.score;
		}
		int getkcal() {
			return this.kcal;
		}
	}

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
        	st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            infos = new ArrayList<>();
            for(int i=0; i<N; i++) {
            	st = new StringTokenizer(br.readLine());
            	int T_i = Integer.parseInt(st.nextToken());
            	int K_i = Integer.parseInt(st.nextToken());
            	infos.add(new info(T_i, K_i));
            }
            
            answer = 0;
            solution(0, 0, 0);     
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
    }
}