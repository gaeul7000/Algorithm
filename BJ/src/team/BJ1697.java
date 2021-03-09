package team;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;

/* N0.5
 * 2021.3 2주차
 * 
 */

class Node{
	int position;
	int count;
	
	public Node(int position, int count) {
		this.position = position;
		this.count = count;
	}
}


class Solution3{
	public int solution(int n, int m) {
		int answer=0;
		final int MAX = 100001;
		int count=0;
		boolean[] isVisited = new boolean[MAX]; //방문은 true
		
		Queue<Node> q = new LinkedList<Node>();
		
		q.add(new Node(n,count));
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			int pos = node.position;
			int cot = node.count;

			if(pos == m) {
				answer = node.count;
				break;
			}
			/*
			if(!isVisited[pos-1]&&pos-1>=0) {
				isVisited[pos-1] = true;
				q.add(new Node(pos-1,cot+1));
			}
			if(!isVisited[pos+1]&&pos+1<MAX) {
				isVisited[pos+1] = true;
				q.add(new Node(pos+1,cot+1));
			}
			if(!isVisited[pos*2]&&pos*2<MAX) {
				isVisited[pos*2] = true;
				q.add(new Node(pos*2,cot+1));
			}
			*/
			
			if(pos-1>=0&&!isVisited[pos-1]) {
				isVisited[pos-1] = true;
				q.add(new Node(pos-1,cot+1));
			}
			if(pos+1<MAX&&pos+1<m&&!isVisited[pos+1]) { //개멍청이인부분 : pos+1과 pos*2는 당연히 MAX값을 넘어갈 가능성이 있고, 
														//바운드를 넘어간 인덱스를 참조하면 당연히 에러가난다요.
														//인덱스값을 먼저 구하고 범위를 넘어갈경우 해당 조건을 아예 타지 않게해야지!!!!!!!!!!!!!!!!!
				isVisited[pos+1] = true;
				q.add(new Node(pos+1,cot+1));
			}
			if(pos*2<MAX&&pos*2<m&&!isVisited[pos*2]) {
				isVisited[pos*2] = true;
				q.add(new Node(pos*2,cot+1));
			}
			
			
		}
				
		
		return answer;
	}
	
}

public class BJ1697 {

}
