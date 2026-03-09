import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] tang = new int[N];
        for (int i = 0; i < N; i++) {
            tang[i] = Integer.parseInt(st.nextToken());
        }

        int[] cnt = new int[10];
        int kind = 0;
        int left = 0;
        int ans = 0;

        for (int right = 0; right < N; right++) {
            int fruit = tang[right];

            if (cnt[fruit] == 0) {
                kind++;
            }
            cnt[fruit]++;

            while (kind > 2) {
                int leftFruit = tang[left];
                cnt[leftFruit]--;

                if (cnt[leftFruit] == 0) {
                    kind--;
                }
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        System.out.println(ans);
    }
}