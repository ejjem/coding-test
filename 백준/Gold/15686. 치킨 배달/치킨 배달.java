import java.io.*;
import java.util.*;

public class Main {
    static int[][] city;
    static int N, M;
	static int[][] homes; 
	static int[][] chickens;
    static int cntHome, cntChicken;
	
    static int select(int index, int cnt, boolean[] selectedChicken) {
    	if(cnt == M || index == cntChicken) {
    		return calc(selectedChicken);
    	}
    	int min = Integer.MAX_VALUE;
    	selectedChicken[index] = true;
    	min = Math.min(min, select(index + 1, cnt + 1, selectedChicken));
    	selectedChicken[index] = false;
    	min = Math.min(min, select(index +1, cnt, selectedChicken));
    	return min;
    }
    
    
    
    static int calc(boolean[] selectedChicken) {
    	boolean flag = false;
    	int distance = 0;
    	int[] arr = new int[cntHome];
    	Arrays.fill(arr, -1);
    	for(int i=0; i<selectedChicken.length; i++) {
    		if(selectedChicken[i]) {
    			flag = true;
    			int cy = chickens[i][0]; int cx = chickens[i][1];
    			for(int j=0; j<cntHome; j++) {
    				int y = homes[j][0]; int x = homes[j][1];
    				int curDistance = Math.abs(y - cy) + Math.abs(x - cx);
    				if(arr[j] == -1) arr[j] = curDistance;
    				else arr[j] = Math.min(arr[j], curDistance);
    			}
    		}
    	}
    	if(flag) {
    		for(int i=0; i<cntHome; i++) {
        		distance += arr[i];
        	}
    		//System.out.println(Arrays.toString(selectedChicken));
    		//System.out.println(distance);
    		return distance;
    	}
    	return Integer.MAX_VALUE;
    }
    
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        homes = new int[2*N][2];
        chickens = new int[13][2];
        cntHome = 0; cntChicken = 0;
        city = new int[N][N];
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<N; j++) {
        		city[i][j] = Integer.parseInt(st.nextToken());
        		if(city[i][j] == 1) homes[cntHome++] = new int[] {i, j};
        		else if(city[i][j] == 2) chickens[cntChicken++] = new int[] {i, j};
        	}
        }
        // cntChicken 중 M개 픽
        boolean[] selectedChicken = new boolean[cntChicken];
        int answer = select(0, 0, selectedChicken);
        System.out.println(answer);
    }
}


/*


*/