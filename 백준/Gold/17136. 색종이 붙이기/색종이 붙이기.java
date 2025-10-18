import java.io.*;
import java.util.*;

class Main {
    static int[][] board = new int[10][10];
    static int[] paper = new int[6];        
    static ArrayList<int[]> target = new ArrayList<>(); 
    static Map<Integer, Integer> t2c = new HashMap<>(); 
    static boolean[] covered;                
    static int cnt;                          
    static int best = Integer.MAX_VALUE;     

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 1; i <= 5; i++) paper[i] = 5; 

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    target.add(new int[]{i, j});
                }
            }
        }
        cnt = target.size();
        covered = new boolean[cnt];

        for (int i = 0; i < cnt; i++) {
            int[] cur = target.get(i);
            t2c.put(cur[0] * 10 + cur[1], i);
        }

        dfs(0);

        System.out.println(best == Integer.MAX_VALUE ? -1 : best);
    }

    static void dfs(int used) {
        if (used >= best) return;

        int idx = nextUncoveredIndex();
        if (idx == -1) {
            best = Math.min(best, used);
            return;
        }

        int y = target.get(idx)[0];
        int x = target.get(idx)[1];

        for (int len = 5; len >= 1; len--) {
            if (paper[len] == 0) continue;
            if (!canPlace(y, x, len)) continue;
            List<Integer> changed = coverSquare(y, x, len);
            paper[len]--;
            dfs(used + 1);
            paper[len]++;
            undoCover(changed);
        }
    }
    static int nextUncoveredIndex() {
        for (int i = 0; i < cnt; i++) {
            if (!covered[i]) return i;
        }
        return -1;
    }

    static boolean canPlace(int y, int x, int len) {
        if (y + len > 10 || x + len > 10) return false;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int ny = y + i, nx = x + j;
                if (board[ny][nx] != 1) return false;
                if (covered[t2c.get(ny * 10 + nx)]) return false;
            }
        }
        return true;
    }

    static List<Integer> coverSquare(int y, int x, int len) {
        List<Integer> changed = new ArrayList<>(len * len);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int ny = y + i, nx = x + j;
                int idx = t2c.get(ny * 10 + nx);
                covered[idx] = true;
                changed.add(idx);
            }
        }
        return changed;
    }

    static void undoCover(List<Integer> changed) {
        for (int idx : changed) covered[idx] = false;
    }
}