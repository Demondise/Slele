package abstractComponents;

public enum ApiResources {
	Login("/api/ecom/auth/login");
	private String resource;
	ApiResources(String resources) {
		this.resource = resource;
	}
	
	public String getResource() {
		return resource;
	}
}
