/*
    1번 수포자: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
    -> {1, 2, 3, 4, 5} 반복 => 5개
    2번 수포자: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
    -> {2, 1, 2, 3, 2, 4, 2, 5} 반복 => 8개
    3번 수포자: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
    -> {3, 3, 1, 1, 2, 2, 4, 4, 5, 5} 반복 => 10개 
*/
import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        List<Integer> tmp = new ArrayList<>();
        int[] points = new int[3];
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        for(int i=0; i<answers.length; i++){
            int n = answers[i];
            if(n == one[i%5]) points[0] ++;
            if(n == two[i%8]) points[1] ++;
            if(n == three[i%10]) points[2] ++;
        }
        int max = -1;
        for(int i=0; i<3; i++){
            max = Math.max(max, points[i]);
        }
        for(int i=0; i<3; i++){
            if(max == points[i]) tmp.add(i+1);
        }
        int[] answer = new int[tmp.size()];
        for(int i=0; i<tmp.size(); i++){
            answer[i] = tmp.get(i);
        }
        return answer;
    }
}