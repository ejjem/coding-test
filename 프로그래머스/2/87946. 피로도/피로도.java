/*
    순열? 일단 순서대로 도는게 가능한지 보는거니까.
    그러면 가능한 애들 순서대로 돌아보고 최댓값 정해도 괜찮을거 같은디 흠
    
    종료 조건
    1. 모든 던전을 돌았음
    2. 더 이상 갈 수 있는 던전이 없음
    -> visited에 더 이상 못 가는 곳도 추가하면 되지 않나? 
    
    
*/
import java.util.*;

class Solution {
    static boolean[] visited;
    static int max;
    public void permutation(int k, int[][] dungeons){
        visited = new boolean[dungeons.length];
        perm(k, 0, 0, dungeons);
        
    }
    
    public void perm(int k, int count, int check, int[][] dungeons){
        if(check == dungeons.length){
            max = Math.max(max, count);
            return;
        }
        
        for(int i=0; i<dungeons.length; i++){
            if(visited[i]) continue;
            int minimum = dungeons[i][0];
            int need = dungeons[i][1];
            visited[i] = true;
            if(k < minimum){
                perm(k, count, check + 1, dungeons);
            }
            else{
                perm(k-need, count + 1, check + 1, dungeons);
            }
            visited[i] = false;
        }
    }
    
    
    public int solution(int k, int[][] dungeons) {
        max = -1;
        permutation(k, dungeons);
        return max;
    }
}