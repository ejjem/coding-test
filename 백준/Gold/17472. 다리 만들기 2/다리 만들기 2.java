import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean isPossible(int ny, int nx){
        if(ny < 0 || ny >= N || nx < 0 || nx >= M) return false;
        return true;
    }

    static class UnionFind{
        private int[] parents;
        private int[] rank;

        UnionFind(int N){
            parents = new int[N];
            rank = new int[N];
            makeSet(N);
        }

        private void makeSet(int N){
            for(int i=0; i<N; i++){
                parents[i] = i;
                rank[i] = 0;
            }
        }

        public int findSet(int x){
            if(parents[x] != x){
                parents[x] = findSet(parents[x]);
            }

            return parents[x];
        }

        public boolean union(int a, int b){
            int rootA = findSet(a); int rootB = findSet(b);
            if(rootA == rootB) {return false;}
            else{
                if(rank[rootA] > rank[rootB]) parents[rootB] = rootA;
                else if(rank[rootA] < rank[rootB]) parents[rootA] = rootB;
                else{
                    if(rootA < rootB){
                        parents[rootB] = rootA;
                        rank[rootA] ++;
                    }
                    else{
                        parents[rootA] = rootB;
                        rank[rootB] ++;
                    }
                }
            }
            return true;
        }
    }
    static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int weight;
        Edge(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
        return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 섬 마스킹
        int ID = 1;
        visited = new boolean[N][M];
        HashMap<Integer, ArrayList<int[]>> islandData = new HashMap<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] > 0 && !visited[i][j]){
                    islandData.computeIfAbsent(ID, k -> new ArrayList<>()).add(new int[]{i, j});
                    ArrayDeque<int[]> q = new ArrayDeque<>();
                    visited[i][j] = true;
                    map[i][j] = ID;
                    q.offerLast(new int[]{i, j});
                    while(!q.isEmpty()){
                        int[] cur = q.pollFirst();
                        int y = cur[0]; int x = cur[1];
                        for(int idx=0; idx<4; idx++){
                            int ny = y + dist[idx][0];
                            int nx = x + dist[idx][1];
                            if(isPossible(ny, nx) && !visited[ny][nx] && map[ny][nx] > 0){
                                visited[ny][nx] = true;
                                map[ny][nx] = ID;
                                q.offerLast(new int[]{ny, nx});
                                islandData.get(ID).add(new int[]{ny, nx});
                            }
                        }
                    }
                    ID ++;
                }
            }
        }
        /* 
        for(int i=0; i<N; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        */
        /* 
        for(int i=1; i<ID; i++) {
            System.out.println("ID: " + i);
            for(int[] n : islandData.get(i)){
                System.out.println(Arrays.toString(n));
            }
        }
        */
        
        // edge 찾기
        ArrayList<Edge> edges = new ArrayList<>();
        for(int i=1; i<ID; i++){
            for(int[] cur : islandData.get(i)){
                // int[] cur 은 {y, x}로 각 섬 안에 있는 모든 점들
                // 이제 점들로부터 BFS 해서 다른 섬 찾기
                // 1. 같은 ID 만나면 continue
                // 2. 범위 밖 나가면 continue
                // 3. 탐색 길이 저장하면서, 2칸 이상 + 다른 ID 섬 만나면 edge로 판정
                int y = cur[0]; int x = cur[1];
                int length;
                for(int idx=0; idx<4; idx++) {
                    int dy = dist[idx][0]; int dx = dist[idx][1];
                    if(!isPossible(y+dy, x+dx)) continue;
                    if(map[y+dy][x+dx] == i) continue; // 같은 섬 방향
                    else if(map[y+dy][x+dx] == 0){
                        length = 1;
                        while(isPossible(y + length*dy, x + length*dx)) {
                                if(map[y + length*dy][x + length*dx] > 0){
                                    if(map[y + length*dy][x + length*dx] > 0 && length >= 3 && map[y + length*dy][x + length*dx] != i) {
                                    int e = map[y + length*dy][x + length*dx];
                                    edges.add(new Edge(i, e, length-1));
                                    //System.out.print("edge 생성: ");
                                    //System.out.println(i + " -> " + e + ", 길이: " + (length-1));
                                }
                                break;
                            }
                            else {
                                length ++;
                            }
                        }
                    }
                }
            }
        }        
        
        UnionFind uf = new UnionFind(ID);
        // edges 정렬
        // 쭉 돌면서 kruskal 진행
        // ID 다 돌면서, 전부 같은 parents, 즉 전부 연결되었는지 확인
        Collections.sort(edges);
        int cnt = 1;
        int answer = 0;
        for(int i=0; i<edges.size(); i++) {
            Edge cur = edges.get(i);
            if(uf.union(cur.start, cur.end)) {
                cnt ++;
                answer += cur.weight;
            }
            if(cnt == ID - 1) break;
        }
        if(cnt != ID - 1) System.out.println(-1);
        else System.out.println(answer);
    }
}