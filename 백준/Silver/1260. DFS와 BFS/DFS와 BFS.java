import java.util.*;
import java.io.*;

class Main {
    static List<List<Integer>> graph;
    static int N, M, V;
    static ArrayDeque<Integer> s;
    static ArrayDeque<Integer> q;
    static ArrayList<Integer> resultDFS;
    static void DFS(int start, boolean[] visited){
        if(!visited[start]){
             visited[start] = true;
             resultDFS.add(start);
        }
        for(int n : graph.get(start)){
            if(!visited[n]) {
                visited[n] = true;
                resultDFS.add(n);
                DFS(n, visited);
            }
        }
    }

    static ArrayList<Integer> BFS(int start){
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[N];
        visited[start] = true;
        q.offerLast(start);
        while(!q.isEmpty()){
            int tmp = q.pollFirst();
            result.add(tmp);
            for(int n : graph.get(tmp)){
                if(!visited[n]){
                    visited[n] = true;
                    q.offerLast(n);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken()); V = Integer.parseInt(st.nextToken())-1;
        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for(int i=0; i<N; i++) Collections.sort(graph.get(i));

        s = new ArrayDeque<>(); q = new ArrayDeque<>();
        boolean[] visited = new boolean[N];
        resultDFS = new ArrayList<>();
        DFS(V, visited);
        ArrayList<Integer> resultBFS = BFS(V);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<resultDFS.size(); i++){
            sb.append(resultDFS.get(i) + 1).append(" ");
        }
        sb.append("\n");
        for(int i=0; i<resultBFS.size(); i++){
            sb.append(resultBFS.get(i) + 1).append(" ");
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString()); bw.flush(); bw.close();
    }
}