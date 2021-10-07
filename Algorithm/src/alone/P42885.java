package alone;

import java.util.ArrayList;
import java.util.Arrays;

public class P42885 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        ArrayList<Integer> peo = new ArrayList<>();

        for(int x: people) peo.add(x);
        int weight = 0;

        while(!peo.isEmpty()) {
            weight += peo.get(peo.size() - 1);
            peo.remove(peo.size() - 1);

            while(!peo.isEmpty()) {

                if(limit - weight < 40) break;
                if(weight + peo.get(0) <= limit) {
                    weight += peo.get(0);
                    peo.remove(0);
                    break;
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
