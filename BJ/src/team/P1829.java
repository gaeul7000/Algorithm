package team;

import java.util.LinkedList;
import java.util.Queue;

// 그림 영역 갯수 찾기

class location {
	int x;
	int y;
	int color;
	
	public location(int x, int y, int c) {
		this.x = x;
		this.y = y;
		this.color = c;
	}
}

class Solution1829 {
	static int[][] pictureCopy;
	static Queue<location> queue = new LinkedList<>();
	static boolean[][] isVisited;
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0}; //¿Þ ¿À À§ ¾Æ
	
    public int[] solution(int m, int n, int[][] picture) {
        int[] answer = {0, 0};
        
        pictureCopy = picture;
        isVisited = new boolean[picture.length][picture[0].length];
        
        int area = 0;
        int max = 0;
        int tmp = 0;
        
        for(int i = 0; i < picture.length; i++) {
        	for(int j = 0; j < picture[0].length; j++) if(picture[i][j] == 0) isVisited[i][j] = true;
        }
        
        for(int i = 0; i < picture.length; i++) {
        	for(int j = 0; j < picture[0].length; j++) {
        		if(!isVisited[i][j] && picture[i][j] != 0) {
        			area++;
        			queue.add(new location(i, j, picture[i][j]));
        			tmp = coloring();
        			if(max < tmp) max = tmp;
        		}
        	}
        }
        
        answer[0] = area;
        answer[1] = max;
        return answer;
    }
    
    public int coloring() {
    	int answer = 0;
    	
    	while(!queue.isEmpty()) {
    		location node = queue.poll();
        	int r = node.x;
        	int c = node.y;
        	int color = node.color;
        	
        	for(int i = 0; i < 4; i++) {
        		if(0 <= (r + dr[i]) && (r + dr[i]) < pictureCopy.length && 0 <= (c + dc[i]) && (c + dc[i]) < pictureCopy[0].length && !isVisited[r+dr[i]][c+dc[i]] 
        				&& pictureCopy[r+dr[i]][c+dc[i]] == color) {
        			answer++;
        			isVisited[r + dr[i]][c + dc[i]] = true;
        			queue.add(new location(r + dr[i], c + dc[i], color));
        		}
        	}
    	}
    	return answer;
    }
}

public class P1829 {

}
