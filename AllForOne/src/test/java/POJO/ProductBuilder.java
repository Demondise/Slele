package POJO;

public class ProductBuilder {
	String productName;
	String productPrice;
	
	public ProductBuilder name(String Name) {
		productName = Name;
		return this;
	}
	public ProductBuilder price(String Name) {
		productPrice = Name;
		return this;
	}
	public Product build() {
		return new Product(productName,productPrice);
	}


}
