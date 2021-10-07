package alone;

import java.io.*;

public class BJ9095_rec {
	public static int rec(int n) {

		if(n==1) {
			return 1;
		}else if(n==2) {
			return 2;
		}else if(n==3) {
			return 4;
		}else {
			return rec(n-1)+rec(n-2)+rec(n-3);
		}
	}
	
	public static void main(String[] args) throws Exception{

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		int input = Integer.parseInt(bufferedReader.readLine());
		int answer = rec(input);
		
		System.out.println(answer);
	}

}
