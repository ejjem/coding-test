import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int video = toSec(video_len);
        int cur   = toSec(pos);
        int opS   = toSec(op_start);
        int opE   = toSec(op_end);

        for (String cmd : commands) {
            // 기능 수행 직전 오프닝 스킵
            if (inOpening(cur, opS, opE)) cur = opE;

            if (cmd.equals("prev")) {
                cur = Math.max(0, cur - 10);
            } else { // "next"
                cur = Math.min(video, cur + 10);
            }

            // 기능 수행 직후 오프닝 스킵
            if (inOpening(cur, opS, opE)) cur = opE;
        }

        return toStr(cur);
    }

    private int toSec(String t) { // "mm:ss" -> sec
        int m = (t.charAt(0)-'0')*10 + (t.charAt(1)-'0');
        int s = (t.charAt(3)-'0')*10 + (t.charAt(4)-'0');
        return m*60 + s;
    }

    private String toStr(int sec) { // sec -> "mm:ss"
        int m = sec / 60;
        int s = sec % 60;
        return String.format("%02d:%02d", m, s);
    }

    private boolean inOpening(int cur, int opS, int opE) { // [opS, opE] 포함
        return opS <= cur && cur <= opE;
    }
}
