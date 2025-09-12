import java.util.*;
import java.io.*;

class Solution {
	static int[][] jirung;
	static int N;
	static long answer, sx, sy;
	static void search(boolean[] selected, int idx, int cnt) {
		if(cnt == N/2) {
			long px = 0; long py = 0;
			for(int i=0; i<N; i++) {
				if(selected[i]) {
					px += jirung[i][0];
					py += jirung[i][1];
				}
			}
			long rx = 2*px - sx; long ry = 2*py - sy;
			answer = Math.min(answer, rx*rx + ry*ry);
			return;
		}
		for(int i=idx; i<N; i++) {
			if(!selected[i]) {
				selected[i] = true;
				search(selected, i+1, cnt+1);
				selected[i] = false;
			}		
		}
    }
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        // 반만 조합으로 뽑기
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<T+1; tc++) {
        	N = Integer.parseInt(br.readLine());
        	answer = Long.MAX_VALUE;
        	sx = 0; sy = 0;
        	jirung = new int[N][2];
        	for(int i=0; i<N; i++) {
        		st = new StringTokenizer(br.readLine());
        		int x = Integer.parseInt(st.nextToken());
        		int y = Integer.parseInt(st.nextToken());
        		jirung[i][0] = x;
        		jirung[i][1] = y;
        		sx += x; sy += y;
        	}
        	boolean[] selected = new boolean[N];
        	search(selected, 0, 0);
        	sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        bw.write(sb.toString()); bw.flush(); bw.close();
    }
}