import java.util.*;
import java.io.*;

public class Solution {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static StringBuilder sb;
    static int[] point;
    static char tank;
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());        
    	sb = new StringBuilder();
        for(int tc=1;tc<T+1;tc++) {
        	sb.append("#").append(tc).append(" ");
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            char[][] board = new char[H][W];
            point = new int[2];
            for(int i=0; i<H; i++) {
            	String tmp = br.readLine();
            	for(int j=0; j<W; j++) {
            		if(tmp.charAt(j) == '<' ||
            		   tmp.charAt(j) == '>'	||
            		   tmp.charAt(j) == '^' ||
            		   tmp.charAt(j) == 'v') {
            			tank = tmp.charAt(j);
            			point[0] = i; point[1] = j;
            		}
            		board[i][j] = tmp.charAt(j);
            	}
            }
            int N = Integer.parseInt(br.readLine());
            String operation = br.readLine();
            for(int idx=0; idx<N; idx++) {
            	char o = operation.charAt(idx);
            	switch(o) {
            		case 'U':
            			tank = '^';
            			if(point[0]-1 >= 0 && board[point[0]-1][point[1]] == '.') {
            				board[point[0]][point[1]] = '.';
            				point[0] -= 1;
            			}
            			board[point[0]][point[1]] = tank;
            			break;
            		case 'D':
            			tank = 'v';
            			if(point[0]+1 < H && board[point[0]+1][point[1]] == '.') {
            				board[point[0]][point[1]] = '.';
            				point[0] += 1;
            			}
            			board[point[0]][point[1]] = tank;
            			break;
            		case 'L':
            			tank = '<';
            			if(point[1]-1 >= 0 && board[point[0]][point[1]-1] == '.') {
            				board[point[0]][point[1]] = '.';
            				point[1] -= 1;
            			}
        				board[point[0]][point[1]] = tank;
            			break;
            		case 'R':
            			tank = '>';
            			if(point[1]+1 < W && board[point[0]][point[1]+1] == '.') {
            				board[point[0]][point[1]] = '.';
            				point[1] += 1;
            			}
        				board[point[0]][point[1]] = tank;
            			break;
            		case 'S':
            			int i = 0;
            			switch(tank) {
            			case '^':
            				i = point[0] -1;
            				while(i >= 0) {
            					if(board[i][point[1]] == '*') {
            						board[i][point[1]] = '.';
            						break;
            					}
            					else if(board[i][point[1]] == '#') break;
            					i--;
            				}
            				break;
            			case 'v':
            				i = point[0] + 1;
            				while(i < H) {
            					if(board[i][point[1]] == '*') {
            						board[i][point[1]] = '.';
            						break;
            					}
            					else if(board[i][point[1]] == '#') break;
            					i++;
            				}
            				break;
            			case '<':
            				i = point[1] - 1;
            				while(i >= 0) {
            					if(board[point[0]][i] == '*') {
            						board[point[0]][i] = '.';
            						break;
            					}
            					else if(board[point[0]][i] == '#') break;
            					i--;
            				}
            				break;
            			case '>':
            				i = point[1] + 1;
            				while(i < W) {
            					if(board[point[0]][i] == '*') {
            						board[point[0]][i] = '.';
            						break;
            					}
            					else if(board[point[0]][i] == '#') break;
            					i++;
            				}
            				break;
            			}
            			break;
            	}
            }
            for(int i=0; i<H; i++) {
            	for(int j=0; j<W; j++) {
            		sb.append(board[i][j]);
            	}
            	sb.append("\n");
            }
        }   
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
