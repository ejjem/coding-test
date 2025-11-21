import java.io.*;
class Main {
    static long MOD = 1234567891;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        long hash = 0;
        long pow = 1;
        for(int i=0; i<n; i++){
            char c = str.charAt(i);
            long tmp = c - 'a' + 1;
            hash += tmp*pow % MOD;
            pow = pow * 31 % MOD; 
        }
        System.out.println(hash%MOD);
    }
}