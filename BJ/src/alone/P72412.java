package alone;

import java.util.ArrayList;

class applicant {
    String[] app = new String[5];

    public applicant (String ap) {
        this.app = ap.split(" ");
    }
}

public class P72412 {
    static ArrayList<applicant> arr = new ArrayList<>();

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        for(String x: info) {
            arr.add(new applicant(x));
        }

        for(int i = 0; i < query.length; i++) {
            answer[i] = check(query[i]);
        }

        return answer;
    }

    public int check(String condition) {
        ArrayList<applicant> tmp = new ArrayList<>();
        tmp.addAll(arr);

        String sc = condition.substring(condition.length() - 3, condition.length());
        String conds = condition.substring(0, condition.length() - 4);
        String[] cond = conds.split(" and ");

        for(int i = 0; i < cond.length + 1; i++) {
            if(i < 4 && cond[i].equals("-")) continue;

            for(int j = 0; j < tmp.size(); j++) {
                if((i < 4 && !tmp.get(j).app[i].equals(cond[i])) || (i == 4 && Integer.parseInt(tmp.get(j).app[i]) < Integer.parseInt(sc))) {
                    tmp.remove(j);
                    j--;
                    continue;
                }
            }
        }

        return tmp.size();
    }
    


    public static void main (String[] args) {
        P72412 p = new P72412();

        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        int[] answer = p.solution(info, query);

        for(int x: answer) System.out.println(x);
    }
    
}
