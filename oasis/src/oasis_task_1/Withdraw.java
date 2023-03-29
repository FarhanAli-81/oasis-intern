package oasis_task_1;

import java.util.Scanner;

public class Withdraw {
	public int with=0;
	
      
	public  static int withdraw (int  b) {
		
		System.out.print("enter withdraw amount : ");
		Scanner sc=new Scanner(System.in);
		int with=sc.nextInt();
		if(with>b) {
			System.out.println("insufficient balance");
			return -1;
		}
		else {
			return b-with;
		}
		
	}
	
	
}
