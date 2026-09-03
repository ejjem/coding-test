import java.util.*;
class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int small = Math.min(a, b);
        int big = Math.max(a, b);
        for(int i=small; i<=big; i++){
            answer += i;
        }
        return answer;
    }
}