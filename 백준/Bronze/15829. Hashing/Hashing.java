import java.io.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int hash = 0;
        for(int i=0; i<n; i++){
            char c = str.charAt(i);
            int tmp = c - 'a' + 1;
            hash += tmp * (int)Math.pow(31, i) % 1234567891;
        }
        System.out.println(hash%1234567891);
    }
}