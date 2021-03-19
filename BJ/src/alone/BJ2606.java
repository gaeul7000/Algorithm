package alone;

import java.io.*;
import java.util.Stack;

/* N0.6
 * 2021.3 3주차
 * 
 */

public class BJ2606 {
	static Stack<Integer> stack = new Stack<>();
	static int computer;
	static boolean[][] network;
	static boolean[] isVisited;
	
	public static void dfs(int n) {

		System.out.println(n);
		
		stack.push(n);
		System.out.println("들어간다"+stack.peek()+"이거");
		isVisited[n] = true;
		
		while(!stack.isEmpty()) {
			for(int i=1;i<computer+1;i++) {
				if(network[n][i]==true&&isVisited[i]==false) {
					
					stack.push(i);
					System.out.println("들어간다포"+stack.peek()+"이거");
					isVisited[i] = true;
					dfs(i);
				}
			}
			System.out.println("나온당"+stack.peek()+"이거");
			stack.pop();
		}
	
		
	}
	
	public static void main(String []args) throws NumberFormatException, IOException {
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		computer = Integer.parseInt(bufferedReader.readLine());
		
		int contact = Integer.parseInt(bufferedReader.readLine());
		
		network = new boolean[computer+1][computer+1];
		
		String[] pair = new String[2];
		isVisited = new boolean[computer];
		
		for(int i=0; i<contact; i++) {
			pair = bufferedReader.readLine().split(" ");
			network[Integer.parseInt(pair[0])][Integer.parseInt(pair[1])] = true;
			network[Integer.parseInt(pair[1])][Integer.parseInt(pair[0])] = true;
		}
		
		
		dfs(1);
	}

}
