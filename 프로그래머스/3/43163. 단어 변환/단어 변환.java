/*
  글자마다 한 글자씩 바꿔가면서, words 안에 있는지 탐색 -> 있으면 횟수 기록하면서 queue에 넣기
  이렇게 bfs 진행하면서 target 나오면 종료
  이렇게 하면 단어 길이 * 25번인건가 매 탐색마다
*/

import java.util.*;
class Solution {
    static Set<String> wordSet;
    public static class WordClass{
        String word;
        int count;
        WordClass(String word, int count){
            this.word = word;
            this.count = count;
        }
    }
    
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        wordSet = new HashSet<>();
        for(String s : words){
            wordSet.add(s);
        }
        if(!wordSet.contains(target)) return 0;
        
        
        Deque<WordClass> queue = new ArrayDeque<>();
        queue.offerLast(new WordClass(begin, 0));
        
        while(!queue.isEmpty()){
            WordClass cur = queue.pollFirst();
            String str = cur.word;
            int cnt = cur.count;
            if(str.equals(target)){
                answer = cnt;
                break;
            }
            char[] currentChar = str.toCharArray();
            
            for(int i=0; i<currentChar.length; i++){
                for(char c='a'; c<='z'; c++){
                    char origin = currentChar[i];
                    if(currentChar[i] == c) continue;
                    currentChar[i] = c;
                    String newStr = new String(currentChar);
                    if(wordSet.contains(newStr)){
                        wordSet.remove(newStr);
                        queue.offerLast(new WordClass(newStr, cnt + 1));
                    }
                    currentChar[i] = origin;
                }
            }
        }
        return answer;
    }
}