import java.util.*;


import java.io.*;

/*
 a ~ z : 1 ~ 26
 원래 a : 97, 원래 z: 122
 각각 -96 해줘야함 
 A ~ Z : 27 ~ 52
 원래 A : 65, 원래 Z: 90
 각각 -38 해줘야함
 */
 
class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine()); // 컴터 갯수
        ArrayList<int[]>[] graph = new ArrayList[N];
        for(int i=0; i<N; i++) graph[i] = new ArrayList<>();
        int min = 0;
        int total = 0;
        for(int i=0; i<N; i++) {
        	String str = br.readLine();
        	for(int j=0; j<N; j++) {
        		int tmp = (int)str.charAt(j);
        		if(tmp == 48) continue;
        		int l = 0;
        		if(97<= tmp && tmp <= 122) { //소문자
        			l = tmp - 96;
        		}
        		else if(65 <= tmp && tmp <= 90) { //대문자
        			l = tmp - 38;
        		}
        		total += l;
        		if(i == j) continue;
        		else {
        			graph[i].add(new int[] {j, l});
        			graph[j].add(new int[] {i, l});
        		}
        	}
        }
        boolean[] visited = new boolean[N];
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[1], o2[1]);
			}
        	
        });
        visited[0] = true;
        for(int[] n : graph[0]) {
        	pq.offer(n);
        }
        int cnt = 1;
        while(!pq.isEmpty()) {
        	int[] cur = pq.poll();
        	int e = cur[0]; int w = cur[1];
        	if(visited[e]) continue;
        	visited[e] = true;
        	cnt ++;
        	min += w;
        	if(cnt == N) break;
        	for(int[] n : graph[e]) {
        		if(!visited[n[0]]) pq.add(n); 
        	}
        }
        //System.out.println(Arrays.toString(visited));
        if(cnt != N) {
        	System.out.println(-1); return;
        }
        System.out.println(total - min);
    }
}