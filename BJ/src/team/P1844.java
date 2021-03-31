package team;

import java.util.LinkedList;
import java.util.Queue;

public class P1844 {
	public static void main(String[] args) {
		Solution s = new Solution();
		
		int[][] m = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		
		int anw = 0;
		
		anw = s.solution(m);
		
		System.out.println(anw);
	}

}

class mapNode {
	int x;
	int y;
	int count;
	
	public mapNode (int x, int y, int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}
}

class Solution {
	static Queue<mapNode> q = new LinkedList<>();
	static boolean[][] isVisited;
	static int[][] maps;
	static int max = 10000;
    public int solution(int[][] maps) {
        int answer = 0;
        
        this.maps = maps;
        
        isVisited = new boolean[maps.length][maps[0].length];
        q.add(new mapNode(0,0,0));
        isVisited[0][0] = true;
        bfs(0,0,0);
        
        answer = max;
        
        return answer;
    }
    
    void bfs(int x, int y, int count) {
    	
    	mapNode node = q.poll();
    	
    	if(x==4&&y==4&&max<count) {
    		max = count;
    	}
    	
    	while(node.x<=4||node.y<=4) {
    		
    	if(0<=node.x-1&&node.x-1<=4&&maps[x-1][y]==1&&!isVisited[x-1][y]) {
    		isVisited[x-1][y] = true;
    		q.add(new mapNode(x-1,y,count++));
    		bfs(x-1,y,count);
    	}// µ¿
    	
    	if(0<=node.x+1&&node.x+1<=4&&maps[x+1][y]==1&&!isVisited[x+1][y]) {
    		isVisited[x+1][y] = true;
    		q.add(new mapNode(x+1,y,count++));
    		bfs(x+1,y,count);
    	}// ¼­
    	
    	if(0<=node.y-1&&node.y-1<=4&&maps[x][y-1]==1&&!isVisited[x][y-1]) {
    		isVisited[x][y-1] = true;
    		q.add(new mapNode(x,y-1,count++));
    		bfs(x,y-1,count);
    	}// ³²
    	
    	if(0<=node.y+1&&node.y+1<=4&&maps[x][y+1]==1&&!isVisited[x][y+1]) {
    		isVisited[x][y+1] = true;
    		q.add(new mapNode(x,y+1,count++));
    		bfs(x,y+1,count);
    	}// ºÏ
    	
    	
    	
    	}

    	
    	
    	
    	
    	
    	
    }
}