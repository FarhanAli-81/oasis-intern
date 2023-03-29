package oasis_task_1;

import java.util.Scanner;

public class Deposit {
           
	static Scanner sc=new Scanner(System.in);
	public static int deposit(int  b) {
		System.out.print("enter deposit amount : ");
		
		int depo=sc.nextInt();
		return depo+b;
	}

	


}
