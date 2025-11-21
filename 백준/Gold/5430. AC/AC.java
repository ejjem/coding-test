import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for(int idx=0; idx<tc; idx++){
            String insts = br.readLine();

            int n = Integer.parseInt(br.readLine());
            List<Integer> nums = new ArrayList<>();
            String input = br.readLine();
            input = input.substring(1, input.length() - 1);
            String[] number = input.split(",");
            for(int i=0; i<n; i++){
                nums.add(Integer.parseInt(number[i]));
            }
            int stat = 1;
            boolean error = false;
            for(int i=0; i<insts.length(); i++){
                char inst = insts.charAt(i);
                switch(inst){
                    case 'R':
                        stat *= -1;
                    break;
                    case 'D':
                        if(nums.size() == 0){
                            error = true;
                            break;
                        }
                        else if(stat == 1){
                            nums.remove(0);
                        }
                        else if(stat == -1){
                            nums.remove(nums.size()-1);
                        }
                    break;
                }
                if(error){
                    sb.append("error").append("\n");
                    break;
                }
            }
            if(error) continue;
            else{
                // 결과를 sb에 추가
                // 이 때 stat -1이면 최종적으로 뒤집기
                sb.append("[");
                if(stat == 1){
                    for(int i=0; i<nums.size(); i++){
                        int tmp = nums.get(i);
                        sb.append(tmp);
                        if(i != nums.size()-1) sb.append(",");
                    }
                }
                else{
                    for(int i=nums.size()-1; i>=0; i--){
                        int tmp = nums.get(i);
                        sb.append(tmp);
                        if(i != 0) sb.append(",");
                    }
                }
                sb.append("]").append("\n");
            }
        }
        bw.write(sb.toString()); bw.flush(); bw.close();
    }
}