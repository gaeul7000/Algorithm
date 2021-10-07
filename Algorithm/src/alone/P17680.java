package alone;

import java.util.ArrayList;

public class P17680 {
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> cache = new ArrayList<>();
        boolean flag = false;

        if(cacheSize == 0) return cities.length * 5;

        for(String x: cities) {
            for(String y: cache) {
                if(cache.isEmpty()) break;
                if(x.toLowerCase().equals(y.toLowerCase())) {
                    answer += 1;
                    cache.remove(y);
                    cache.add(y);
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                answer += 5;
                if(!cache.isEmpty() && cache.size() >= cacheSize) {
                    cache.remove(0);
                }
                cache.add(x);
            }
            flag = false;
        }
        return answer;
    }

    public static void main(String[] args) {

        int cashSize = 2;
        String[] cities = {"Jeju", "Pangyo", "NewYork", "newyork"};
        int answer = solution(cashSize, cities);

        System.out.println(answer);

    }
    
}
