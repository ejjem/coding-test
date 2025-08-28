import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int Tshirt = 0;
		int Pen1=0; int Pen2=0;
		int[] shirts = new int[6];
		for(int i=0; i<6; i++) {
			shirts[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken()); int b = Integer.parseInt(st.nextToken());
		for(int i=0; i<6; i++) {
			if(shirts[i] == 0) continue;
			if(shirts[i]%a == 0) Tshirt += shirts[i]/a;
			else Tshirt += (shirts[i]/a + 1);
		}
		StringBuilder sb = new StringBuilder();
		sb.append(Tshirt).append("\n");
		sb.append(N/b).append(" ").append(N%b);
		System.out.println(sb);
	}
}