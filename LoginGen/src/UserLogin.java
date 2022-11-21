import java.util.Scanner;

public class UserLogin {
	
	private static final String Login = "admin";
	private static final String Password = "paSSword";

	public static void main(String[] args) {
		Scanner S = new Scanner(System.in);
		
		for(int i = 4;i>=1;i--) {
		System.out.println("Enter username: ");
		String username = S.next();
		System.out.println("Enter password: ");
		String passWord = S.next();
		
		
		if(execute(username, passWord) == 1) {//code 1 returned from function meaning access granted
			break;//exists the loop early as access granted
		}
		else if(i-1>0){
			System.out.println();
			System.out.println("Warning! "+(i-1)+" attempts left then account will lock!");
			System.out.println();
		}
		else {
			System.out.println();
			System.out.println("THIS ACCOUNT HAS NOW BEEN LOCKED!");
		}
		}
		
		S.close();//ensures scanner is closed to prevent data leak from inputstream

	}
	
	public static int execute(String login, String password) {
		if(login.equals(Login) && password.equals(Password)) {
			System.out.println("Access Granted!");
			return 1;//code value to let system know the outcome, 1 = success
			         //0 = failure
		}
		else if(login.equals(Login) && !password.equals(Password)) {
			System.out.println("Error! The Password is incorrect");
			return 0;
		}
		else {
			System.out.println("Error the username does not exist!");
			return 0;
		}
	}

}
