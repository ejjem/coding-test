import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int a = Integer.parseInt(br.readLine());
    String b = br.readLine();
    int b_1 = a * Character.getNumericValue(b.charAt(2));
    int b_2 = a * Character.getNumericValue(b.charAt(1));
    int b_3 = a * Character.getNumericValue(b.charAt(0));

    sb.append(b_1).append("\n");
    sb.append(b_2).append("\n");
    sb.append(b_3).append("\n");
    sb.append(a * Integer.parseInt(b));

    System.out.println(sb);

    br.close();
  }
}