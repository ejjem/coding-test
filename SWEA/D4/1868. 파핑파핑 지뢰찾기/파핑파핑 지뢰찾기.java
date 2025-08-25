import java.io.*;
import java.util.*;

public class Solution {
    static final int[] dy = {-1,-1,-1, 0, 0, 1, 1, 1};
    static final int[] dx = {-1, 0, 1,-1, 1,-1, 0, 1};

    static class DSU {
        int[] parent, rank;
        DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        int find(int x){
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
        void union(int a, int b){
            int ra = find(a), rb = find(b);
            if (ra == rb) return;
            if (rank[ra] < rank[rb]) parent[ra] = rb;
            else if (rank[ra] > rank[rb]) parent[rb] = ra;
            else { parent[rb] = ra; rank[ra]++; }
        }
    }

    static int N;
    static char[][] board;
    static int[][] adjMine;
    static boolean[][] isZero, revealed;

    static boolean inRange(int y, int x){
        return 0 <= y && y < N && 0 <= x && x < N;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine().trim());
            board = new char[N][N];
            for (int i = 0; i < N; i++) {
                String line = br.readLine().trim();
                board[i] = line.toCharArray();
            }

            adjMine = new int[N][N];
            isZero = new boolean[N][N];
            revealed = new boolean[N][N];

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    if (board[y][x] == '*') continue;
                    int cnt = 0;
                    for (int d = 0; d < 8; d++) {
                        int ny = y + dy[d], nx = x + dx[d];
                        if (inRange(ny, nx) && board[ny][nx] == '*') cnt++;
                    }
                    adjMine[y][x] = cnt;
                    isZero[y][x] = (cnt == 0);
                }
            }

            int total = N * N;
            DSU dsu = new DSU(total);

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    if (board[y][x] == '*' || !isZero[y][x]) continue;
                    int id = y * N + x;
                    for (int d = 0; d < 8; d++) {
                        int ny = y + dy[d], nx = x + dx[d];
                        if (!inRange(ny, nx)) continue;
                        if (board[ny][nx] == '*' || !isZero[ny][nx]) continue;
                        int nid = ny * N + nx;
                        dsu.union(id, nid);
                    }
                }
            }

            HashMap<Integer, ArrayList<Integer>> bucket = new HashMap<>();
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    if (board[y][x] == '*' || !isZero[y][x]) continue;
                    int id = y * N + x;
                    int root = dsu.find(id);
                    bucket.computeIfAbsent(root, k -> new ArrayList<>()).add(id);
                }
            }

            int zeroRegions = bucket.size();
            for (ArrayList<Integer> members : bucket.values()) {
                for (int id : members) {
                    int y = id / N, x = id % N;
                    revealed[y][x] = true;
                    for (int d = 0; d < 8; d++) {
                        int ny = y + dy[d], nx = x + dx[d];
                        if (inRange(ny, nx) && board[ny][nx] != '*') {
                            revealed[ny][nx] = true;
                        }
                    }
                }
            }

            int remainSingles = 0;
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    if (board[y][x] == '*') continue;
                    if (!revealed[y][x]) remainSingles++;
                }
            }

            int answer = zeroRegions + remainSingles;
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }
}
