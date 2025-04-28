package basePackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver dv = new ChromeDriver();
		dv.get("https://www.flipkart.com/");
		

	}

}
