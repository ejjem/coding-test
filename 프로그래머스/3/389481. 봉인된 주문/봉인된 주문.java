import java.util.*;

class Solution {
    
    char[] alp = new char[26];
    Map<Character, Integer> indexes = new HashMap<>();
    PriorityQueue<Long> pq = new PriorityQueue<>();
    
    public String solution(long n, String[] bans) {
        //26진수
        String answer = "";
        
        char start = 'a'; // 97
        
        for(int i = start; i < start + 26; i++){
            alp[i - start] = (char) i;
            indexes.put( (char) i, i - start);
        }
        
        for(String spell : bans){
            pq.add(getIndex(spell));
        }
        
        while(!pq.isEmpty() && pq.peek() <= n){
            n++;
            pq.poll();
        }
        
        return getSpell(n);
    }
    
    long getIndex(String spell){
        long index = 0L;
        int length = spell.length();
        
        for(int i = 0; i < length; i++){
            index += (long) Math.pow(26, length - (i + 1)) * (indexes.get(spell.charAt(i)) + 1);
            
        }
        
        return index;
    }
    
    String getSpell(long index){
        StringBuilder sb = new StringBuilder();
        index--;
        
        while(index >= 0){            
            int mod = (int) (index % 26);
            
            index /= 26;
            // 알파벳은 0-index를 사용하고 있으므로 -1
            index--;
            sb.append(alp[mod]);
        }
        
        sb.reverse();
        
        return sb.toString();
    }
}