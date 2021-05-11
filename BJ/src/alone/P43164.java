package alone;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    static ArrayList<String> routes = new ArrayList<>();
    static StringBuilder route = new StringBuilder("");
    static String[][] ticketsCopy;
    static boolean[] isused;

    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length + 1];
        ticketsCopy = tickets;
        isused = new boolean[tickets.length];
        
        for(int i = 0; i < tickets.length; i++){
            if(tickets[i][0].equals("ICN")){
                route.setLength(0);
                route.append("ICN ");
                isused[i] = true;
                dfs(tickets[i][1], 1);
                isused[i] = false;
                System.out.println(route);
            }
        }

        Collections.sort(routes);

        answer = routes.get(0).split(" ");

        return answer;
    }

    public void dfs(String des, int index){

        route.append(des + " ");

        boolean flag = false;

        if(index == ticketsCopy.length){
            routes.add(route.toString());
            return;
        }

        for(int i = 0; i < ticketsCopy.length; i++){
            if(des.equals(ticketsCopy[i][0]) && !isused[i]){
                isused[i] = true;
                dfs(ticketsCopy[i][1], index + 1);
                isused[i] = false;
                flag = true;
            }
        }

        if(!flag) route.delete(route.length() - 4, route.length());

    }
}
public class P43164 {
    
}
