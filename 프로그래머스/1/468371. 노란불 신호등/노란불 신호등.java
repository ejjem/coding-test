class Solution {
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

    public int solution(int[][] signals) {
        int answer = -1;
        int n = signals.length;
        
        int[] state = new int[n];
        int[] changeTime = new int[n];
        for(int i=0; i<n; i++){
            changeTime[i] = signals[i][0];
        }
        int limit = 1;
        for(int i = 0; i < n; i++) {
            int total = signals[i][0] + signals[i][1] + signals[i][2];
            limit = lcm(limit, total);
        }
        for (int time = 1; time <= limit; time++){
            for(int i=0; i<n; i++){
                if(time - 1 == changeTime[i]){
                    state[i] = (state[i] + 1) % 3;
                    changeTime[i] += signals[i][state[i]];
                }    
            }
            
            //출력
            /*
            System.out.println(time + "초");
            for(int i=0; i<n; i++){
                System.out.println(i + "번 신호등: " + state[i]);
            }
            */
            boolean check = true;
            for(int i=0; i<n; i++){
                if(state[i] != 1){
                    check = false;
                    break;
                }
            }
            if(check) return time;
        }
        return -1;
    }
}
