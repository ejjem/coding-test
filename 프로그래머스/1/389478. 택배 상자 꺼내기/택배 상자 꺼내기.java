import java.io.*;
import java.util.*;

//22, 6, 8
class Solution {
    public int solution(int n, int w, int num) {
        int r = 0;
        int c = 0;
        int h = 0;
        if(n%w == 0) h = n/w;
        else h = n/w + 1;
        
        // h=4, w = 6
        int[][] boxes = new int[h][w];
        for(int i=0; i<h; i++){
            Arrays.fill(boxes[i], -1);
        }
        int cnt = 1;
        int flag = 1;
        for(int i=h-1; i>=0; i--){
            if(flag == 1){ // ->  
                for(int j=0; j<w; j++){
                    if(cnt <= n) boxes[i][j] = cnt;
                    if(cnt == num){r = i; c =j;}
                    cnt ++;
                }
            }
            else{ // <-
                for(int j=w-1; j>=0; j--){
                    if(cnt <= n) boxes[i][j] = cnt;
                    if(cnt == num){r = i; c =j;}
                    cnt++;
                }
            }
            flag *= -1;
        }
        /*
        for(int i=0; i<h; i++){
            System.out.println(Arrays.toString(boxes[i]));
        }
        */
        int answer = 0;
        for(int i=r; i>=0; i--){
            if(boxes[i][c] != -1) answer ++;
        }
        System.out.println(answer);
        return answer;
    }
}
