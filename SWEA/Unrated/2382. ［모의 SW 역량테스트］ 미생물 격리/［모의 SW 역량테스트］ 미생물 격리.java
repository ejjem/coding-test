import java.util.*;
import java.io.*;

public class Solution {
	
	//상, 하, 좌, 우
	static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static class Micro{
		boolean alive;
		int y; int x; int cnt; int dir;
		Micro(int y, int x, int cnt, int dir){
			this.alive = true;
			this.y= y; this.x = x; this.cnt = cnt; this.dir = dir;
		}
	}
	static Micro[] micros;
	static int N, M, K;
	static HashMap<Integer, int[]> pos2idx;
	
	static boolean isRedshell(int y, int x) {
		if(y == 0 || y == N-1 || x == 0 || x == N-1) return true;
		return false;
	}
	static int changeDir(int n) {
		switch(n) {
		case 1:
			return 2;
		case 2:
			return 1;
		case 3:
			return 4;
		case 4:
			return 3;
		}
		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<T+1;tc++) {
			int answer = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());
			micros = new Micro[K];
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				micros[i] = new Micro(Integer.parseInt(st.nextToken()), 
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken())
						);
			}
			for(int time=0;time<M;time++) {
				pos2idx = new HashMap<>();
				for(int i=0; i<K; i++) {
					Micro tmp = micros[i];
					if(!tmp.alive) continue;
					
					int dy = dist[tmp.dir-1][0]; int dx = dist[tmp.dir-1][1];
					tmp.y += dy; tmp.x += dx;
					if(pos2idx.containsKey(tmp.y*100 + tmp.x)) {
						//합쳐지는 로직 짜기
						Micro target = micros[pos2idx.get(tmp.y*100 + tmp.x)[0]];
						if(pos2idx.get(tmp.y*100 + tmp.x)[1] > tmp.cnt) {
							tmp.alive = false;
							target.cnt += tmp.cnt;
						}
						else {
							target.alive = false;
							pos2idx.put(tmp.y*100 + tmp.x, new int[] {i, tmp.cnt});
							tmp.cnt += target.cnt;
						}
					}
					else {
						if(isRedshell(tmp.y, tmp.x)) {
							if(tmp.cnt == 1) {
								tmp.alive = false;
								continue;
							}
							tmp.cnt /= 2;
							tmp.dir = changeDir(tmp.dir);
						}
						pos2idx.put(tmp.y*100 + tmp.x, new int[] {i, tmp.cnt});
					}
				}
			}
			for(int i=0; i<K; i++) {
				if(micros[i].alive) {
					answer += micros[i].cnt;
				}
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		
		bw.write(sb.toString()); bw.flush(); bw.close();
	}
}
