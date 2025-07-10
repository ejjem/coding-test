import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.nextLine();
		int answer = 0;
		for(int i=0; i<S.length(); i++) {
			answer += S.charAt(i) - '0';
		}
		System.out.println(answer);
		sc.close();
	}
}