package alone;

import java.util.HashMap;
import java.util.Map.Entry;

public class P17677 {
    public int solution(String str1, String str2) {
        int answer = 0;

        double num = 0;
        double intsec = 0;
        double uni = 0;

        HashMap<String, Integer> str1Map = changeMap(str1);
        HashMap<String, Integer> str2Map = changeMap(str2);

        if(str1Map.isEmpty() && str2Map.isEmpty()) return 65536;
        intsec = intsection(str1Map, str2Map);
        uni = union(str1Map, str2Map);

        num = (intsec / uni) * 65536;

        answer = (int)num;

        return answer;
    }

    public HashMap<String,Integer> changeMap(String str) {
        HashMap<String, Integer> map = new HashMap<>();
        StringBuilder s = new StringBuilder();

        str = str.toLowerCase();

        for(int i = 0; i < str.length() - 1; i++) {
            if(Character.toString(str.charAt(i)).matches("[^a-z]") || Character.toString(str.charAt(i + 1)).matches("[^a-z]")) continue;
            s.append(str.charAt(i));
            s.append(str.charAt(i + 1));

            if(map.containsKey(s.toString())) map.put(s.toString(), map.get(s.toString()) + 1);
            else map.put(s.toString(), 1);

            s.setLength(0);
        }

        return map;
    }

    public double intsection(HashMap<String,Integer> A, HashMap<String,Integer> B) {
        double intsec = 0;

        for(Entry<String, Integer> entryA: A.entrySet()) {
            for(Entry<String, Integer> entryB: B.entrySet()) {
                if(entryA.getKey().equals(entryB.getKey())) {
                    intsec += Math.min(entryA.getValue(), entryB.getValue());
                }
            }
        }
         return intsec;
    }

    public double union(HashMap<String,Integer> A, HashMap<String,Integer> B) {
        double uni = 0;

        HashMap<String, Integer> uniMap = new HashMap<>();

        for(Entry<String, Integer> entryA: A.entrySet()) {
            uniMap.put(entryA.getKey(), entryA.getValue());
        }

        for(Entry<String, Integer> entryB: B.entrySet()) {
            if(uniMap.containsKey(entryB.getKey())) uniMap.put(entryB.getKey(), Math.max(entryB.getValue(), uniMap.get(entryB.getKey())));
            else uniMap.put(entryB.getKey(), entryB.getValue());
        }

        for(Entry<String, Integer> entryC: uniMap.entrySet()) {
            uni += entryC.getValue();
        }

        return uni;
    }
    
    public static void main(String[] args) {
        P17677 p = new P17677();

        String str1 = "aa1+aa2";
        String str2 = "AA12";

        int answer = p.solution(str1, str2);

        System.out.println(answer);
    }
}
