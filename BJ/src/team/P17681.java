package team;

import java.io.*;

/* N0.2
 * 2021.2 3ÁÖÂ÷
 * 
 */

public class P17681 {
	public static void main(String []args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bufferedReader.readLine());
		String[] arr1 = bufferedReader.readLine().split(" ");
		String[] arr2 = bufferedReader.readLine().split(" ");
		
		String[][] arr1_b = new String[n][n]; 
		for(int i=0;i<n;i++) {
			arr1[i] = Integer.toBinaryString(Integer.parseInt(arr1[i]));
			arr2[i] = Integer.toBinaryString(Integer.parseInt(arr2[i]));
			
		}
		
	}

}
