/*
 k는 최대 10
 -> 3*2*2*2*...*2 -> 512*3 = 1536
 
 완탐 해야할듯?
 가능한 모든 행동마다 전체 감염 수 세기
 그래프만 어떻게 저장할지 고민
 
 1안) <- 다시 1안으로  
 key  | value
 
 {1}   { {2, A}, {3, A}, {4, C}, {5, B} }
 
 2안)
 key  | value
 {A}   { {1, 2}, {1, 3}, {9, 10}, {5, 6}, {5, 7} }
 
 
 A가 열렸을 때 연결된 node 별로 좌, 우 중 감염된게 있으면 감염시키는 식으로 가면 될듯.
 
 이러니까 같은 파이프 라인 내에서도 주어진 순서에 따라 달라짐; 방식을 바꿔야 할듯
 
 감염된 애들 리스트를 두고, 해당 노드에서 계속 뻗어나가는 식으로 해야할듯 dfs 마냥
 1) 감염된 애들 리스트 보유
 2) 파이프 열고, 감염된 애들 중 해당 파이프로 연결된 다른 노드 있는지확인
 3) 해당 연결 노드 감염시키고, 재탐색 -> dfs

 
*/

import java.io.*;
import java.util.*;
class Solution {
    static int max;
    static Map<Integer, List<int[]> > graph;
    static void search(int n, int k, int pipe, boolean[] status, int count, int total){
        int nowTotal = total;
        ArrayList<Integer> nowInfection = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();
        
        // 감염 진행 by dfs
        for(int i=1; i<=n; i++){
            if(status[i]) queue.offerLast(i);
        }
        while(!queue.isEmpty()){
            int cur = queue.pollFirst();
            for(int[] next : graph.get(cur)){
                if(!status[next[0]] && next[1] == pipe){
                    // 감염
                    status[next[0]] = true;
                    nowInfection.add(next[0]);
                    queue.offerLast(next[0]);
                    nowTotal ++;
                }
            }
        }
        
        // 종료
        if(count == k){
            max = Math.max(max, nowTotal);
            for(int i : nowInfection){
                status[i] = false;
            }
            return;
        }
        
        // 다음 단계 진행
        for(int nextPipe=1; nextPipe<=3; nextPipe++){
            if(pipe == nextPipe) continue;
            search(n, k, nextPipe, status, count+1, nowTotal);
        }
            
        // 복구
        for(int i : nowInfection){
            status[i] = false;
        }
        return;
    }
    public int solution(int n, int infection, int[][] edges, int k) throws IOException {
        int answer = 0;
        max = Integer.MIN_VALUE;
        // 1-base로 진행
        boolean[] status = new boolean[n+1];
        status[infection] = true;
        graph = new HashMap<>();
        for(int i=1; i<=n; i++){
            graph.put(i, new ArrayList<>());
        }
        for(int idx=0; idx<edges.length; idx++){
            int[] tmp = edges[idx];
            int node1 = tmp[0];
            int node2 = tmp[1];
            int pipe = tmp[2];
            graph.get(node1).add(new int[]{node2, pipe});
            graph.get(node2).add(new int[]{node1, pipe});
        }
        
        for(int node=1; node<=3; node++){
            search(n, k, node, status, 1, 1);
        }
        answer = max;
        return answer;
    }
}