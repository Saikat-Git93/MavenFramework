package steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.Home_Page;
import utils.CommonUtils;

public class HomePageSteps {
	WebDriver driver;
	Home_Page HomePage;
	
	
	@Before // or use constructor injection if using PicoContainer
    public void setup() {
        driver = BaseClass.getDriver(); // or however you get your WebDriver
        HomePage = new Home_Page(driver); // ✅ pass initialized driver
    }
	

	@Given("I navigate to the demoqa homepage URL {string}")
	public void i_navigate_to_the_demoqa_homepage_url(String URL) {
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
	}

	@Then("the page title should be {string}")
	public void the_page_title_should_be(String ExpPageTitle) {
		String ActualTitle = driver.getTitle();
		System.out.println("ActualTitle: " + ActualTitle);
		System.out.println("ExpPageTitle: " + ExpPageTitle);
		CommonUtils.assertEquals("Home Page Title :", ActualTitle, ExpPageTitle);
	}

	@Then("the URL should contain {string}")
	public void the_url_should_contain(String ExpURL) {
		String ActualURL = driver.getCurrentUrl();
		System.out.println("ActualURL: " + ActualURL);
		System.out.println("ExpURL: " + ExpURL);
		CommonUtils.assertEquals("Home Page URL: ", ActualURL, ExpURL);
	}
	
	@Then("The Footer should contain {string}")
	public void the_footer_should_contain(String ExpFooterText) {		
		String ActualFooterText = HomePage.FooterTextValidation();
		CommonUtils.assertEquals("Home Page Footer Text: ", ActualFooterText, ExpFooterText);	    
	}

	@Then("Close the Browser")
	public void close_the_browser() {
		driver.quit();
	}

}
