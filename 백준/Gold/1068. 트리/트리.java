import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer>[] graph = new ArrayList[N];
        for(int i=0; i<N; i++) graph[i] = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = 0;
        for(int i=0; i<N; i++){
            int n = Integer.parseInt(st.nextToken());
            if(n == -1){
                root = i;
                continue;
                }
            graph[n].add(i);
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[N];
        int T = Integer.parseInt(br.readLine());
        if(root == T){
            System.out.println(0); return;
        }
        visited[T] = true;
        stack.add(T);
        while(!stack.isEmpty()){
            int cur = stack.pop();
            for(int n : graph[cur]){
                if(!visited[n]){
                    visited[n] = true;
                }
            }
        }
        //System.out.println(Arrays.toString(visited));
        visited[root] = true;
        stack.add(root);
        int cnt = 0;
        while(!stack.isEmpty()){
            int cur = stack.pop();
            //System.out.println("cur: " + cur +", size: " + graph[cur].size());
            boolean flag = false;
            for(int n : graph[cur]){
                if(!visited[n]){
                    flag = true;
                    visited[n] = true;
                    stack.add(n);
                }
            }
            if(!flag){
                cnt ++;
            }
        }
        System.out.println(cnt);
    }
}