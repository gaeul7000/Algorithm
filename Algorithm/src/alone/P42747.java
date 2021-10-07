package alone;

import java.util.Arrays;

public class P42747 {
    public int solution(int[] citations) {
        int answer = 0;

        int tmp = 0;

        Arrays.sort(citations);

        for(int i = 0; i < citations.length; i++) {
            int hidx = 0;
            tmp = citations[i];
            int leng = citations.length - i;
            hidx = Math.min(tmp, leng);
            answer = Math.max(hidx, answer);
        }
        return answer;
    }

    public static void main(String[] args) {
        P42747 p = new P42747();

        int[] citations = {3, 0, 6, 1, 5};

        int answer = p.solution(citations);

        System.out.println(answer);
    }
    
}
