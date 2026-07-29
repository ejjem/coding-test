import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> group = new ArrayList<>();
        int[][] sausages = new int[N][2];
        // 길이 너비 순서대로 N쌍이 나옴
        for(int i=0; i<N; i++){
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            sausages[i][0] = h;
            sausages[i][1] = w;
        }
        Arrays.sort(sausages, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]) return Integer.compare(a[1], b[1]);
                return Integer.compare(a[0], b[0]);
            }
        });
        group.add(sausages[0][1]);
        for (int i = 1; i < N; i++) {
            int curW = sausages[i][1];
            int targetIndex = -1;
            int targetWidth = -1;

            for (int j = 0; j < group.size(); j++) {
                int endWidth = group.get(j);

                if (endWidth <= curW && endWidth > targetWidth) {
                    targetWidth = endWidth;
                    targetIndex = j;
                }
            }

            if (targetIndex == -1) {
                group.add(curW);
            } else {
                group.set(targetIndex, curW);
            }
        }


        int answer = group.size();
        System.out.println(answer);
    }
}

/*
    4 9
    5 2
    2 1
    3 5
    1 4
    
    * -> (2, 1) -> (5, 2) -> * -> (1, 4) -> (3, 5) -> (4, 9)

    2분
*/

/*
    1 3
    2 2
    3 1

    * -> (1, 3) -> * -> (2, 2) -> * -> (3, 1)

    3분
*/

/*
    가장 best는 길이, 너비 모두 오름차순으로 정렬되는 것.
    근데 case1) 처럼 n개의 group으로 나눠질 수 있음.

    1. 길이 오름차순, 길이가 같으면 너비 오름차순으로 정렬 => 길이는 항상 오름차순 보장, 너비만 신경씀
    2. 너비 끝값만 


*/