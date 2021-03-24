package team;

import java.io.*;
import java.util.Stack;

/* N0.7
 * 2021.3 4ÁÖÂ÷
 * 
 */

public class BJ15900 {
	static Stack<Integer> stack = new Stack<>();
	static int nodeCount;
	static boolean[] isVisited = new boolean[nodeCount+1];
	static boolean[][] tree;
	static int sum = 0; 
	
	public static void dfs(int n) {
		
		int count = 0;
		
		if (isVisited[n] == false) {
			stack.push(n);
			isVisited[n] = true;
		}
		
		while (!stack.isEmpty()) {
			for (int i = 1; i <= nodeCount; i++) {
				if (tree[n][i] == true && isVisited[i] == false) {
					stack.push(i);
					isVisited[i] = true;
					dfs(i);
				} else count++;
			}
			
			if (count == nodeCount) {
				sum += stack.size()-1;
			}
			
			stack.pop();
			break;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
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
		
		dfs(1);
		
		if (sum % 2 == 0) {
			System.out.println("No");
		} else {
			System.out.println("Yes");
		}
	}

}
