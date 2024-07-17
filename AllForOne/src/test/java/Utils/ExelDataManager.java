package Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import POJO.Product;
import POJO.Products;

public class ExelDataManager {
	
	public static void setDataExel(Products products) throws InvalidFormatException, IOException { 
		XSSFWorkbook dataFile = new XSSFWorkbook();
		Sheet sheet = dataFile.createSheet("Products");
		Row headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("Product Name");
		headerRow.createCell(1).setCellValue("Price");
		List<Product> product = products.getProducts();
	    AtomicInteger count = new AtomicInteger(1);
		product.stream().forEach(s->{Row row = sheet.createRow(count.getAndIncrement());
		row.createCell(0).setCellValue(s.getProductName());
		row.createCell(1).setCellValue(s.getPrice());
		});
		dataFile.write(new FileOutputStream(new File("C:\\Users\\shivam_shar\\git\\Slele\\AllForOne\\Data.xlsx")));
	}
	public static Products getDataExel() throws InvalidFormatException, IOException {
		XSSFWorkbook dataFile = new XSSFWorkbook(new File("C:\\Users\\shivam_shar\\git\\Slele\\AllForOne\\Data.xlsx"));
		Sheet sheet = dataFile.getSheet("Products");
		List<String> rows = new ArrayList<String>();
		List<Product> productList = new ArrayList<Product>();
		for(Row row : sheet) {
			for(Cell cell : row) {
				rows.add(cell.getStringCellValue());
			}
			productList.add(Product.getProductBuilder().name(rows.get(0)).price(rows.get(1)).build());
		}
		productList.remove(0);
		Products products = new Products();
		products.setProducts(productList);
		return products;
	}
}
