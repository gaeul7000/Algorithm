package alone;

import java.util.Stack;

class loc{
    int x;
    int y;

    public loc(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class P17679 {
    static Stack<loc> st = new Stack<>();
    static String[][] boards;
    static int[] dr = {0, 1, 1}; //우 하 대
    static int[] dc = {1, 0, 1};

    public static int solution(int m, int n, String[] board) {
        int answer = 0;

        boards = new String[board.length][board[0].length()];

        for(int i = 0; i < board.length; i++) {
            boards[i] = board[i].split("");
        }
        
        while(true) {
            check();
            if(st.isEmpty()) break;
            clear();
        }


        for(int i = 0; i < boards.length; i++) {
            for(int j = 0; j < boards[i].length; j++){
                if("0".equals(boards[i][j])) {
                    answer++;
                }
            }
        }
        
        return answer;
    }

    public static void check() {
        int count = 0;
        for(int i = 0; i < boards.length; i++) {
            for(int j = 0; j < boards[i].length; j++){
                count = 0;
                for(int w = 0; w < 3; w++) {
                    if(i + dr[w] < boards.length && j + dc[w] < boards[i].length && !"0".equals(boards[i][j]) && boards[i][j].equals(boards[i + dr[w]][j + dc[w]])) {
                        st.push(new loc(i + dr[w], j + dc[w]));
                        count++;
                    } else break;
                }
                if(count != 3){
                    for(int y = 0; y < count; y++) st.pop();
                } else {
                    st.push(new loc(i, j));
                }
            }
        }
    }

    public static void clear() {

        while(!st.empty()) {
            loc l = st.pop();
            int x = l.x;
            int y = l.y;

            boards[x][y] = "0";
        }

        for(int i = 0; i < boards.length; i++) {
            for(int j = 0; j < boards[i].length; j++){
                if(!"0".equals(boards[i][j]) && i + dr[1] < boards.length && "0".equals(boards[i + dr[1]][j + dc[1]])) {
                    boards[i + dr[1]][j + dc[1]] = boards[i][j];
                    boards[i][j] = "0";
                    i = 0;
                    j--;
                }
            }
        }

    }



    public static void main(String[] args) {

        int m = 4;
        int n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};

        int answer = solution(m, n, board);

        System.out.println(answer);

    }
    
}
