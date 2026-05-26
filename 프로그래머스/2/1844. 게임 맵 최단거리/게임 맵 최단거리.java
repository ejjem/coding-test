import java.util.*;
class Solution {
    static boolean[][] visited;
    static int n;
    static int m;
    static int[][] dist = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public boolean isPossible(int y, int x){
        if(y >=0 && y < n && x >= 0 && x < m) return true;
        return false;
    }
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        //시작 [0, 0], 종료 [n-1, m-1] 고정
        int answer = -1;
        Deque<int[]> q = new ArrayDeque<>();
        q.offerLast(new int[]{0, 0, 1});
        visited[0][0] = true;
        while(!q.isEmpty()){
            int[] cur = q.pollFirst();
            int y = cur[0]; int x = cur[1]; int cnt = cur[2];
            if(y == n-1 && x == m-1){
                return cnt;
            }
            
            for(int i=0; i<4; i++){
                int dy = y + dist[i][0]; int dx = x + dist[i][1];
                if(isPossible(dy, dx) && !visited[dy][dx] && maps[dy][dx] == 1){
                    visited[dy][dx] = true;
                    q.offerLast(new int[]{dy, dx, cnt+1});
                }
            }
        }
        
        return answer;
    }
}