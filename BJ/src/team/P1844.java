package team;

import java.util.LinkedList;
import java.util.Queue;

public class P1844 {

}

class mapNode {
	int x; 
	int y; 
	int count; //거쳐간 노드 수
	
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
	static int max = 10001; // 최대 칸 수를 최악의 경우로 산정
	
    public int solution(int[][] maps) {
        this.maps = maps;
        
        isVisited = new boolean[maps.length][maps[0].length];
        
        bfs();
        
        return max;
    }
    
    void bfs() {
    	
    	q.add(new mapNode(0,0,0));
        isVisited[0][0] = true; // 0,0 위치부터 시작
    	
    	while (!q.isEmpty()) {
    		
    		mapNode node = q.poll();
    		int nodeX = node.x;
    		int nodeY = node.y;
    		int nodeCount = node.count;
    		
    		if (nodeX == maps.length-1 && nodeY == maps[0].length-1 && max > node.count) { // 목적지에 도달하고 지나쳐온 칸의 개수가 max 값보다 작을때
    			max = node.count + 1; // 최솟값 갱신
    		}
    	
    		if (0 <= nodeY - 1 && nodeY - 1 <= maps[0].length-1 && maps[nodeX][nodeY-1] == 1 && !isVisited[nodeX][nodeY-1]) {
    			isVisited[nodeX][nodeY-1] = true;
    			q.add(new mapNode(nodeX, nodeY-1 ,nodeCount+1));
    		}// 동
    	
    		if (0 <= nodeY + 1 && nodeY + 1 <= maps[0].length-1 && maps[nodeX][nodeY+1] == 1 && !isVisited[nodeX][nodeY+1]) {
    			isVisited[nodeX][nodeY+1] = true;
    			q.add(new mapNode(nodeX ,nodeY+1 ,nodeCount+1));
    		}// 서

    		if (0 <= nodeX + 1 && nodeX + 1 <= maps.length-1 && maps[nodeX+1][nodeY] == 1 && !isVisited[nodeX+1][nodeY]) {
    			isVisited[nodeX+1][nodeY] = true;
    			q.add(new mapNode(nodeX+1, nodeY, nodeCount+1));
    		}// 남
    	
    		if (0 <= nodeX - 1 && nodeX - 1 <= maps.length-1 && maps[nodeX-1][nodeY] == 1 && !isVisited[nodeX-1][nodeY]) {
    			isVisited[nodeX-1][nodeY] = true;
    			q.add(new mapNode(nodeX-1, nodeY, nodeCount+1));
    		}// 북
    	}
    	
    	if (q.isEmpty() && max == 10001) max = -1; // q는 비었지만 최솟값 갱신이 안된경우 도달할 수 없었음을 추론
 
    	
    	
    }
}