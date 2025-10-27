import java.io.*;
import java.util.*;

// (startday + i)%7 이 0, 6일 때는 무시 
class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int n = schedules.length; // 직원수
        for(int i=0; i<n; i++){
            //System.out.println("사람: " + i + "번째");
            int t = schedules[i];
            int t1 = t/100; int t2 = t%100 + 10;
            if(t2 >= 60){t1++; t2 -= 60;}
            int T = t1 * 100 + t2;
            int j = 0;
            for(j=0; j<7; j++){
                //System.out.println("요일: " + (startday+j));
                if( (startday+j)%7 == 0 || (startday+j)%7 == 6) continue;
                //System.out.println("출근: " + timelogs[i][j]);
                //System.out.println("기준: " + T);
                if (timelogs[i][j] > T) break; 
            }
            if(j == 7) answer ++;
        }
        System.out.println(answer);
        return answer;
    }
}