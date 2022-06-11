package stepDefs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSteps {
	
	WebDriver driver = BaseClass.driver;
	
	@When("User enters Username {string} and Password {string}")
	public void user_enters_Username_and_Password(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement UserName = driver.findElement(By.name("user-name"));
		UserName.sendKeys("standard_user");
		
		WebElement Password = driver.findElement(By.name("password"));
		Password.sendKeys("secret_sauce");
		
			}
	

	@When("User is on Products Page")
	public void user_is_on_Products_Page() {
	    // Write code here that turns the phrase above into concrete actions
		String ExpTitle="PRODUCTS";
    	WebElement product=driver.findElement(By.xpath("//span[@class='title']"));
    	String actual=product.getText();
    	Assert.assertEquals(ExpTitle, actual);
    	System.out.println("User is on Products Page");  
	
	}
	

	@Then("User compare the following products price")
	public void user_compare_the_following_products_price(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	        int rows = dataTable.height();
			for(int i=0;i<rows;i++) {
				
				String product= dataTable.cell(i, 0);
				String price= dataTable.cell(i, 1);
				String actualprice=driver.findElement(By.xpath("//div[text()='"+product+"']/following::div[@class='inventory_item_price'][1]")).getText();
				Assert.assertEquals(price, actualprice);
			}
	}



	
			
	}
	




