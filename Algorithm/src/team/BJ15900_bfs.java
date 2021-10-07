package team;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/* N0.7
 * 2021.3 4ÁÖÂ÷ _ 2
 * 
 */

class treeNode {
	int var;
	int position;
	
	public treeNode(int v, int p) {
		this.var = v;
		this.position = p;
	}
}

public class BJ15900_bfs {
	static Queue<treeNode> queue = new LinkedList<>();
	static int nodeCount;
	static boolean[][] tree;
	static boolean isVisited[];
	
	public static int bfs(int n) {
		
		int position = 0;
		int count = 0;
		int answer = 0;
		
		queue.add(new treeNode(n,position));
		isVisited[n] = true;
		
		while(!queue.isEmpty()) {
			
			treeNode node = queue.poll();
			count = 0;
			
			for(int i = 1; i <= nodeCount; i++) {
				if(tree[node.var][i] == true && isVisited[i] == false) {
					
					isVisited[i] = true;
					queue.add(new treeNode(i,node.position+1));
					
				} else count++;
			}
			
			
			if(count == nodeCount) {
				answer += node.position;
			}
			
		}
		
		return answer;
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		nodeCount = Integer.parseInt(bufferedReader.readLine());
		
		String[] edge = new String[2];
		
		tree = new boolean[nodeCount+1][nodeCount+1];
		isVisited = new boolean[nodeCount+1];
		
		for(int i = 1; i < nodeCount; i++) {
			edge = bufferedReader.readLine().split(" ");
			tree[Integer.parseInt(edge[0])][Integer.parseInt(edge[1])] = true;
			tree[Integer.parseInt(edge[1])][Integer.parseInt(edge[0])] = true;
		}
		
		int answer = bfs(1);
		
		if (answer % 2 == 0) {
			System.out.println("No");
		} else {
			System.out.println("Yes");
		}
	}

}
