package alone;
import java.util.ArrayList;

class Solution {
    public int solution(int n) {
        int answer = 0;
        ArrayList<Integer> three = new ArrayList<>();
        int number = 0;

        if(n < 3) return n;
        while(n >= 3){
            number = n % 3;
            three.add(number);
            n /= 3;
            if(n < 3){
                three.add(n);
                break;
            }
        }

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

/*
*
*1차 이슈 > 테케 안돌아감
*
*>> 3이하 값이 들어왔을때 처리를 안한 나는 바보
*
*/

public class P68935 {
    
}
