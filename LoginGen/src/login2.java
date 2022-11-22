import java.util.HashMap;

public class login2 {

	public HashMap<String, String> loginData = new HashMap<>();
	
	public void genRandLoginData() {//adds rnadom login data
		loginData.put("chipmunks69", "Teamaqua12");//adding 4 entries for username and password
		loginData.put("bax212", "fatboySlim919");//to the hashmap
		loginData.put("hannahv12", "yrugae");
		loginData.put("legend27", "tooRich!");
		
		//System.out.println(loginData.get("bax212"));
		//System.out.println(loginData.containsValue("tooRich!"));
		//System.out.println(loginData.containsKey("tooRich!"));
	}
	
	
}
