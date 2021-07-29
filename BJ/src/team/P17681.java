package team;

import java.io.*;
import java.util.Arrays;

/* N0.2
 * 2021.2 3ÁÖÂ÷
 * 
 */
// 비밀지도 구하기
public class P17681 {
	public static void main(String []args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bufferedReader.readLine());
		String[] arr1 = bufferedReader.readLine().split(" ");
		String[] arr2 = bufferedReader.readLine().split(" ");
		
		String[] result_s = new String[n];
		String[][] result_b = new String[n][n];
		
		int[] arr1_n = Arrays.stream(arr1).mapToInt(Integer::parseInt).toArray();
		int[] arr2_n = Arrays.stream(arr2).mapToInt(Integer::parseInt).toArray();

		for(int i=0;i<n;i++) {
			result_s[i] = Integer.toString(arr1_n[i]|arr2_n[i]);
			
			result_s[i] = String.format("%0"+n+"d", Integer.parseInt(Integer.toBinaryString(Integer.parseInt(result_s[i]))));
			result_b[i] = result_s[i].split("");
		}
		

		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(result_b[i][j].equals("1")) {
					System.out.print("#");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println("");
		}

	}

}
