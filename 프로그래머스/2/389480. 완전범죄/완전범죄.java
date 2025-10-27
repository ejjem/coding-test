import java.util.*;

class Solution {
    int min;
    int N;
    int M;
    boolean[][][] visited;
    public int solution(int[][] info, int n, int m) {
        int answer = -1;
        int l = info.length;
        min = Integer.MAX_VALUE; N = n; M = m;
        visited = new boolean[l][n][m];
        backtracking(0, 0, 0, l, info);
        if(min != Integer.MAX_VALUE) answer = min;
        System.out.println(answer);
        return answer;
    }
    void backtracking(int tA, int tB, int index, int l, int[][] info){
        if(index == l){
            min = Math.min(min, tA);
            return;
        }
        if(min <= tA) return;
        if(tA + info[index][0] < N && !visited[index][tA + info[index][0]][tB]) {
            backtracking(tA + info[index][0], tB, index+1, l, info);
            visited[index][tA + info[index][0]][tB] = true;
        }
        if(tB + info[index][1] < M && !visited[index][tA][tB + info[index][1]]) {
            backtracking(tA, tB + info[index][1], index+1, l, info);
            visited[index][tA][tB + info[index][1]] = true;
        }
    }
}