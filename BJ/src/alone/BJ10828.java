package alone;

import java.util.Scanner;

/* N0.1
 * 2021.2 2ÁÖÂ÷
 * 
 */


public class BJ10828 {
	static public int index = 0;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int stackSize = scanner.nextInt();
		int[] stack = new int[stackSize];
		String command;
		int pushNumber;
		
		while(stackSize>0) {
		
			command = scanner.next();
			
			if(command.equals("push")) {
				pushNumber = scanner.nextInt();
				push(stack, pushNumber);
			}else if(command.equals("pop")){
				pop(stack);
			}else if(command.equals("size")) {
				size();
			}else if(command.equals("empty")) {
				empty();
			}else if(command.equals("top")) {
				top(stack);
			}
			
			stackSize--;
		}
	}

	static void push(int arr[], int x) {
		index++;
		arr[index] = x;

	}

	static void pop(int arr[]) {
		if(index == 0) {
			System.out.println("-1");
		} else {
			System.out.println(arr[index]);
			
			index -= 1;
		}
		
	}
	
	static void size() {
		System.out.println(index);
	}
	
	static void empty() {
		if(index==0) {
			System.out.println("1");
		}else {
			System.out.println("0");
		}
	}
	
	static void top(int arr[]) {
		if(index==0) {
			System.out.println("-1");
		}else {
			System.out.println(arr[index]);
		}
	}
	
}