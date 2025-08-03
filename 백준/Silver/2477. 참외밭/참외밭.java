import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		ArrayList<Integer> directions = new ArrayList<>(6);
		ArrayList<Integer> lengths = new ArrayList<>(6);
		for(int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			directions.add(Integer.parseInt(st.nextToken()));
			lengths.add(Integer.parseInt(st.nextToken()));
			// 반드시 4 -> 2 -> 3 -> 1 -> 4 순서만 가능	
		}
		// 큰거
		int max_x = 0;
		int max_y = 0;
		for(int i = 0; i < 6; i++) {
			if(directions.get(i) == 4 || directions.get(i) == 3) {
				max_x = Math.max(max_x, lengths.get(i));
			}
			else if(directions.get(i) == 1 || directions.get(i) == 2) {
				max_y = Math.max(max_y, lengths.get(i));
			}
		}
		// 작은거
		int small = 0;
		for(int i = 0; i < 6; i++) {
			int index = directions.get(i);
			switch(index) {
			case(4):
				if (directions.get((i+1)%6) != 2) {
					small = lengths.get(i) * lengths.get((i+1)%6);
				}
				break;
			case(3):
				if (directions.get((i+1)%6) != 1) {
					small = lengths.get(i) * lengths.get((i+1)%6);
				}
				break;
			case(2):
				if (directions.get((i+1)%6) != 3) {
					small = lengths.get(i) * lengths.get((i+1)%6);
				}
				break;
			case(1):
				if (directions.get((i+1)%6) != 4) {
					small = lengths.get(i) * lengths.get((i+1)%6);
				}
				break;
			}
		}
		System.out.println( (max_x * max_y - small) * K );
		
	}
}
