class Solution {
    private long toSec(int h, int m, int s) {
        return 3600L * h + 60L * m + s;
    }

    private long F(long t) {
        return (59L * t) / 3600L      // floor(59t/3600)
             + (719L * t) / 43200L    // floor(719t/43200)
             - (t / 43200L);          // floor(t/43200)  (트리플 보정)
    }

    // 정확히 t초 시각에 겹침 여부 (정수 모듈러)
    private int hitsAt(long t) {
        int sm = ((59L * t) % 3600L == 0L) ? 1 : 0;     // 초-분
        int sh = ((719L * t) % 43200L == 0L) ? 1 : 0;   // 초-시
        int tri = (t % 43200L == 0L) ? 1 : 0;           // 세 바늘
        return sm + sh - tri; // 트리플은 1회로 보정
    }

    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        long t1 = toSec(h1, m1, s1);
        long t2 = toSec(h2, m2, s2);

        // (필요시) 끝이 시작보다 이르면 다음날로 간주
        if (t2 < t1) t2 += 24L * 3600L;

        long base = F(t2) - F(t1);
        long addStart = hitsAt(t1);   // 시작 시각이 겹치면 포함
        return (int)(base + addStart);
    }
}
