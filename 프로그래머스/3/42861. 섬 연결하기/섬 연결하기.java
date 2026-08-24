/*
    MST by Kruskal
    
    1) 간선을 오름차순으로 정렬
    2) Union-Find를 통해 같은 그룹인지 확인해가면서 진행
        2-1) 다른 그룹이면 추가
        2-2) 같은 그룹이면 건너뜀

*/


import java.util.*;

class Solution {
    static int[] parent;
    
    public static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    public static boolean union(int a, int b){
        int parentA = find(a);
        int parentB = find(b);
        
        if(parentA == parentB) return false;
        parent[parentB] = parentA;
        return true;
    }
    
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        
        Arrays.sort(costs, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return Integer.compare(a[2], b[2]);
            }
        });
        
        // Union-Find 초기화
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        
        
        for(int i=0; i<costs.length; i++){
            int[] cur = costs[i];
            if(find(cur[0]) != find(cur[1])){
                union(cur[0], cur[1]);
                answer += cur[2];
            }
        }
        
        return answer;
    }
}