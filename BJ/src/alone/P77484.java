package alone;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        int zeroCount = 0;
        int worstCase = 0;
        int bestCase = 0;
        
        for(int i = 0; i < lottos.length; i++){
            for(int j = 0; j < lottos.length; j++){
                if(lottos[i] == win_nums[j]){
                    worstCase++;
                    lottos[i] = -1;
                    win_nums[j] = -5;
                }
            }
        }
        
        for(int x : lottos){
            if(x == 0) zeroCount++;
        }
        
        bestCase = zeroCount + worstCase;
        
        answer[0] = bestCase;
        answer[1] = worstCase;
        
        
        for(int i = 0; i < answer.length; i++){
            switch(answer[i]){
                case 6 :
                    answer[i] = 1;
                    break;
                case 5 :
                    answer[i] = 2;
                    break;
                case 4 : 
                    answer[i] = 3;
                    break;
                case 3 :
                    answer[i] = 4;
                    break;
                case 2 :
                    answer[i] = 5;
                    break;
                default :
                    answer[i] = 6;
                    break;
            }    
        }
        
        return answer;
    }
}

public class P77484 {
    
}
