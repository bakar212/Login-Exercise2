import java.util.HashMap;
import java.util.Scanner;

public class UserLogin {
	
	private static final String Login = "admin";
	private static final String Password = "paSSword";
	public static login2 l2 = new login2();//l2 class initialisation

	public static void main(String[] args) {
		Scanner S = new Scanner(System.in);
		
		for(int i = 4;i>=1;i--) {//for loop to repeat 4 times, essentially giving user 3 extra chances to log in 
			//should they fail to login the first time
		System.out.println("Enter username: ");
		String username = S.next().toLowerCase();//converts to lower case as it is not case sensitive
		System.out.println("Enter password: ");
		String passWord = S.next();
		
		//keeps repeating process every loop unless login is successful
		if(executeB(username, passWord) == 1) {//code 1 returned from function meaning access granted
			break;//exists the loop early as access granted
		}
		else if(i-1>0){//until counter is not 0 give user a message of attempts remaining
			System.out.println();
			System.out.println("Warning! "+(i-1)+" attempts left then account will lock!");
			System.out.println();
		}
		else {//no more chances to login!
			System.out.println();
			System.out.println("THIS ACCOUNT HAS NOW BEEN LOCKED!");
		}
		}
		
		S.close();//ensures scanner is closed to prevent data leak from inputstream
		
	
	}
	//tests login inputs against default data
	public static int executeA(String login, String password) {
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
	//tests login inputs against generated hashMap data
	public static int executeB(String login, String password) {
		
		l2.genRandLoginData();//initialises class 'l2' with a random hashmap dataset of login data
		HashMap<String, String> database = l2.loginData;//retrievs the hashmap from l2 class with our login data
		
		if(database.containsKey(login) && database.get(login).equals(password)) {//first condition checks whether the login
			System.out.println("Access Granted!");//input exists in our database, and then whether the password input matches
			//with the value in our database
			
			return 1;//code value to let system know the outcome, 1 = success
			         //0 = failure
		}
		else if(database.containsKey(login) && !database.get(login).equals(password)) {//second condition checks whether the login
			System.out.println("Access Granted!");//input exists in our database, however the password input  does not match
			//with the value in our database
			System.out.println("Error! The Password is incorrect");
			return 0;
		}
		else {//for all other consitions
			System.out.println("Error the username does not exist!");
			return 0;
		}
	}

}
