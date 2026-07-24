
import java.io.*;
import java.util.*;
class Solution {
    
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> p2g = new HashMap<>();
        for(int i=0; i<players.length; i++){
            String s = players[i];
            p2g.put(s, i);
        }
        for(String player1 : callings){
            
            int grade1 = p2g.get(player1);
            int grade2 = grade1 - 1;
            String player2 = players[grade2]; 
            // grade랑 grade - 1이랑 교체
            players[grade2] = player1;
            players[grade1] = player2;
            
            // map도 갱신
            p2g.put(player1, grade2);
            p2g.put(player2, grade1);
        }    
        
        return players;
    }
}