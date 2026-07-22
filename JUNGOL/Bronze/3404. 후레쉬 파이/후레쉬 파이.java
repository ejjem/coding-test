import java.io.*;
import java.util.*;

/*
    딸기 1, 포도알 3, 라즈베리 4, 밀가루 100 -> k원

*/

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ingredients = new int[4];
        int[] need = {1, 3, 4, 100};
        for(int i=0; i<4; i++){
            ingredients[i] = Integer.parseInt(st.nextToken());
        }
        int k = Integer.parseInt(br.readLine());
        int count = 0;
        while(true){
            boolean possible = true;
            for(int i=0; i<4; i++){
                if(need[i] * (count+1) > ingredients[i]){
                    possible = false;
                    break;
                }
            }
            if(!possible) break;
            count ++;
        }
        System.out.println(count * k);

    }
}