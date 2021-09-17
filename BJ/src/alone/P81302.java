package alone;

import java.util.ArrayList;

public class P81302 {
    static String[][] placesCopy;

    public int[] solution(String[][] places) {
        placesCopy = places.clone();
        int[] answer = new int[5];

        for(int i = 0; i < 5; i++) {
            answer[i] = isRightRoom(places[i]);
        }
        return answer;
    }

    public int isRightRoom(String[] place) {
        ArrayList<Integer[]> arr = new ArrayList<>();

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(place[i].charAt(j) == 'P') arr.add(new Integer[]{i, j});
            }
        }

        for(int i = 0; i < arr.size(); i++) {
            for(int j = 0; j < arr.size(); j++) {
                if(i < j) {
                    if(Math.abs(arr.get(i)[0] - arr.get(j)[0]) + Math.abs(arr.get(i)[1] - arr.get(j)[1]) > 2) continue;
                    else if(arr.get(i)[0] == arr.get(j)[0] && place[arr.get(i)[0]].charAt((arr.get(i)[1]+arr.get(j)[1])/2) == 'X') continue;
                    else if(arr.get(i)[1] == arr.get(j)[1] && place[(arr.get(i)[0]+arr.get(j)[0])/2].charAt(arr.get(i)[1]) == 'X') continue;
                    else if(place[arr.get(i)[0]].charAt(arr.get(j)[1]) == 'X' && place[arr.get(j)[0]].charAt(arr.get(i)[1]) == 'X') continue;
                    else return 0;
                }
            }
        }

        return 1;
        
    }

    public static void main(String[] args){
        P81302 s = new P81302();

        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        int[] answer = s.solution(places);

        for(int x: answer){
            System.out.println(x);
        }
    }
    
}
