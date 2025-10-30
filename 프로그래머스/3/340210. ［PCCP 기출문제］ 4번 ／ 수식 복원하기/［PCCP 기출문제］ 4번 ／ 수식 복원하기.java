import java.util.*;
class Solution {
    
    public void checkPossible(String[][] exps, boolean[] possible){
        for(String[] exp : exps){
            String str1 = exp[0];
            String str2 = exp[2];
            String str3 = exp[4];
            for(int i=2; i<=9; i++){
                String tmp = Integer.toString(i);
                if(str1.contains(tmp) || str2.contains(tmp) ||
                   str3.contains(tmp)) {
                    for(int j=0; j<=i; j++){
                        possible[j] = false;    
                    }
                }
            }
        }
    }
    
    public String[] solution(String[] expressions) {
        boolean[] possible = new boolean[10];
        Arrays.fill(possible, true); possible[0] = false; possible[1] = false;
        ArrayList<Integer> comExp = new ArrayList<>();
        ArrayList<Integer> question = new ArrayList<>();
        String[][] exps = new String[expressions.length][5];
        for(int i=0; i<expressions.length; i++){
            exps[i] = expressions[i].split(" ");
            if(!exps[i][4].equals("X")) comExp.add(i);
            else question.add(i);
        }
        String[] answer = new String[question.size()];
        checkPossible(exps, possible);
        //가능한거 찾기
        for(int i=2; i<=9; i++){
            if(!possible[i]) continue;
            for(int n : comExp){
                String[] str = exps[n];
                //System.out.println(n);
                //System.out.println(Arrays.toString(str));
                //System.out.println("진법: " + i);
                int a = Integer.parseInt(str[0], i);
                int b = Integer.parseInt(str[2], i);
                int c = Integer.parseInt(str[4], i);
                //System.out.println(a);
                //System.out.println(b);
                //System.out.println(c);
                switch(str[1]){
                    case "+":
                        if( a + b != c) {possible[i] = false; break;}
                        break;
                    case "-":
                        if( a - b != c) {possible[i] = false; break;}
                        break;
                }
            }
        }
        int radix = -1;
        boolean flag = true;
        
        for(int i=2; i<= 9; i++){
            if(!possible[i]) continue;
            if(radix == -1) radix = i;
            else flag = false;
        }
        System.out.println(radix);
        if(flag){
            for(int n : question){
                String[] str = exps[n];
                int a = Integer.parseInt(str[0], radix);
                int b = Integer.parseInt(str[2], radix);
                int c = 0;
                switch(exps[n][1]){
                        case "+":
                            c = a + b;
                            break;
                    case "-":
                            c = a - b;
                            break;
                }
                str[4] = Integer.toString(c, radix);
            }
        }
        else{
            // 후보 진법들 수집
    ArrayList<Integer> bases = new ArrayList<>();
    for (int i = 2; i <= 9; i++) if (possible[i]) bases.add(i);

    for (int n : question) {
        String[] str = exps[n]; // [피연산자1, 연산자, 피연산자2, "=", "X"]
        String same = null;
        boolean ambiguous = false;

        for (int base : bases) {
            int a, b, c;
            try {
                a = Integer.parseInt(str[0], base);
                b = Integer.parseInt(str[2], base);
            } catch (Exception e) {
                continue;
            }

            if (str[1].equals("+")) c = a + b;
            else          c = a - b;

            String cand = Integer.toString(c, base); 

            if (same == null) same = cand;
            else if (!same.equals(cand)) {
                ambiguous = true;   
                break;
            }
        }
        exps[n][4] = (ambiguous || same == null) ? "?" : same;
    }
        }
        for(int i=0; i<question.size(); i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<=4; j++){
                sb.append(exps[question.get(i)][j]);
                if(j != 4) sb.append(" ");
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}