package alone;

import java.util.Arrays;
import java.util.Comparator;

public class P12939 {
    public String solution(String s) {
        String answer = "";
        
        String[] num = s.split(" ");
        
        Arrays.sort(num, new Comparator<String>(){
            public int compare(String o1, String o2) {
                
               return Integer.parseInt(o1) - Integer.parseInt(o2); 
            }
        }
        );
        
        for(String x: num) System.out.println(x);
        return answer;
    }
    
}
