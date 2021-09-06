package alone;

import java.util.ArrayList;
import java.util.Collections;
//스테이지별 성공률
class P42889 {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double[] stage = new double[N + 1];

        double num = stages.length; // 총 사람 수
        double tmp = 0; // 각 스테이지 사람 수 저장

        ArrayList<Double> fail = new ArrayList<>();

        for(int x: stages){
            if(x == N + 1) continue;
            stage[x]++;
        } //각 스테이지별 사람수 체크

        //실패율 계산
        for(int i = 1; i < stage.length; i++){
            tmp = stage[i];
            if(num == 0) stage[i] = 0;
            else {
                stage[i] = tmp / num;
                num -= tmp;
            }
            fail.add(stage[i]);
        }

        Collections.sort(fail,Collections.reverseOrder());

        for(int i = 0; i < fail.size(); i++){
            for(int j = 1; j < stage.length; j++){
                if(fail.get(i) == stage[j]) {
                    answer[i] = j;

                    stage[j] = -100;
                    break;
                }
            }
        }

        return answer;
    }
}