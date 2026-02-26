import java.io.IOException;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<int[]> target = new ArrayList<>();
        List<int[]> picture = new ArrayList<>();
        HashSet<Long> picture2 = new HashSet<>();
        
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); int y = Integer.parseInt(st.nextToken());
            target.add(new int[]{y, x});
        }
        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); int y = Integer.parseInt(st.nextToken());
            picture.add(new int[]{y, x});
            picture2.add((long) y *1000001 + x);
        }
        int index = 0;
        int[] start = target.get(0);
        int X = start[1]; int Y = start[0];
        for(index=0; index<picture.size(); index++){
            boolean find = true;
            int x = X; int y = Y;            
            int[] tmp = picture.get(index);
            int dy = tmp[0] - y; int dx = tmp[1] - x;
            for(int i=0; i<target.size(); i++){
                int[] t = target.get(i);
                int ny = t[0] + dy; int nx = t[1] + dx; 
                if(ny < 0 || nx < 0){
                    find = false;
                    break;
                }
                else{
                    long num = (long)ny * 1000001 + nx;
                    if(!picture2.contains(num)){
                        find = false;
                        break;
                    }
                }
            }
            if(find) {
                System.out.println(dx + " " + dy); 
                return;
            }
        }
    }
}