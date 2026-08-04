/*
    visited 기반으로 탐색 여부 관리
    DFS 기반으로 해서, 새로운 노드가 나오면 stack에 넣어서 우선적으로 탐색
    이미 방문한 곳은 재 탐색 X
    그렇게 전체 stack 이 빌 때 마다 네트워크 1개 탐색 완료로 간주
*/ 
import java.io.*;
import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for(int idx=0; idx<n; idx++){
            if(!visited[idx]){
                System.out.println("탐색 시작: " + idx);
                DFS(n, idx, computers, visited);
                answer ++;
            }
        }
        return answer;
    }
    
    public void DFS(int n, int idx, int[][] computers, boolean[] visited){
        Deque<Integer> stack = new ArrayDeque<>();
        stack.offerLast(idx);
        visited[idx] = true;
        while(!stack.isEmpty()){
            int cur = stack.pollLast();
            for(int i=0; i<n; i++){
                if(computers[cur][i] == 1 && !visited[i]){
                    visited[i] = true;
                    stack.offerLast(i);
                }
            }
        }
        return;
    }
}