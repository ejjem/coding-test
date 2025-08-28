import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		ArrayList<Integer> S = new ArrayList<>();
		int[] alls = new int[20];
		for(int i=0; i<20; i++) {
			alls[i] = i+1;
		}
		int x = 0;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			String inst = st.nextToken();
			switch(inst) {
			case "add":
				x = Integer.parseInt(st.nextToken());
				S.add(x);
				break;
			case "remove":
				x = Integer.parseInt(st.nextToken());
				if(S.contains(x)) S.remove((Integer) x);
				break;
			case "check":
				x = Integer.parseInt(st.nextToken());
				if(S.contains(x)) sb.append(1).append("\n");
				else sb.append(0).append("\n");
				break;
			case "toggle":
				x = Integer.parseInt(st.nextToken());
				if(S.contains(x)) S.remove((Integer) x);
				else S.add(x);
				break;
			case "all":
				S.clear();
				for(int idx=0; idx<20; idx++) {
					S.add(alls[idx]);
				}
				break;
			case "empty":
				S.clear();
			}
		}
		bw.write(sb.toString()); bw.flush(); bw.close();
	}
}