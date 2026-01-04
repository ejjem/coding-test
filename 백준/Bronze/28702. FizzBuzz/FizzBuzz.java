import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = -1;
        int number = -1;
        for(int i=0; i<3; i++){
            String tmp = br.readLine();
            if(!tmp.equals("Fizz") && !tmp.equals("Buzz") && !tmp.equals("FizzBuzz")){
                n = i;     
                number = Integer.parseInt(tmp);
            }
        }
        if(n != -1){
            number += 3 - n;
            if(number % 3 == 0 && number % 5 == 0){
                System.out.println("FizzBuzz");
            }
            else if(number % 3 == 0){
                System.out.println("Fizz");
            }
            else if(number % 5 == 0){
                System.out.println("Buzz");
            }
            else System.out.println(number);
        }
    }
}