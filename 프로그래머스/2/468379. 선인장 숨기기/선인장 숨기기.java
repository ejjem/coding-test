/*
 m * n 구역 안에 h * w 선인장 구역을 놓기. 놓고선 선인장 구역의 왼쪽 위 좌표 반환
 drop를 가능한 안 맞는 구역 있는지 찾고, 없으면 제일 늦게 맞는 구역 찾기.
 구간 내 (h * w) 최솟값 미리 찾아놓고 탐색하기 -> 모노톤 큐로 가로 / 세로 각각 찾기
 
 
*/

import java.util.*;
class Solution {
    
    public int[] slidingMin(int[] arr, int k){
        int[] result = new int[arr.length - k + 1];
        // dq에는 index를 넣기
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for(int i=0; i<arr.length; i++){
        
            // 구간 벗어난 index 제거
            while(!dq.isEmpty() && dq.peekFirst() <= i - k){
                dq.pollFirst();
            }
            
            // 최솟값 후보 아닌 애들 제거
            while(!dq.isEmpty() && arr[dq.peekLast()] >= arr[i]){
                dq.pollLast();
            }
            
            // 삽입
            dq.offerLast(i);
            
            // 윈도우 완성되면 기록 시작
            if(i >= k - 1){
                result[i-k+1] = arr[dq.peekFirst()];
            }
        }
        return result;
    }
    
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int[] answer = {};
        int[][] map = new int[m][n];
        int[][] minMap = new int[m][n];
        int INF = Integer.MAX_VALUE;
        for(int i=0; i<m; i++){
            Arrays.fill(map[i], INF);
        }
        
        for(int i=0; i<drops.length; i++){
            int[] tmp = drops[i];
            map[tmp[0]][tmp[1]] = i + 1;
        }
        
        // 가로
        for(int row=0; row<m; row++){
            int[] minArr = slidingMin(map[row], w);
            for(int col=0; col<minArr.length; col++){
                minMap[row][col] = minArr[col];
            }
        }
        
        // 세로
        for(int col=0; col<n-w+1; col++){
            int[] cur = new int[m];
            for(int row=0; row<m; row++){
                cur[row] = minMap[row][col];
            }
            int[] minArr = slidingMin(cur, h);
            for(int row=0; row<minArr.length; row++){
                minMap[row][col] = minArr[row];
            }
        }
        
        // 순회
        int max = Integer.MIN_VALUE;
        for(int row=0; row<m-h+1; row++){
            for(int col=0; col<n-w+1; col++){
                if(minMap[row][col] == Integer.MAX_VALUE){
                    answer = new int[]{row, col};
                    return answer;
                }
                else if (minMap[row][col] > max) {
                    max = minMap[row][col];
                    answer = new int[]{row, col};
                }
            }
        }
        
        return answer;
    }
}