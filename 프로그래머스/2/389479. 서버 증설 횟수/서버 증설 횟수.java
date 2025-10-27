import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int[] server = new int[24];
        int answer = 0;
        for(int i=0; i<24; i++){
            int cnt = server[i];
            if(players[i] < (cnt+1)*m) continue;
            else{
                int add = 0;
                while(players[i] >= (cnt+1+add)*m) add++;
                for(int j=i; j<Math.min(i+k, 24); j++){
                    server[j] += add;
                }
                answer += add;
            }
        }
        return answer;
    }
}