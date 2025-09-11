import java.io.*;
import java.util.*;
 
public class Solution {
	// mask의 i번째 비트가 0이면 계단0, 1이면 계단1로 배정
	static int timeForMask(int mask, int p, int[][] dist, int[][] stairs) {
	    ArrayList<Integer> s0 = new ArrayList<>();
	    ArrayList<Integer> s1 = new ArrayList<>();

	    for (int i = 0; i < p; i++) {
	        if ((mask & (1 << i)) == 0) s0.add(dist[i][0] + 1); // 도착시간 = 거리+1
	        else                        s1.add(dist[i][1] + 1);
	    }
	    int t0 = simulate(s0, stairs[0][2]);
	    int t1 = simulate(s1, stairs[1][2]);
	    return Math.max(t0, t1); // 두 계단은 동시에 진행 -> 최대값이 전체 시간
	}
	
	static int simulate(List<Integer> arrivals, int L) {
	    if (arrivals.isEmpty()) return 0;
	    Collections.sort(arrivals);
	    PriorityQueue<Integer> pq = new PriorityQueue<>(); // 현재 계단 위 사람들의 '끝나는 시각' 최소힙
	    int lastFinish = 0;

	    for (int t : arrivals) {
	        while (!pq.isEmpty() && pq.peek() <= t) pq.poll(); // 도착 시간 기준으로 초기화

	        int start;
	        if (pq.size() < 3) { // 자리 남으면 바로 계단 진입
	            start = t;
	        } else { // 자리 x
	            int earliest = pq.poll(); // 한 명이 계단에서 나가는 시간
	            start = earliest;         // 그 시간에 계단 진입
	        }
	        int finish = start + L;       // 내려가는 데 L 소요
	        pq.add(finish); // pq에는 계단을 나가는 시간만 저장되어 있음
	        if (finish > lastFinish) lastFinish = finish;
	    }
	    return lastFinish;
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<T+1; tc++) {
        	int p = 0;
        	int s = 0;
        	int N = Integer.parseInt(br.readLine());        	
        	int[][] people = new int[10][2];
        	int[][] stairs = new int[2][3];
        	for(int i=0; i<N; i++) {
        		st = new StringTokenizer(br.readLine());
        		for(int j=0; j<N; j++) {
        			int n = Integer.parseInt(st.nextToken());
        			if(n == 1) {
        				people[p][0] = i; people[p][1] = j; p++;
        			}
        			if(n > 1) {
        				stairs[s][0] = i; stairs[s][1] = j; stairs[s][2] = n; s++; 
        			}
        		}
        	}
        	int[][] dist = new int[p][2];
        	PriorityQueue<int[]> pq = new PriorityQueue<>();
        	for(int i=0; i<p; i++) {
        		int y = people[i][0]; int x = people[i][1];
        		
        		dist[i][0] = Math.abs(y - stairs[0][0]) + Math.abs(x - stairs[0][1]);
        		dist[i][1] = Math.abs(y - stairs[1][0]) + Math.abs(x - stairs[1][1]);
        	}
        	
        	// 2^10
        	int answer = Integer.MAX_VALUE;
        	for(int mask=0; mask<(1<<p); mask++) {
        		int total = timeForMask(mask, p, dist, stairs);
        		if(total < answer) answer = total;
        	}
        	
        	sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        bw.write(sb.toString()); bw.flush(); br.close(); bw.close();
    }
}