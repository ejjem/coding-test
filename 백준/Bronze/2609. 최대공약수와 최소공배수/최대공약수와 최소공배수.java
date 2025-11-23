import java.io.IOException;
import java.io.*;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int mini = Math.min(a, b) + 1;
        int maxi = Math.max(a, b) - 1;
        boolean flag1 = false;
        boolean flag2 = false;
        while(!flag1 || !flag2){
            if(!flag1){
                mini--;
                if(a % mini == 0 && b % mini == 0){
                    flag1 = true;
                }
            }
            if(!flag2){
                maxi++;
                if(maxi % a == 0 && maxi % b == 0){
                    flag2 = true;
                }
            }
        }
        System.out.println(mini);
        System.out.println(maxi);
    }
}