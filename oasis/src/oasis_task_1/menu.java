package oasis_task_1;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to ATM interface....... ");
		
		Queue<String>historyQueue=new LinkedList<String>();
		System.out.println("enter user name : ");
		String user=sc.next();
		System.out.println("enter password : ");
		String pass=sc.next();
		
		
		int balance=Check.find(user, pass);
		if(balance!=-1) {
			
			System.out.println("login successfull !!");
			boolean loop=true;
			while(loop) {
				System.out.println("   1...........deposit ");
				System.out.println("   2...........withdraw");
				System.out.println("   3...........transaction history");
				System.out.println("   4...........transfer");
				System.out.println("   5...........Quit");
				System.out.print("enter your choice: ");
				int choice=sc.nextInt();
				switch (choice) {
				case 1:
					int preBalance=balance;
				    balance=Deposit.deposit(balance);
				    historyQueue.add("Deposited Rs. "+" "+(balance-preBalance));
				    System.out.println("amount deposited....");
				    
				    break;
				case 2:
					
					int prevBalance=balance;
				    int val=Withdraw.withdraw(balance);
				    if(val!=-1) {
				    	balance=val;
				    	historyQueue.add("Withdrawn Rs. "+" "+(balance-prevBalance));
					    System.out.println(".......collect your cash");
				    }
			
					break;
					
				case 3:
					System.out.println("             .........Transactions.......");
					Transation.t(historyQueue);
					
					break;
				case 4: 
					
				    System.out.print("enter account number to transfer :");
				    int ac=sc.nextInt();
				   System.out.print("enter amount to transfer : ");
				    int trans=sc.nextInt();
				    System.out.println("-------Amount transfered to "+ac);
				    balance=balance-trans;
				    historyQueue.add("transferd Rs. "+trans+" to "+ac);
				    break;
				case 5:
					default:
						System.out.println("---------thank you--------------");
					loop=false;
					
				
					
					
				}
				
			}
			
			
		}
		else {
			System.out.println("Invalid username or password");
		}
		
		
	}
	

}
