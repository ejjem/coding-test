import java.io.*;
import java.util.StringTokenizer;

public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str);

    StringBuilder sb = new StringBuilder();

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    sb.append(a+b).append("\n");
    sb.append(a-b).append("\n");
    sb.append(a*b).append("\n");
    sb.append(a/b).append("\n");
    sb.append(a%b).append("\n");

    System.out.print(sb);
    }
}