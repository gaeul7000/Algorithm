package alone;

import java.util.ArrayList;

class P42840 {
    public int[] solution(int[] answers) {
        int[] answer;
        
        int[] s1 = {1, 2, 3, 4, 5};
        int[] s2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] s3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int s1A = 0;
        int s2A = 0;
        int s3A = 0;

        for(int i = 0; i < answers.length; i++){
            if(s1[i % s1.length] == answers[i]) s1A++;
            if(s2[i % s2.length] == answers[i]) s2A++;
            if(s3[i % s3.length] == answers[i]) s3A++;
        }

        System.out.println("1" + s1A + "2" + s2A + "3" +s3A);
        int max = Math.max(Math.max(s1A, s2A), s3A);
        ArrayList<Integer> ans = new ArrayList<>();

        if(max == s1A) ans.add(1);
        if(max == s2A) ans.add(2);
        if(max == s3A) ans.add(3);

        answer = new int[ans.size()];

        for(int i = 0; i < ans.size(); i++){
            answer[i] = ans.get(i);
        }

        return answer;
    }
}