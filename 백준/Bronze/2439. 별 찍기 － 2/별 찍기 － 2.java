import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int star = 1;
        int blank = N-1;
        for(int i=0; i<N;i++){
            for(int j=0; j<blank; j++){
                System.out.print(" ");
            }
            for(int k=0; k<star; k++){
                System.out.print("*");
            }
            blank --;
            star ++;
            if(i != N-1) System.out.println(" ");
        }
    }
}
