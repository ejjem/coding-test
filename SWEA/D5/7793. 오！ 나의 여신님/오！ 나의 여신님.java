import java.util.*;
import java.io.*;

public class Solution {
  static int N, M;
  static char[][] map;
  static int Sx, Sy, Dx, Dy;
  static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
  static boolean isPossible(int y, int x){
    if(y >= 0 && y < N && x >= 0 && x < M) return true;
    return false;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());
    
    for(int tc=1;tc<T+1;tc++){
      int answer = 0;
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
      map = new char[N][M];
      ArrayList<int[]> evils = new ArrayList<>();
      for(int i=0; i<N; i++){
        String tmp = br.readLine();
        for(int j=0; j<M; j++){
          map[i][j] = tmp.charAt(j);
          if(map[i][j] == 'S'){ Sy = i; Sx = j;}
          else if(map[i][j] == 'D'){ Dy = i; Dx = j;}
          else if(map[i][j] == '*'){ evils.add(new int[]{i, j});}
        }
      }
      ArrayDeque<int[]> q = new ArrayDeque<>();
      for(int i=0; i<evils.size(); i++){
        int[] evil = evils.get(i);
        q.offerLast(new int[]{evil[0], evil[1], -1});
      }
      q.offerLast(new int[]{Sy, Sx, 0});
      map[Sy][Sx] = '-';
      boolean ok = false;
      while(!q.isEmpty()){
        int[] tmp = q.pollFirst();
        int y = tmp[0]; int x = tmp[1]; int cnt = tmp[2];
        for(int i=0; i<4; i++){
          int dy = dist[i][0]; int dx = dist[i][1];
          int dyy = y + dy; int dxx = x + dx;
          if(cnt == -1){
            if(isPossible(dyy, dxx) && (map[dyy][dxx] == '.' || map[dyy][dxx] == '-')){
              map[dyy][dxx] = '*'; q.offerLast(new int[]{dyy, dxx, -1});
            }
          }
          else{
            if(dyy == Dy && dxx == Dx){answer = cnt+1; ok = true; break;} 
            if(isPossible(dyy, dxx) && map[dyy][dxx] == '.'){
              map[dyy][dxx] = '-'; q.offerLast(new int[]{dyy, dxx, cnt+1});
            }
          } 
        }
        if(ok) break;
      }
      if(ok) sb.append("#").append(tc).append(" ").append(answer).append("\n");
      else sb.append("#").append(tc).append(" ").append("GAME OVER").append("\n");
    }
    bw.write(sb.toString()); bw.flush(); bw.close();
  }
}
