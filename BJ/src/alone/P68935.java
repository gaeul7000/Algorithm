package alone;


import java.util.ArrayList;

class Solution {
    public int solution(int n) {
        int answer = 0;
        ArrayList<Integer> three = new ArrayList<>();
        int number = 0;
        
        while(n > 3){
            number = n % 3;
            three.add(number);
            n /= 3;
            if(n < 3){
                three.add(n);
                break;
            }
        }
        System.out.println(three);

        for(int i = three.size() - 1; i >= 0; i--){
            if(i == three.size() - 1){
                answer += 1 * three.get(i);
                continue;
            } 
            answer += Math.pow(3, (three.size()-1-i)) * three.get(i);

        }
        
        return answer;
    }
}

public class P68935 {
    
}
