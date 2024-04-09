package testUtils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

Properties pro;
	public ReadConfig() {
		File src =new File("./Configuration/config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
			
		}catch(Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
	}
	
	public String getWebApplicationUrl() {
		String url=pro.getProperty("baseUrl");
		return url;
	}
	
	public String browserSelection() {
		String browsername=pro.getProperty("browser");
		return browsername;
	}
	
	public int implicitDurationcount() {
	    String durationString = pro.getProperty("Duration");
	    
	    // Handle the case where the property value is not a valid integer
	    try {
	        int waits = Integer.parseInt(durationString);
	        return waits;
	    } catch (NumberFormatException e) {
	       
	        e.printStackTrace(); 
	        return 0; 
	    }
	}
	
	public String SearchProduct() {
		String searchProductt=pro.getProperty("SearchProduct");
		return searchProductt;
	}
	
	public String SearchProduct_2() {
		String searchProduct=pro.getProperty("SearchProduct2");
		return searchProduct;
	}
	
	public String Pincode() {
		String Pincode=pro.getProperty("pincode");
		return Pincode;
	}
	
	public String ProductPrice() {
		String ProductPrice=pro.getProperty("productprice");
		return ProductPrice;
	}
	public String productReview() {
		String ProductReview=pro.getProperty("productReview");
		return ProductReview;
	}
	
	public String ReviewCount() {
		String reviewCount=pro.getProperty("ReviewCount");
		return reviewCount;
	}
}
