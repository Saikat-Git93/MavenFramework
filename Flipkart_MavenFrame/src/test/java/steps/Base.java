package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	WebDriver dv;
	@Given("User navigate to the URL {string}")
	public void user_navigate_to_the_url(String URL) {
		WebDriverManager.chromedriver().setup();
		dv = new ChromeDriver();
		dv.get(URL);
	}
	
	@Then("Close the Browser")
	public void close_the_browser() {
	    dv.quit();
	}

}
