package team;
class Solution {
    static String tmproute = "Z";

    static String[][] ticketsCopy;
    static boolean[] isused;

    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length + 1];
        ticketsCopy = tickets;
        isused = new boolean[tickets.length];
        
        for(int i = 0; i < tickets.length; i++){
            if(tickets[i][0].equals("ICN")){
                isused[i] = true;
                dfs("ICN "+tickets[i][1], tickets[i][1], 1);
                isused[i] = false;
            }
        }

        answer = tmproute.split(" ");

        return answer;
    }

    public void dfs(String route, String des, int index){

        boolean flag = false;

        if(index == ticketsCopy.length){
            if(route.toString().compareTo(tmproute) < 0) tmproute = route.toString();
            return;
        }

        for(int i = 0; i < ticketsCopy.length; i++){
            if(des.equals(ticketsCopy[i][0]) && !isused[i]){
                isused[i] = true;
                dfs(route + " " + ticketsCopy[i][1], ticketsCopy[i][1], index + 1);
                isused[i] = false;
            }
        }
    }
}

/*
* 1차 이슈 > 메모리 초과
* 
* dfs 호출시마다 결과를 arrayList에 add하는 과정에서 메모리 초과 발생
* >> 결과를 add 하지 않고 결과를 비교하여 최적의 값으로 갱신하는 방법 사용
*
* 2차 이슈 > 분기 후 노드가 끊겼을때 (티켓을 다 사용하지 못했는데 경로가 끊긴 경우) 분기점이 삭제되지 않음
*
* >> dfs 매개변수로 경로값을 전달해 해결
*/
public class P43164 {

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
