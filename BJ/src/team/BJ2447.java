package team;

public class BJ2447 {
	
	public static void star(String[][] s, int n) {
			for(int i=n-1; i>=0; i--) {
				for(int j=n-1; j>=0; j--) {
					if(j%3==1&&i%3==1) s[i][j] = " ";
					else if(n/3<=j&&j<n-n/3&&n/3<=i&&i<n-n/3) s[i][j] = " ";
					else s[i][j] = "*";
					}
				}

		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(s[i][j]);
			}
			System.out.println(" ");
		}
	}
	

	
	public static void main(String []args) {
		String[][] answer = new String[27][27];
		
		star(answer, 27);
	}
}
