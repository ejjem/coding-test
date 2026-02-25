import java.io.*;
import java.util.*;

/*
    숫자열이 알파벳보다 앞에 옴
    알파벳 정렬 순서:  AaBbCc...XxYyZz
    숫자열끼리는 십진법으로
    문자열을 비교하는 중 숫자가 있으면 다음 문자 전까지 숫자를 십진법으로 묶음
    같은 값을 가지는 숫자열일 경우 앞에 따라붙는 0의 개수가 적은 것이 앞에 온다.

    비교 과정
    길이가 더 작은걸 기준으로 순회
    0) 진행하면서 숫자가 등장하면 그때부터 담기 시작
    1) 둘이 같은 글자면 진행.
    2) 다른 글자가 나오면 비교
    2-1) 알파벳이면 그 당시에 알파벳 기준으로 비교
    2-2) 숫자면 그때 더 큰거로
    
    A: 65, Z: 90
    a: 97, z: 122
    a - A -> 32

*/


class Main {

    static boolean isAlpha(char c){
        return ('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z');
    }
    static boolean isDigit(char c){
        return ('0' <= c && c <= '9');
    }

    static int compareAlpha(char c1, char c2){
        char l1 = Character.toLowerCase(c1);
        char l2 = Character.toLowerCase(c2);
        if(l1 != l2) return l1 - l2;
        boolean u1 = Character.isUpperCase(c1);
        boolean u2 = Character.isUpperCase(c2);
        if(u1 == u2) return 0;
        return u1 ? -1 : 1;
    }

    static int compareNumber(String a, int i, String b, int j, int[] out){
        int i0 = i, j0 = j;
        while(i < a.length() && isDigit(a.charAt(i))) i++;
        while(j < b.length() && isDigit(b.charAt(j))) j++;

        String ra = a.substring(i0, i);
        String rb = b.substring(j0, j);

        int pa = 0; while(pa < ra.length() && ra.charAt(pa) == '0') pa++;
        int pb = 0; while(pb < rb.length() && rb.charAt(pb) == '0') pb++;
        String sa = ra.substring(pa);
        String sb = rb.substring(pb);

        int cmp;
        if(sa.length() != sb.length()) cmp = sa.length() - sb.length();
        else cmp = sa.compareTo(sb);

        if(cmp != 0){
            out[0] = i; out[1] = j;
            return cmp;
        }

        // 값이 같으면 원본 길이 짧은 게 먼저
        if(ra.length() != rb.length()){
            out[0] = i; out[1] = j;
            return ra.length() - rb.length();
        }

        out[0] = i; out[1] = j;
        return 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for(int i=0; i<N; i++) arr[i] = br.readLine();

        Arrays.sort(arr, (a, b) -> {
            int c1Index = 0, c2Index = 0;
            int[] out = new int[2];

            while(c1Index < a.length() && c2Index < b.length()){
                char c1 = a.charAt(c1Index);
                char c2 = b.charAt(c2Index);

                boolean d1 = isDigit(c1);
                boolean d2 = isDigit(c2);

                // 둘 다 숫자면
                if(d1 && d2){
                    int r = compareNumber(a, c1Index, b, c2Index, out);
                    c1Index = out[0];
                    c2Index = out[1];
                    if(r != 0) return r;
                    continue;
                }

                // 하나만 숫자면
                if(d1 != d2){
                    return d1 ? -1 : 1;
                }

                // 둘 다 알파벳
                int r = compareAlpha(c1, c2);
                if(r != 0) return r;

                c1Index++;
                c2Index++;
            }

            return a.length() - b.length();
        });

        StringBuilder sb = new StringBuilder();
        for(String s : arr) sb.append(s).append('\n');
        bw.write(sb.toString());
        bw.flush();
    }
}