import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine().trim());

        int stick = 64;
        int sum = 64;
        int count = 1;

        while (sum != x) {
            stick /= 2; 
            if (sum - stick >= x) {
                sum -= stick;
                count--;
            }
            count++;
        }

        System.out.println(count);
    }
}