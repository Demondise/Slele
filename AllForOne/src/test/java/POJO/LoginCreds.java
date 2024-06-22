package POJO;

import java.util.HashMap;

public class LoginCreds extends Data{
	private String email;
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	HashMap<String, String> getFilds() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("email", email);
		return null;
	}
	

}
