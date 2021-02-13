package team;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class BJ1966 {
	public static void main(String []arg) {
		
		Scanner scanner = new Scanner(System.in);
		
		int testCount = scanner.nextInt(); //test case ����
		int[] result = new int[testCount];
		for(int i=0;i<testCount;i++) {
			Scanner scanner2 = new Scanner(System.in);
			int index = scanner2.nextInt(); //�����Ϳ� �� ���� ����
			int resultIndex = scanner2.nextInt(); //�˰��� �ϴ� ������ ����
						
			int[] documents = new int[index];
			for(int j=0;j<documents.length;j++) {
				documents[j] = scanner2.nextInt();
			}
			
			Integer[] sortedDocuments = new Integer[index]; //������ ������������ ������ �迭 ����
			for(int j=0;j<documents.length;j++) {
				sortedDocuments[j] = documents[j];
			}
			Arrays.sort(sortedDocuments, Collections.reverseOrder());
			
			for(int j=0;j<documents.length;j++) {
				if(documents[resultIndex]==sortedDocuments[j]) {
					result[i] = j+1;
				}
			}			

		}
		
		for(int i=0;i<testCount;i++) {
			System.out.println(result[i]);
		}
		

		
		
		
	}

}
