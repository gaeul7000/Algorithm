package alone;

import java.util.ArrayList;
import java.util.Collections;

public class P42885 {
    public int solution(int[] people, int limit) {
        int answer = 0;

        ArrayList<Integer> peo = new ArrayList<>();

        for(int x: people) peo.add(x);

        Collections.sort(peo, Collections.reverseOrder());

        int weight = 0;

        while(!peo.isEmpty()) {
            weight += peo.get(0);
            peo.remove(0);

            while(!peo.isEmpty()) {
                if(weight + peo.get(peo.size() - 1) <= limit) {
                    weight += peo.get(peo.size() - 1);
                    peo.remove(peo.size() - 1);
                } else break;
            }

            answer++;
            weight = 0;

        }
        return answer;
    }

    public static void main(String[] args) {
        P42885 p = new P42885();

        int[] people = {70, 50, 80, 50};
        int limit = 100;
        
        int answer = p.solution(people, limit);

        System.out.println(answer);
    }
    
}
