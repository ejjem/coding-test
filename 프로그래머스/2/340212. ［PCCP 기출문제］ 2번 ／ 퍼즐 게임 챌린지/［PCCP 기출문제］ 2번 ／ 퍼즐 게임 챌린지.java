/*
diff: 현재 퍼즐 난이도
time_cur: 현재 퍼즐의 소요 시간
time_prev: 이전 퍼즐의 소요 시간
level: 당신의 숙련도

if(diff <= level) time_cur 만큼만 시간을 사용
if(diff > level) diff - level 번 틀림. 틀릴때마다 time_cur만큼 시간을 추가 사용, 추가로 time_prev만큼의 시간을 사용.(고정)

*/

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = Integer.MAX_VALUE;
        int diffMax = 0;
        for(int i=0; i<diffs.length; i++){
            diffMax = Math.max(diffMax, diffs[i]);
        }
        // level의 가능한 크기: 1<= level <= diffMax까지
        int start = 1; int end = diffMax;
        int level = (start + end) / 2;
        while(start <= end){
            long total = calc(diffs, times, limit, level);
            //System.out.print("level: " + level + ". " + limit + "인데 " + total + ". ");
            if(total > limit){ // 실패, level 키우기
                //System.out.println("줄이기");
                start = level + 1;
                level = (start + end) / 2;
            }
            else{ // 성공, level 줄이기
                //System.out.println("늘리기");
                answer = Math.min(answer, level);
                end = level - 1;
                level = (start + end) / 2;
            }
            
            //System.out.println(level);
            //System.out.println("현재 최소: " + answer);
        }
        return answer;
    }
    long calc(int[] diffs, int[] times, long limit, int level){
        long totalTime = times[0];
        for(int i=1; i<diffs.length; i++){
            int diff = diffs[i];
            int time = times[i];
            if(level < diff){
                totalTime += (times[i-1] + time) * (diff - level) + time;
            }
            else{
                totalTime += time;
            }
        }
        return totalTime;
    }
    
}