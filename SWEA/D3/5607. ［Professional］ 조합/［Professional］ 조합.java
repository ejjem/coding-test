import java.io.*;
import java.util.*;

public class Solution {

    static final long MOD = 1234567891L;
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

    static void buildFactorials(int nMax) {
        fact = new long[nMax + 1];
        invFact = new long[nMax + 1];

        fact[0] = 1L;
        for (int i = 1; i <= nMax; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        invFact[nMax] = modPow(fact[nMax], MOD - 2); // Fermat inverse
        for (int i = nMax; i >= 1; i--) {
            invFact[i - 1] = (invFact[i] * i) % MOD;
        }
    }

    static long nCr(int n, int r) {
        if (r < 0 || r > n) return 0L;
        return (((fact[n] * invFact[r]) % MOD) * invFact[n - r]) % MOD;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        int[] Ns = new int[T];
        int[] Rs = new int[T];

        int nMax = 0;
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            Ns[tc] = n; Rs[tc] = r;
            if (n > nMax) nMax = n;
        }

        buildFactorials(nMax);

        for (int tc = 0; tc < T; tc++) {
            long ans = nCr(Ns[tc], Rs[tc]);
            sb.append('#').append(tc + 1).append(' ').append(ans).append('\n');
        }

        System.out.print(sb.toString());
    }
}