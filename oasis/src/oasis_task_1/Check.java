package oasis_task_1;

public class Check {
    private static String[] user_passwords = {"Farhan12345", "Shakir12345","Sravan12345", "Afsar12345","bhaskar12345","Sameer12345"};       
		
   static int[] balances= {123000, 45000,50000, 90000, 250000};
   public static int find(String user, String pass) {
		// TODO Auto-generated method stub
		for(int i=0; i<user_passwords.length; i++) {
			if(user_passwords[i].equals(user+pass)) {
				
				return balances[i];
			}
		}
		return -1;
	}
}
