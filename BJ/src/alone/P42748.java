package alone;

import java.util.Arrays;

class Solution {
    
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++){
            answer[i] = checkIndex(array, commands[i]);
        }
        return answer;
    }
    
    public int checkIndex(int[] array, int[] command){
        int start = command[0];
        int finish = command[1];
        int find = command[2];
    
        
        int[] newArray = new int[finish-start+1];
        int index = 0;
        if(start == finish){
            return array[start-1];
        }
        for(int i = start-1; i < finish; i++){
            newArray[index] = array[i];
            index++;
        }  
        Arrays.sort(newArray);
        
        return newArray[find-1];
    }
}
public class App {
    public static void main(String[] args) throws Exception {

        Solution s = new Solution();

        int[] st = {1, 5, 2, 6, 3, 7, 4};
        int[][] sr = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] an = s.solution(st,sr);

        for(int x: an){
            System.out.println(x);
        }
    }
}
