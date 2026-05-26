import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int idx=0; idx<commands.length; idx++){
            List<Integer> list = new ArrayList<>();
            int[] tmp = commands[idx];
            int i = tmp[0]; int j = tmp[1]; int k = tmp[2];
            for(int n=i-1; n<=j-1; n++){
                list.add(array[n]);
            }
            Collections.sort(list);
            answer[idx] = list.get(k-1);
        }
        return answer;
    }
}