import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<9;i++){
            list.add(Integer.parseInt(br.readLine()));
        }
        int maximum = Integer.MIN_VALUE;
        int index = -1;
        for(int i=0; i<9; i++){
            if(list.get(i) > maximum){
                maximum = list.get(i);
                index = i;
            }
        }
        System.out.println(maximum);
        System.out.println(index + 1);
    }
}