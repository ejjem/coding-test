class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        while(Math.min(wallet[0], wallet[1]) < Math.min(bill[0], bill[1]) || // bill의 작은 값이 wallet의 작은 값 보다 크거나
              Math.max(wallet[0], wallet[1]) < Math.max(bill[0], bill[1])){ // bill의 큰 값이 wallet의 큰 값 보다 큰 동안
            if(bill[0] > bill[1]) bill[0] = bill[0] / 2;
            else bill[1] = bill[1] / 2;
            answer ++;
        }
        return answer;
    }
}