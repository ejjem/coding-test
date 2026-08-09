/*
    1) 여벌 체육복이 있는 학생들 번호 set 생성
    2) 체육복을 잃어버린 학생들 번호 set 생성
        이 때 여벌 체육복에 있는 학생 번호면 여벌 체육복 set에서 숫자 지우고 잃어버린 학생 set에서도 제거 
    3) 1 ~ n 까지 순회하면서
        3-1) 잃어버린 학생이 아니면 answer 1 증가
        3-2) 잃어버린 학생이라면
            3-2-2) 앞번호가 여벌 체육복이 있는지 확인
            3-2-3) 뒷번호가 여벌 체육복이 있는지 확인
            => 체육복 빌리면 여벌 체육복 set에서 삭제하고, answer 1증가. 아니면 그냥 진행
*/

import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        Set<Integer> reserves = new HashSet<>();
        Set<Integer> losts = new HashSet<>();
        for(int N : reserve) reserves.add(N);
        for(int N : lost) {
            if(reserves.contains(N)) reserves.remove(N);
            else losts.add(N);
        }
        for(int cur=1; cur<=n; cur++){
            if(losts.contains(cur)){
                int front = cur - 1;
                int back = cur + 1;
                if(reserves.contains(front)){
                    reserves.remove(front);
                    answer ++;
                }
                else if(reserves.contains(back)){
                    reserves.remove(back);
                    answer ++;
                }
            }
            else answer++;
        }
        return answer;
    }
}