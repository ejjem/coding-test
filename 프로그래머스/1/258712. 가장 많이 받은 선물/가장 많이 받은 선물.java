/*
    [문제]
    1) 두 사람이 선물을 주고받은 기록이 있다면, 이번 달까지 두 사람 사이에 더 많은 선물을 준 사람이 다음 달에 선물을 1개 받음
    2)  사람이 선물을 주고받은 기록이 하나도 없거나 주고받은 수가 같다면, 선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물을 1개 받음
    * 선물 지수: 이번 달까지 자신이 친구들에게 준 선물의 수에서 받은 선물의 수를 뺀 값
    3) 두 사람의 선물 지수도 같다면 서로 선물을 주지 않음
    
    최종적으로 당므 달에 가장 많이 선물을 받을 친구는?
    
    [풀이]
    
    일단 당연히 선물 지수부터 다 구해놔야할듯
    
    전체 경우의 수는 50C2로 비교하는거라서 크진 않은거 같은데 그냥 2중 for문 기반 완탐 해도 되지 않을까
    
    근데 '서로 선물을 준 사이' 라는걸 어떻게 기억하지. 친구 수 50명이니까 비트 마스킹해서 변수로 들고 있을까
    일단 2차원 boolean으로 만들어 놓고, 터지면 비트 마스킹으로 해보자. 
    -> 수정) 몇 개의 선물을 주고 받았는지도 기록해야 해서, 2차원 int[][]로 해야 할듯
    
    int[][] gifted의 의미 -> 행 기준 준 갯수
    
    1번 친구, 5번 친구
    
    1번이 5번에게 준 갯수: int[1][5]
    5번이 1번에게 준 갯수: int[5][1]
    
    int[1]의 총 합: 1이 지금까지 준 모든 선물의 갯수
    int[0][1] ~ int[n][1]: 총 합은 1이 지금까지 받은 모든 선물으 ㅣ개수
    
*/

import java.io.*;
import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        // 친구 수: n
        int n = friends.length;
        int[][] gifted = new int[n][n];
        int[] giftScore = new int[n];
        int[] result = new int[n];
        // 친구 이름 <-> 인덱스 매칭
        // 이름으로 검색하면 인덱스가 나옴
        HashMap<String, Integer> F2I = new HashMap<>();
        for(int i=0; i<n; i++){
            F2I.put(friends[i], i);
        }
        
        
        for(String s : gifts){
            String[] tmp = s.split(" ");
            int giver = F2I.get(tmp[0]);
            int receiver = F2I.get(tmp[1]);

            gifted[giver][receiver]++;
            giftScore[giver]++;
            giftScore[receiver]--;
        }
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){   
                // i가 더 많이 줌 
                if(gifted[i][j] > gifted[j][i]) result[i] ++;
                
                // j가 더 많이 줌
                else if(gifted[i][j] < gifted[j][i]) result[j] ++;
                
                else{
                    if(giftScore[i] > giftScore[j]) result[i] ++;
                    else if(giftScore[i] < giftScore[j]) result[j] ++;
                }
            }        
        }
        
        for(int i=0; i<n; i++){
            answer = Math.max(answer, result[i]);
        }
        
        return answer;
    }
}