package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	
	WebDriver driver;

    // Constructor to initialize elements
    public Home_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // Important!
    }

    // ============ WebElements ============
    @FindBy(xpath = "//a[@href= 'https://demoqa.com']")
    public WebElement Title;
    
    @FindBy(xpath = "//footer/span")
    public WebElement Footer;
    
    @FindBy(xpath = "//h5[text()='Elements']")
    public WebElement elementsCard;

    @FindBy(xpath = "//h5[text()='Forms']")
    public WebElement formsCard;

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    public WebElement alertsCard;

    @FindBy(xpath = "//div[@class='main-header']")
    public WebElement mainHeader;

    // ============ Actions ============    
    public String FooterTextValidation() {
    	return Footer.getText();    	
    }
    public void clickOnElementsCard() {
        elementsCard.click();
    }

    public void clickOnFormsCard() {
        formsCard.click();
    }

    public String getMainHeaderText() {
        return mainHeader.getText();
    }

}
