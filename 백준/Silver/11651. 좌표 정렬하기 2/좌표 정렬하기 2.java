import java.io.IOException;
import java.io.*;
import java.util.*;

class Main {

    static class Point implements Comparable<Point>{
        int x;
        int y;
        Point(int x, int y){
            this.x = x; this.y = y;
        }

        @Override
        public int compareTo(Point o){
            if(this.y == o.y){
                    return Integer.compare(this.x, o.x);
            }
            return Integer.compare(this.y, o.y);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        List<Point> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Point(x, y));
        }
        br.close();
        Collections.sort(list);
        for(Point p : list){
            sb.append(p.x).append(" ").append(p.y).append("\n");
        }
        bw.write(sb.toString()); bw.flush(); bw.close();
    }
}