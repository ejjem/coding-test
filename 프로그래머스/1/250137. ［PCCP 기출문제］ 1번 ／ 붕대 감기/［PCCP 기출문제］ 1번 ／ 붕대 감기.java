

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int time = 0; // 시간
        int healing_time = bandage[0]; // 시전 시간
        int healing_per = bandage[1]; // 초당 회복량
        int healing_add = bandage[2]; // 추가 회복량
        int continueous = 0; // 연속 회복 시간
        int pos = health; // 현재 체력량
        
        for(int[] attack : attacks){
            int attack_time = attack[0];
            int attack_dagame = attack[1];
            while(time != attack_time){ // 공격 안 맞을 때
                continueous ++;
                pos += healing_per;
                if(continueous == healing_time) {
                    pos += healing_add;
                    continueous = 0;
                }
                if(pos > health) pos = health;
                //System.out.println("시간: " + time + ", 체력: " + pos);
                time ++;
            }
            // 공격 맞을 때
            continueous = 0;
            pos -= attack_dagame;
            if(pos <= 0){
                return -1;
            }
            //System.out.println("시간: " + time + ", 체력: " + pos);
            time ++;
        }
        int answer = pos;
        return answer;
    }
}