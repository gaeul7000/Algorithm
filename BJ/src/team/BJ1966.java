package team;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class BJ1966 {
	public static void main(String []arg) {
		
		Scanner scanner = new Scanner(System.in);
		
		int testCount = scanner.nextInt(); //test case 개수
		int[] result = new int[testCount];
		for(int i=0;i<testCount;i++) {
			Scanner scanner2 = new Scanner(System.in);
			int index = scanner2.nextInt(); //프린터에 들어갈 문서 갯수
			int resultIndex = scanner2.nextInt(); //알고자 하는 문서의 순서
						
			int[] documents = new int[index];
			for(int j=0;j<documents.length;j++) {
				documents[j] = scanner2.nextInt();
			}
			
			Integer[] sortedDocuments = new Integer[index]; //문서를 내림차순으로 정렬할 배열 선언
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
