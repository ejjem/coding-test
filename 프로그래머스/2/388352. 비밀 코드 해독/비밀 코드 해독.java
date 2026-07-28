/*
    1부터 n까지의 서로 다른 정수 5개가 오름차순으로 정렬된 비밀 코드
    
    숫자야구 룰
    
    [완탐하면서 조건에 맞는지 확인]
    최대 30C5 * 10 * 5
    (30 * 29 * 28 * 27 *  26) / (5 * 4 * 3 * 2 * 1) = 142506
    142506 * 10 * 5= 7125300
    
    충분한데
    
    1. q 내용은 많아야 10개니까 전부 set으로 저장
    2. 완탐하면서 30C5, 즉 오름차순으로 5개의 숫자 조합 만들고 순환하면서 set과 겹치는게 몇 개인지 세면서 확인
    
*/

import java.io.*;
import java.util.*;

class Solution {
    
    static boolean check(int[] list, Set<Integer>[] setList, int[] ans){
        int m = ans.length;
        for(int i=0; i<m; i++){
            int count = 0;
            for(int idx=0; idx<5; idx++){
                int target = list[idx];
                if(setList[i].contains(target)) count++;
            }
            if(count != ans[i]) return false;
        }
        
        return true;
    }
    
    static int search(int[] cur, Set<Integer>[] setList, int[] ans, int n){
        int cnt = 0;
        for(int i=1; i<=n; i++){
            cur[0] = i;
            cnt += calculate(cur, setList, ans, 1, i+1, n);
        }
        
        return cnt;
    }
    
    static int calculate(int[] cur, Set<Integer>[] setList, int[] ans, int idx, int num, int n){
        // 다 완성되면 check 돌려서 갯수 카운팅
        if(idx == 5){
            if(check(cur, setList, ans)) return 1;
            else return 0;
        }
        int cnt = 0;
        // 반복하면서 cur 완성
        for(int i=num; i<=n; i++){
            cur[idx] = i;
            cnt += calculate(cur, setList, ans, idx+1, i+1, n);
        }
        return cnt;
    }
    
    
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        int m = ans.length;
        Set<Integer>[] setList = new HashSet[m];
        
        // 시도 set 만들기
        for(int i=0; i<m; i++){
            setList[i] = new HashSet<>();
            int[] cur = q[i];
            for(int j=0; j<5; j++){
                setList[i].add(cur[j]);
            }
        }
        
        int[] target = new int[5];
        
        answer = search(target, setList, ans, n);
        
        return answer;
    }
}