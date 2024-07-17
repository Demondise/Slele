package POJO;

public class Product {
	String productName;
	String price;
	public Product(String productName2, String productPrice) {
	productName = productName2;
	price = productPrice;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public static ProductBuilder  getProductBuilder() {
		return new ProductBuilder();
	}
}
