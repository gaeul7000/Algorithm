package alone;

class Solution {
    static StringBuilder route = new StringBuilder("");
    static String tmproute = "Z";

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
            }
        }

        answer = tmproute.split(" ");

        return answer;
    }

    public void dfs(String des, int index){

        route.append(des + " ");

        boolean flag = false;

        if(index == ticketsCopy.length){
            if(route.toString().compareTo(tmproute) < 0) tmproute = route.toString();
            return;
        }

        for(int i = 0; i < ticketsCopy.length; i++){
            if(des.equals(ticketsCopy[i][0]) && !isused[i]){
                isused[i] = true;
                dfs(ticketsCopy[i][1], index + 1);
                if(!flag) {
                    System.out.println(route);
                    route.delete(route.length() - 4, route.length());
                    System.out.println(route);
                }
                isused[i] = false;
                
                flag = true;
            }

        }

    }
}public class P43164 {

    public static void main(String[] args) throws Exception {

        Solution s = new Solution();

        //String[][] st = {{"ICN", "AAA"},{"ICN", "BBB"},{"BBB", "ICN"}};

        //String[][] st = {{"ICN", "AAA"},{"AAA", "CCC"},{"AAA", "DDD"}, {"DDD", "BBB"}, {"BBB", "AAA"}};
        
        //String[][] st = {{"ICN", "AAA"},{"AAA", "BBB"},{"AAA", "CCC"}, {"BBB", "DDD"}, {"CCC", "AAA"}};

        //String[][] st = {{"ICN", "SFO"},{"ICN", "ATL"},{"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};

        //String[][] st = {{"ICN", "AAA"},{"AAA","BBB"},{"BBB", "AAA"}, {"AAA", "ICN"}, {"ICN", "AAA"}};

        String[][] st = {{"ICN", "BBB"},{"ICN","CCC"},{"CCC", "DDD"}, {"DDD", "CCC"}, {"BBB", "DDD"}, {"DDD", "BBB"}, {"BBB", "ICN"}, {"CCC", "BBB"}};

        //String[][] st = {{"ICN", "AAA"},{"ICN","AAA"},{"ICN", "AAA"}, {"AAA", "ICN"}, {"AAA", "ICN"}};

        String[] an = s.solution(st);

       for(String x: an) System.out.println(x);
    }
    
}
