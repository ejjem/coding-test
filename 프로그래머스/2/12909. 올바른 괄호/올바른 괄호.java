import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<Character> queue = new ArrayDeque<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                queue.offerLast('(');
            }
            else{
                if(queue.isEmpty() || queue.pollLast() != '(') return false;
            }
        }
        if(queue.isEmpty()) return true;
        return false;
    }
}