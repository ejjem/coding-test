import java.util.*;
class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        int n = land.length; // 땅의 세로 길이, n <= 500
        int m = land[0].length; // 땅의 가로 길이, m <= 500
        // land[i][j] = 0 : 빈 땅
        // land[i][j] = 1 : 석유
        int index = 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        // 마스킹
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(land[i][j] == 1) { 
                    int result = bfs(i, j, index, land);
                    map.put(index, result);
                    index++;
                }
            }
        }
        /*
        for(int i=0; i<n; i++){
            System.out.println(Arrays.toString(land[i]));
        }
        */
        
        // 시추 확인
        for(int i=0; i<m; i++){
            //System.out.println("시추: " + i);
            int tmp = 0;
            boolean[] visited = new boolean[index];    
            for(int j=0; j<n; j++){
                int cnt = land[j][i];
                if(cnt != 0 && !visited[cnt]){
                    visited[cnt] = true;
                    tmp += map.get(cnt);
                    //System.out.println("석유 찾음: " + map.get(cnt));
                }
            }
            answer = Math.max(answer, tmp);
            //System.out.println(answer);
        }
        
        return answer;
    }
    public int bfs(int i, int j, int index, int[][] land){
        int cnt = 1;
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offerLast(new int[]{i, j});
        land[i][j] = index;
        while(!queue.isEmpty()){
            int[] cur = queue.pollFirst();
            int y = cur[0]; int x = cur[1];
            for(int idx=0; idx<4; idx++){
                int dy = dir[idx][0] + y;
                int dx = dir[idx][1] + x;
                if(0<=dy && dy<land.length && 0<=dx && dx<land[0].length && land[dy][dx] == 1){
                    land[dy][dx] = index;
                    queue.offerLast(new int[]{dy, dx});
                    cnt ++;
                }
            }
        }
        return cnt;
    }
}