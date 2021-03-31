package team;

import java.util.LinkedList;
import java.util.Queue;

public class P1844 {

}

class mapNode {
	int x; 
	int y; 
	int count; //���İ� ��� ��
	
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
	static int max = 10001; // �ִ� ĭ ���� �־��� ���� ����
	
    public int solution(int[][] maps) {
        this.maps = maps;
        
        isVisited = new boolean[maps.length][maps[0].length];
        
        bfs();
        
        return max;
    }
    
    void bfs() {
    	
    	q.add(new mapNode(0,0,0));
        isVisited[0][0] = true; // 0,0 ��ġ���� ����
    	
    	while (!q.isEmpty()) {
    		
    		mapNode node = q.poll();
    		int nodeX = node.x;
    		int nodeY = node.y;
    		int nodeCount = node.count;
    		
    		if (nodeX == maps.length-1 && nodeY == maps[0].length-1 && max > node.count) { // �������� �����ϰ� �����Ŀ� ĭ�� ������ max ������ ������
    			max = node.count + 1; // �ּڰ� ����
    		}
    	
    		if (0 <= nodeY - 1 && nodeY - 1 <= maps[0].length-1 && maps[nodeX][nodeY-1] == 1 && !isVisited[nodeX][nodeY-1]) {
    			isVisited[nodeX][nodeY-1] = true;
    			q.add(new mapNode(nodeX, nodeY-1 ,nodeCount+1));
    		}// ��
    	
    		if (0 <= nodeY + 1 && nodeY + 1 <= maps[0].length-1 && maps[nodeX][nodeY+1] == 1 && !isVisited[nodeX][nodeY+1]) {
    			isVisited[nodeX][nodeY+1] = true;
    			q.add(new mapNode(nodeX ,nodeY+1 ,nodeCount+1));
    		}// ��

    		if (0 <= nodeX + 1 && nodeX + 1 <= maps.length-1 && maps[nodeX+1][nodeY] == 1 && !isVisited[nodeX+1][nodeY]) {
    			isVisited[nodeX+1][nodeY] = true;
    			q.add(new mapNode(nodeX+1, nodeY, nodeCount+1));
    		}// ��
    	
    		if (0 <= nodeX - 1 && nodeX - 1 <= maps.length-1 && maps[nodeX-1][nodeY] == 1 && !isVisited[nodeX-1][nodeY]) {
    			isVisited[nodeX-1][nodeY] = true;
    			q.add(new mapNode(nodeX-1, nodeY, nodeCount+1));
    		}// ��
    	}
    	
    	if (q.isEmpty() && max == 10001) max = -1; // q�� ������� �ּڰ� ������ �ȵȰ�� ������ �� �������� �߷�
 
    	
    	
    }
}