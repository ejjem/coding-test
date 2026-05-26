/*
    그냥 하나씩 끊어보기
    -> [a, b]를 끊었을 때 a, b 각각의 집합에서 연결된 갯수 찾기
    -> 차이 절댓값으로 Min 갱신
    
    
*/
import java.util.*;
class Solution {
    public int dfs(int cur, List<Integer>[] graph, boolean[] visited){
        visited[cur] = true;
        int count = 1;
        
        for(int n : graph[cur]){
            if(!visited[n]){
                count += dfs(n, graph, visited);
            }
        }
        return count;
    }
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        for(int cut=0; cut<wires.length; cut++){
            // graph 세팅
            List<Integer>[] graph = new ArrayList[n+1];
            for(int i=1; i<=n; i++){
                graph[i] = new ArrayList<>();
            }
            for(int j=0; j<wires.length; j++){
                if(j == cut) continue;
                int a = wires[j][0]; int b = wires[j][1];
                graph[a].add(b);
                graph[b].add(a);
            }
            
            int x = wires[cut][0];
            int y = wires[cut][1];
            
            boolean[] visited = new boolean[n+1];
            int xCnt = dfs(x, graph, visited);
            boolean[] visited2 = new boolean[n+1];
            int yCnt = dfs(y, graph, visited2);
            
            int tmp = Math.abs(xCnt - yCnt);
            answer = Math.min(answer, tmp);
        }
        return answer;
    }
}