import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int date = Integer.parseInt(br.readLine());
		if (date%4 == 0) {
			if (date%100 != 0) {
				System.out.println("1");
			}
			else if (date%400 == 0) {
				System.out.println("1");
			}
			else {
				System.out.println("0");
			}
		}
		else {
			System.out.println("0");
		}
	}
}