/*
 n개의 포인트 (1~n)
 로봇마다 운송 경로 존재, 운송 경로는 m개의 포인트로 구성, 첫 포인트에서 시작해 할당된 포인트를 순서대로 방문
 로봇은 x대, 모두가 0초에서 출발, 1칸식 이동(상하좌우)
 최단경로가 여러개일 경우, r좌표를 우선 이동
 운송을 마치면 물류 센터를 벗어남, 이 때 경로는 생각 x
 이동 중 같은 좌표에 2대 이상이 모이면 위험 상황

 현재 설정대로 움직일 시 발생하는 위험 상황이 몇 번인지 알아내기
*/
import java.util.*;
class Solution {
    static class Robot {
            int index;
            int r;
            int c;
            int target;
            int cnt;
            boolean moving;
            public Robot(int index, int r, int c, int target, int cnt){
                this.index = index; this.r = r; this.c = c; this.target = target;
                this.cnt = cnt; this.moving = true;
            }
            public void move(int[][] points){
                int tr = points[target-1][0];
                int tc = points[target-1][1];   
                if(this.r != tr){
                    if(this.r > tr) this.r --;
                    else this.r ++;
                }
                else if(this.c != tc){
                    if(this.c > tc) this.c --;
                    else this.c ++;
                }
            }
    }
    
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int x = routes.length; // 로봇 갯수
        int y = routes[0].length; // 로봇들이 도달해야 하는 포인트 갯수
        int arrivedRobots = 0;
        Robot[] robots = new Robot[x]; 
        
        for(int i=0; i<x; i++){
            int now = routes[i][0]; // 현재 로봇이 위치한 포인트
            Robot robot = new Robot(i, points[now-1][0], points[now-1][1], routes[i][0], 0);
            robots[i] = robot;
        }
        while(arrivedRobots != x){
            HashMap<Integer, Integer> map = new HashMap<>();
            for(Robot robot : robots){
                if(!robot.moving) continue;
                int place = robot.r * 1000 + robot.c;
                //System.out.println("index: " + (robot.index+1) + ", 위치: " + place);
                
                // 위험 검사
                if(!map.containsKey(place)) {map.put(place, 1);}
                else if(map.get(place) == 1) {map.put(place, 2); answer ++;}
                // 이동
                if (robot.r == points[robot.target-1][0] && robot.c == points[robot.target-1][1]) {
                    robot.cnt++;                                  // 포인트 도달 카운트
                    if (robot.cnt == y) {                         // 모든 포인트 끝났으면 즉시 퇴장
                        robot.moving = false;
                        arrivedRobots++;
                        continue;                                 //이 틱에선 더 이상 이동 없음
                    }
                    robot.target = routes[robot.index][robot.cnt]; // 다음 타깃 설정 후 이동
                }
                robot.move(points);     
            }
        }
        return answer;
    }
}