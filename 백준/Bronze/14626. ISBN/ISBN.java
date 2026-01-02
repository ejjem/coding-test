import java.io.IOException;
import java.io.*;
import java.util.*;

/*
    1. *의 위치가 마지막 위치(체크기호) 인가 아닌가
    1-1. 체크기호일 경우 앞 수를 전부 더하고 mod가 되도록 계산
    1-2. 체크기호가 아닐 경우 체크 기호 결과를 통해 역산.
*/

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int pos = -1;
        int calc = 0;
        boolean checkmark = true;
        for(int i=0; i<str.length()-1; i++){
            char c = str.charAt(i);
            if(c == '*') {
                checkmark = false;
                pos = i;
                continue;
            }
            int n = c - '0';
            if(i % 2 == 0){
                calc += n;
            }
            else{
                calc += n*3;
            }
            //System.out.println(calc);
        }
        if(checkmark){
            //System.out.println("case 1");
            int mod = calc % 10;
            if(mod == 0){
                System.out.println(0);
            }
            else{
                System.out.println(10-mod);
            }
        }
        else{
            //System.out.println("case 2");
            int cm = str.charAt(str.length() - 1) - '0';
            int m = 1;
            if(pos % 2 != 0) m = 3;
            int answer = 0;
            //System.out.println(cm);
            //System.out.println(m);
            //System.out.println(calc);
            for(int i=0; i<10; i++){
                if( (cm + calc + i * m) % 10 == 0){
                    answer = i;
                    break;
                }
            }
            System.out.println(answer);
        }
    }
}