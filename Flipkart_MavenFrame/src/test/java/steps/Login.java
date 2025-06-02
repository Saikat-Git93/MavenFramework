package steps;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import common.OTPReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login extends Base {

	@Given("User navigate to the URL {string}")
	public void user_navigate_to_the_url(String URL) {
		WebDriverManager.chromedriver().setup();
		dv = new ChromeDriver();
		dv.manage().window().maximize();
		dv.get(URL);
		dv.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));

	}

	@Then("Validate the Page Title {string}")
	public void validate_the_page_title(String ExpTitle) {
		String ActTitle = dv.getTitle();
		System.out.println("Expected Title: " + ExpTitle);
		System.out.println("Actual Title: " + ActTitle);
		Assert.assertEquals("Expected Title is Not Matched with the Actual TItle", ExpTitle, ActTitle);
	}

	@Then("Close the Browser")
	public void close_the_browser() {
		dv.quit();
	}

	@When("User navigate to the login page")
	public void user_navigate_to_the_login_page() throws InterruptedException {

		dv.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
		dv.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));

	}

	@Then("User enter the Admin and Pass")
	public void user_enter_the_admin_and_pass() throws InterruptedException {
		dv.findElement(By.xpath("//div[@class='Sm1-5F col col-3-5']/div/form/div/input"))
				.sendKeys("saisil.inbox@gmail.com");
		Thread.sleep(2000);
		dv.findElement(By.xpath("//button[contains(text(),'Request OTP')]")).click();
		Thread.sleep(10000); 
        // Get OTP from email
        String otp = OTPReader.getOtpFromEmail(
                "imap.gmail.com", "imap", "saisil.inbox@gmail.com", "ouue tuoe ndsy foaf");
        //Print the OTP
        System.out.println("Received OTP: " + otp);
        List<WebElement> otpFields = dv.findElements(By.xpath("//div[@class='XDRRi5']/div/input"));
        for(int i=0;i<=otpFields.size();i++) {
        	otpFields.get(i).sendKeys(String.valueOf(otp.charAt(i)));

        }
        dv.findElement(By.xpath("//button[contains(text(),'Verify')]")).click();

	}

	@And("Click on the login button")
	public void click_on_the_login_button() {

	}

	@Then("Check if the user navigate to the after login page")
	public void check_if_the_user_navigate_to_the_after_login_page() {

	}
	
	@Then("Logout")
	public void logout() {
	    
		
	}

}
