package alone;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int count = 0; //여분을 갖고있는데 훔침당한 사람의 수 
        
        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
               if(reserve[j] == lost[i]){
                   reserve[j] = -1; //사용 안하는 값으로 만들기
                   lost[i] = -1;
                   count++;
               }
            }
        }
        
        answer = n - lost.length + count; 
        
        for(int i = 0; i < lost.length; i++){
            
            for(int j = 0; j < reserve.length; j++){
                if(lost[i] - 1 == reserve[j]){
                    reserve[j] = -1;
                    answer++;
                    break;
                }else if(lost[i] + 1 == reserve[j]){
                    reserve[j] = -1;
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}

public class P42862 {
    
}
