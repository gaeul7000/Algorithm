package alone;

import java.io.*;
import java.math.BigDecimal;

/* N0.2
 * 2021.2 3ÁÖÂ÷
 * 
 */


public class BJ1009 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(bufferedReader.readLine());
		BigDecimal[] result = new BigDecimal[testCase];

		for(int i=0;i<testCase;i++) {
			
			String[] n = bufferedReader.readLine().split(" ");
			
			BigDecimal B1 = new BigDecimal(Integer.parseInt(n[0]));
			int B2 = Integer.parseInt(n[1]);
			BigDecimal count = new BigDecimal(10);

			BigDecimal pow = B1.pow(B2);
			
			result[i] = pow.remainder(count);
		}
		for(int i=0;i<testCase;i++) {
			System.out.println(result[i]);
		}
	}
	

}
