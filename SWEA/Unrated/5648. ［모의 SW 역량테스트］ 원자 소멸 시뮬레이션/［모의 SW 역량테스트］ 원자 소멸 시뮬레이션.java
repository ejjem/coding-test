/*
 * 1. 좌표에 Y, X 둘 다 +1000 씩 해줘서 0 <= X, Y <= 2000 으로 보정
 * 2. 이동하다가 초기 범위 0 ~ 2000 을 넘어가면 앞으로 소멸 안 하는 애라고 가정 -> 최대 2000번 반복
 * 3. Y * 1000 + X 로 고유 좌표 상수값 만들고, HashMap에다가 저장, 중복 시 충돌
 * 
 * 
 */

import java.io.*;
import java.util.*;

public class Solution {
	static int[][] dist = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
	static int alive;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<T+1;tc++) {
			int N = Integer.parseInt(br.readLine());
			int answer = 0;
			alive = N;
			int[][] atoms = new int[N][5];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = (Integer.parseInt(st.nextToken()) + 1000 ) * 2;
				int y = (Integer.parseInt(st.nextToken()) + 1000 ) * 2;
				int dir = Integer.parseInt(st.nextToken());
				int K = Integer.parseInt(st.nextToken());
				atoms[i] = new int[] {y, x, dir, K, 1};
			}
			while(alive > 0) {
				// <좌표 고유값, index>
				HashMap<Integer, Integer> board = new HashMap<>();
				HashSet<Integer> origin = new HashSet<>();
				for(int i=0; i<N; i++) {
					//죽은 애 제외
					if(atoms[i][4] == 0) continue;
					//늙은 애 죽임
					if(atoms[i][0] >= 4001 || atoms[i][1] >= 4001 || atoms[i][0] <= -1 || atoms[i][1] <= -1) {
						atoms[i][4] = 0;
						alive --;
						continue;
					}
					
					int dir = atoms[i][2];
					int dy = dist[dir][0]; int dx = dist[dir][1];
					atoms[i][0] += dy; atoms[i][1] += dx;
					
					int pos = atoms[i][0] * 10000 + atoms[i][1];
					if(board.containsKey(pos)) {
						if(!origin.contains(pos)) origin.add(pos);
						alive --;
						answer += atoms[i][3];
						atoms[i][4] = 0;
					}
					else {
						board.put(pos, i);
					}
				
				}
				
				if(!origin.isEmpty()) {
					for(int n : origin) {
						int idx = board.get(n);
						if(atoms[idx][4] == 1) {
							atoms[idx][4] = 0;
							answer += atoms[idx][3];
							alive --;
						}
					}
				}
				/*
				System.out.println("----");
				System.out.println("alive: " + alive);
				System.out.println("answer: " + answer);
				for(int i=0; i<N; i++) {
					System.out.println(Arrays.toString(atoms[i]));
				}
				*/
				
				
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString()); bw.flush(); bw.close();
	}

}
