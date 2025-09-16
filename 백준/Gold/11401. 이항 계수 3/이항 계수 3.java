import java.io.*;
import java.util.*;
public class Main {
    static final long MOD = 1_000_000_007L;
    static long[] fact, invFact;

    static long modPow(long a, long e) {
        long r = 1L;
        while (e > 0) {
            if ((e & 1L) == 1L) r = (r * a) % MOD;
            a = (a * a) % MOD;
            e >>= 1;
        }
        return r;
    }

    static void build(int n) {
        fact = new long[n + 1];
        invFact = new long[n + 1];
        fact[0] = 1L;
        for (int i = 1; i <= n; i++) fact[i] = (fact[i - 1] * i) % MOD;
        invFact[n] = modPow(fact[n], MOD - 2);
        for (int i = n; i >= 1; i--) invFact[i - 1] = (invFact[i] * i) % MOD;
    }

    static long nCr(int n, int r) {
        if (r < 0 || r > n) return 0L;
        return (((fact[n] * invFact[r]) % MOD) * invFact[n - r]) % MOD;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        build(n);
        System.out.println(nCr(n, r));
    }
}