package team;

import java.util.ArrayList;
//행렬 테두리 회전 문제
class P77485 {
    static int[][] arr;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        arr = new int[rows][columns];
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++) arr[i][j] = i * columns + (j + 1);
        }
        
        for(int i = 0; i < queries.length; i++) answer[i] = roll(queries[i]);
        
        return answer;
    }
    
    public int roll(int[] query){
        int x1 = query[0];
        int y1 = query[1];
        int x2 = query[2];
        int y2 = query[3];
        
        int i = x1 - 1;
        int j = y1 - 1;
        
        int k = 2 * ((x2 - x1) + (y2 - y1));

        ArrayList<Integer> move = new ArrayList<>();

        int min = 10000;
        int tmp = arr[i][j];

        move.add(tmp);

        while(k > 1){
            if(i < x2 - 1 && j == y1 - 1){
                arr[i][j] = arr[++i][j];
                move.add(arr[i][j]);
                k--;
            }
            
            if(i == x2 - 1 && j < y2 - 1){
                arr[i][j] = arr[i][++j];
                move.add(arr[i][j]);
                k--;
            }
            
            if(i > x1 - 1 && j == y2 - 1){
                arr[i][j] = arr[--i][j];
                move.add(arr[i][j]);
                k--;
            }
            
            if(i == x1 - 1 && j > y1){
                arr[i][j] = arr[i][--j];
                move.add(arr[i][j]);
                k--;
            }
        }
        
        arr[x1 - 1][y1] = tmp;

        for(int x: move) if(min > x) min = x;

        return min;
    }
}
