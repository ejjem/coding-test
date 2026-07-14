/*
    1) message 전체를 char[]에 넣고 관리한다 -> 최대 20,000 길이 char가 생기는데 괜찮을까
    2) message를 split()을 통해 String[]로 만들고선 단어 별 길이를 계산하면서 idx 계산
    => 2가 복잡하기는 한데 안전할듯. 2로 해보자. 
    
    탐색의 기준은 String[]으로 잡고, 스포 방지 구간을 넘어가면 다음 스포 방지 구간을 꺼내는 식으로 해야할듯.
    
    스포 구간에 들어가지 않은 단어들 -> nonSpo set에 넣어서 관리
    스포 구간 내 단어들 -> spo set에 넣어서 관리
    
    탐색이 끝난 이후, spo set 안에 있는 단어들 중 nonSpo set에 없는 단어들만 갯수 카운팅
*/


import java.util.*;
class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;
        int n = spoiler_ranges.length; // 스포 방지 구간 갯수
        String[] messageSplit = message.split(" ");
        int cnt = messageSplit.length; // 단어의 갯수
        
        int spoIdx = 0;
        int idx = 0;
        HashSet<String> nonSpo = new HashSet<>();
        HashSet<String> spo = new HashSet<>();
        int start = spoiler_ranges[0][0];
        int end = spoiler_ranges[0][1];
        
        for(int i=0; i<cnt; i++){
            String word = messageSplit[i];
            int len = word.length();
            // 현재 보고 있는 단어의 idx는 idx ~ idx + len - 1
            int wordStart = idx;
            int wordEnd = idx + len - 1;
            
            // 구간 갱신
            while(spoIdx < n && end < wordStart){
                spoIdx += 1;
                if(spoIdx < n){
                    start = spoiler_ranges[spoIdx][0];
                    end = spoiler_ranges[spoIdx][1];
                }    
            }
            
            // 현재 해당 단어가 인덱스 구간에 걸리는지 확인
            // if (wordStart <= end && start <= wordEnd){
            if( !(start > wordEnd) && !(end < wordStart)){
                // 걸리면 단어 넣기
                spo.add(word);
            }
            else{
                // 안 걸리면 다음 단어로
                nonSpo.add(word);
            }
            idx = wordEnd + 2;
        }
        // spo 안에 nonSpo 에 없는 단어 갯수 확인
        for(String s : spo){
            if(!nonSpo.contains(s)) answer += 1;
        }
        
        return answer;
    }
}