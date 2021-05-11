package alone;


import java.util.ArrayList;
import java.util.Collections;

class Solution {
    static ArrayList<String> routes = new ArrayList<>();
    static String route = "";
    boolean[] isused;

    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length + 1];

        isused = new boolean[tickets.length];

        for(int i = 0; i < tickets.length; i++){
            if(tickets[i][0].equals("ICN")){
                route = "ICN ";
                isused[i] = true;
                dfs(tickets, tickets[i][1], 1);
                isused[i] = false;
            }
        }

        Collections.sort(routes);

        answer = routes.get(0).split(" ");

        return answer;
    }

    public void dfs(String[][] tickets, String des, int index){

        route += des + " ";

        boolean flag = false;

        if(index == tickets.length){
            routes.add(route);
            return;
        }

        for(int i = 0; i < tickets.length; i++){
            if(des.equals(tickets[i][0]) && !isused[i]){
                isused[i] = true;
                dfs(tickets, tickets[i][1], index + 1);
                isused[i] = false;
                flag = true;
            }
        }

        if(!flag) route = route.substring(0, route.length() - 4);

    }
}

public class P43164 {
    
}
