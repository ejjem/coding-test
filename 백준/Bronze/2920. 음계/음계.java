import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ascending_check = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] descending_check = {8, 7, 6, 5, 4, 3, 2, 1};
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<8;i++) {
        	list.add(Integer.parseInt(st.nextToken()));
        }
        if(list.get(0) == 1) {
        	for(int i=1;i<8;i++) {
        		if(list.get(i) != ascending_check[i]) {
        			System.out.println("mixed");
        			return;
        		}
        	}
        	System.out.println("ascending");
        }
        else if(list.get(0) == 8) {
        	for(int i=1;i<8;i++) {
        		if(list.get(i) != descending_check[i]) {
        			System.out.println("mixed");
        			return;
        		}
        	}
        	System.out.println("descending");
        }
        else System.out.println("mixed");
    }
}