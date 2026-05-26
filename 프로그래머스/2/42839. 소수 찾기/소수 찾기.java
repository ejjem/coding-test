/*
    소수 판별 방법 -> 자기 자신을 제외한 모든 수에서 약수가 없으면 되는데...
    최적화는 유클리드 호제법? 으로 소수 집합을 만들어서 그거만 검사하는거.
    일단은 그냥 2 ~ 자기 자신 -1 까지 나눠서 약수가 없는지 확인하는거로.
*/
import java.util.*;
import java.io.*;
class Solution {
    static Set<Integer> permutations;
    static char[] selected;
    static boolean[] visited;
    
    public void findPerm(int count, char[] number){
        selected = new char[count];
        visited = new boolean[number.length];

        permutation(count, 0, number);
    }
    public void permutation(int count, int depth, char[] number){
        if(depth == count){
            String tmp = "";
            for(int i=0; i<count; i++){
                tmp += selected[i];
            }
            permutations.add(Integer.parseInt(tmp));
            return;
        }
        
        for(int i=0; i<number.length; i++){
            if(visited[i]) continue;
            
            visited[i] = true;
            selected[depth] = number[i];
            
            permutation(count, depth + 1, number);
            
            visited[i] = false;
        }
    }
    
    public boolean isPrime(int num){
        if (num < 2) return false;
        
        for(int i = 2; i * i <= num; i++){
            if(num % i == 0) return false;
        }
        
        return true;
    }
    
    public int solution(String numbers) {
        int answer = 0;
        permutations = new HashSet<>();
        char[] number = new char[numbers.length()];
        for(int i=0; i<numbers.length(); i++){
            number[i] = numbers.charAt(i);
        }
        for(int count=1; count<=numbers.length(); count++){
            findPerm(count, number);
        }
        
        for(int n : permutations){
            if(isPrime(n)){
                answer++;
            }
        }
        
        return answer;
    }
}