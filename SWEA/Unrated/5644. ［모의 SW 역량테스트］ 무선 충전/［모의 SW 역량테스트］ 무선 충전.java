import java.util.*;
import java.io.*;

class Point {
    int r;
    int c;
    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Charger {
    Point pos;
    int coverage;
    int power;
    public Charger(int y, int x, int coverage, int power) {
        this.pos = new Point(y, x);
        this.coverage = coverage;
        this.power = power;
    }
}

public class Solution {

    static ArrayList<Charger>[][] board;
    static int[] dr = {0, -1, 0, 1, 0};
    static int[] dc = {0, 0, 1, 0, -1};
    static int total;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
            total = 0;

            board = new ArrayList[10][10];
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    board[i][j] = new ArrayList<>();
                }
            }

            st = new StringTokenizer(in.readLine());
            int moveCount = Integer.parseInt(st.nextToken());
            int chargerCount = Integer.parseInt(st.nextToken());

            int[] moveA = new int[moveCount];
            int[] moveB = new int[moveCount];

            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < moveCount; i++) {
                moveA[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < moveCount; i++) {
                moveB[i] = Integer.parseInt(st.nextToken());
            }

            Charger[] chargers = new Charger[chargerCount];
            for (int i = 0; i < chargerCount; i++) {
                st = new StringTokenizer(in.readLine());
                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;
                int cov = Integer.parseInt(st.nextToken());
                int pow = Integer.parseInt(st.nextToken());
                chargers[i] = new Charger(y, x, cov, pow);
                spread(chargers[i]);
            }

            Point posA = new Point(0, 0);
            Point posB = new Point(9, 9);

            charge(posA, posB);

            for (int i = 0; i < moveCount; i++) {
                posA.r += dr[moveA[i]];
                posA.c += dc[moveA[i]];
                posB.r += dr[moveB[i]];
                posB.c += dc[moveB[i]];
                charge(posA, posB);
            }

            out.append("#").append(tc).append(" ").append(total).append("\n");
        }
        System.out.print(out);
    }

    static void spread(Charger ch) {
        int[][] visited = new int[10][10];
        ArrayDeque<Point> q = new ArrayDeque<>();
        visited[ch.pos.r][ch.pos.c] = 1;
        board[ch.pos.r][ch.pos.c].add(ch);
        q.addLast(new Point(ch.pos.r, ch.pos.c));

        while (!q.isEmpty()) {
            Point cur = q.pollFirst();
            for (int d = 1; d <= 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                if (nr < 0 || nr >= 10 || nc < 0 || nc >= 10) continue;
                if (visited[nr][nc] == 0) {
                    visited[nr][nc] = visited[cur.r][cur.c] + 1;
                    board[nr][nc].add(ch);
                    if (visited[nr][nc] <= ch.coverage) {
                        q.addLast(new Point(nr, nc));
                    }
                }
            }
        }
    }

    static void charge(Point a, Point b) {
        ArrayList<Charger> listA = board[a.r][a.c];
        ArrayList<Charger> listB = board[b.r][b.c];
        int best = 0;

        if (listA.isEmpty() && listB.isEmpty()) return;
        else if (listA.isEmpty()) {
            for (Charger cb : listB) {
                best = Math.max(best, cb.power);
            }
        } else if (listB.isEmpty()) {
            for (Charger ca : listA) {
                best = Math.max(best, ca.power);
            }
        } else {
            for (Charger ca : listA) {
                for (Charger cb : listB) {
                    if (ca == cb) {
                        best = Math.max(best, (ca.power + cb.power) / 2);
                    } else {
                        best = Math.max(best, ca.power + cb.power);
                    }
                }
            }
        }
        total += best;
    }
}
