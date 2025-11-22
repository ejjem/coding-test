import java.io.IOException;
import java.io.*;
import java.util.*;


class Main {
    public static class User{
        int idx;
        int num;
        String name;
        User(int idx, int num, String name){
            this.idx = idx;
            this.num = num;
            this.name = name;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<User> pq = new PriorityQueue<>(new Comparator<User>(){
            @Override
            public int compare(User a, User b){
                if(a.num == b.num) return Integer.compare(a.idx, b.idx);
                return Integer.compare(a.num, b.num);
            }
        });
        for(int tc = 0; tc < N; tc++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            pq.offer(new User(tc, num, name));
        }
        for(int tc = 0; tc < N; tc++){
            User u = pq.poll();
            sb.append(u.num).append(" ").append(u.name).append("\n");
        }
        bw.write(sb.toString()); bw.flush(); bw.close();
    }
}