package alone;

import java.io.*;
import java.util.Stack;

/* N0.7
 * 2021.3 4ÁÖÂ÷
 * 
 */

public class BJ2606 {
	static Stack<Integer> stack = new Stack<>();
	static int computer;
	static boolean[][] network;
	static boolean[] isVisited;
	static int count = 0;
	
	public static int dfs(int n) {

		if (isVisited[n]==false) {
			stack.push(n);
			isVisited[n] = true;
		}
		
		while (!stack.isEmpty()) {
			for (int i = 1; i < computer+1; i++) {
				if (network[n][i] == true && isVisited[i] == false) {
					stack.push(i);
					isVisited[i] = true;
					
					dfs(i);
				}
			}
			
			stack.pop();
			count++;
			break;
		}
	
		return count-1;
		
	}
	
	public static void main(String []args) throws NumberFormatException, IOException {
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		computer = Integer.parseInt(bufferedReader.readLine());
		
		int contact = Integer.parseInt(bufferedReader.readLine());
		
		network = new boolean[computer+1][computer+1];
		
		String[] pair = new String[2];
		isVisited = new boolean[computer];
		
		for (int i = 0; i < contact; i++) {
			pair = bufferedReader.readLine().split(" ");
			network[Integer.parseInt(pair[0])][Integer.parseInt(pair[1])] = true;
			network[Integer.parseInt(pair[1])][Integer.parseInt(pair[0])] = true;
		}
		
		
		int answer = dfs(1);
		
		System.out.println(answer);
	}

}
