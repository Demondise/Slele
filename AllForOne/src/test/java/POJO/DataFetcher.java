package POJO;

public class DataFetcher {
	LoginCreds login;
	public DataFetcher(String dataType){
		if(dataType.equals("login")) {
			login = new LoginCreds();		
		}
	}
//	public Data getData() {
//		return data;
//	}
	

}
 `