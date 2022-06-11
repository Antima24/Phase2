package stepDefs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	WebDriver driver = BaseClass.driver;
	
	@Given("User is on the login page")
	public void user_is_on_the_login_page() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(6000);
		
	}

	@When("User enters username {string}")
	public void user_enters_username(String username) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement Username=driver.findElement(By.id("user-name"));
    	Username.sendKeys(username);
    
	}

	@When("User enters password {string}")
	public void user_enters_password(String password) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement Password=driver.findElement(By.id("password"));
    	Password.sendKeys(password);
	}

	@When("User clicks on Login button")
	public void user_clicks_on_Login_button() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement LoginBtn=driver.findElement(By.id("login-button"));
	    	LoginBtn.click();
	    }
	

	@Then("User should be landed on the Products Page")
	public void user_should_be_landed_on_the_Products_Page() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Logged in succesful and land on product page");

	}
   @Then("User should be getting the error message {string}")
   public void user_should_be_getting_the_error_message(String expectedMsg) {
    // Write code here that turns the phrase above into concrete actions
	   WebElement ErrorMsg = driver.findElement(By.xpath("//div[@class = 'error-message-container error']/h3"));
		String ActualMsg = ErrorMsg.getText();		
		
		Assert.assertEquals(ActualMsg, expectedMsg);
   }



	}


	

