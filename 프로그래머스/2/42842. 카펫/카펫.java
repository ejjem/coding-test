/*
    노랑 -> 중앙
    갈색 -> 감싸는 형태
    
    갈색 = 노랑 가로 * 2 + 노랑 세로 * 2 + 4
    노랑 가로 * 노랑 세로 = 노랑 갯수
    [갈색 가로, 갈색 세로] = [노랑 가로 + 2, 노랑 세로 + 2] 
    
    ex) 갈색 10, 노랑 2 -> 노랑 가로 2, 노랑 세로 1
    10 = 2 * 2 + 1 * 2 + 4
    
    ex) 갈색 24, 노랑 24 -> [24, 1], [12, 2], [8, 3], [6, 4] 가능
    24 = 4 * 2 + 6 * 2 + 4 => 노랑이 [4, 6]
    
*/

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for(int h=1; h<= yellow; h++){
            int w = yellow / h; 
            if(yellow % h == 0 && h <= w){
                if(brown == w * 2 + h * 2 + 4){
                    answer[0] = w + 2;
                    answer[1] = h + 2;
                    return answer;
                }
            }
        }
        return answer;
    }
}