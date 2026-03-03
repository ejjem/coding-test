import java.io.IOException;
import java.io.*;
import java.util.*;

class Main {
    static class Pocket{
        int num;
        StringBuilder sb;
        


        Pocket(int num, String str){
            this.num = num;
            sb = new StringBuilder();
            sb.append(str);
        }
    }
    static char[] oper = {'D', 'S', 'L', 'R'};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answers = new StringBuilder();
        StringTokenizer st;
        
        
        int T = Integer.parseInt(br.readLine());
        for(int tc=0; tc<T; tc++){
            StringBuilder answer = new StringBuilder();
            boolean[] visited = new boolean[10000];
            Deque<Pocket> q = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            visited[A] = true;
            int B = Integer.parseInt(st.nextToken());
            q.offerLast(new Pocket(A, ""));
            boolean flag = false;
            while(true){
                StringBuilder ssb;
                Pocket cur = q.pollFirst();
                boolean find = false;
                int now = cur.num;
                int d1 = cur.num / 1000;
                int d2 = (cur.num - d1*1000) / 100;
                int d3 = (cur.num - d1*1000 - d2*100) / 10;
                int d4 = cur.num - d1*1000 - d2*100 - d3*10;
                for(int i=0; i<4; i++){
                    char o = oper[i];
                    switch(o){
                        case 'D':
                            ssb = new StringBuilder();
                            ssb.append(cur.sb);
                            int tmp = now * 2;
                            if(tmp > 9999) tmp = tmp % 10000;
                            if(tmp == B){
                                answer.append(ssb).append('D');
                                find = true;
                                break;
                            }
                            if(!visited[tmp]){
                                visited[tmp] = true;
                                q.offerLast(new Pocket(tmp, ssb.append('D').toString()));
                            }
                            //System.out.println(ssb.toString() + ": " + tmp);
                            break;
                        case 'S':
                            ssb = new StringBuilder();
                            ssb.append(cur.sb);
                            int tmp2 = (now == 0) ? 9999 : now - 1;
                            if(tmp2 == B){
                                answer.append(ssb).append('S');
                                find = true;
                                break;
                            }
                            if(!visited[tmp2]){
                                visited[tmp2] = true;
                                q.offerLast(new Pocket(tmp2, ssb.append('S').toString()));
                            }
                            //System.out.println(ssb.toString() + ": " + tmp2);
                            break;

                        case 'L':
                            ssb = new StringBuilder();
                            ssb.append(cur.sb);
                            int tmp3 = d2 * 1000 + d3 * 100 + d4 * 10 + d1;
                            if(tmp3 == B){
                                answer.append(ssb).append('L');
                                find = true;
                                break;
                            }
                            if(!visited[tmp3]){
                                visited[tmp3] = true;
                                q.offerLast(new Pocket(tmp3, ssb.append('L').toString()));
                            }
                            //System.out.println(ssb.toString() + ": " + tmp3);
                            break;
                        case 'R':
                            ssb = new StringBuilder();
                            ssb.append(cur.sb);
                            int tmp4 = d4 * 1000 + d1 * 100 + d2 * 10 + d3;
                            if(tmp4 == B){
                                answer.append(ssb).append('R');
                                find = true;
                                break;
                            }
                            if(!visited[tmp4]){
                                visited[tmp4] = true;
                                q.offerLast(new Pocket(tmp4, ssb.append('R').toString()));
                            }
                            //System.out.println(ssb.toString() + ": " + tmp4);
                            break;
                    }
                    if(find){
                        answers.append(answer).append("\n");
                        flag = true;
                        break;
                    }
                }
                if(flag){
                    break;
                }
            }
        }
        bw.write(answers.toString());
        bw.flush(); bw.close();

    }
}