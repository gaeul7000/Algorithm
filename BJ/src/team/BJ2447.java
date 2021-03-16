package team;

import java.io.*;

public class BJ2447 {
	static String[][] square;
	
	public static void star(int x, int y, int n) {
		int m = n/3;
		
		if(n == 1) {
			square[x][y] = "*";
			return;
		}
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3;j++) {
				if(i == 1 && j == 1) continue;
				star(m * i + x, m * j + y, m);
			}
		}
	}
	
	
	public static void main(String []args) throws Exception {
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bufferedReader.readLine());
		
		square = new String[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				square[i][j] = " ";
			}
		}
		
		star(0,0,n);
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(square[i][j]);
			}
			System.out.println(" ");
		}
		

	}
}
