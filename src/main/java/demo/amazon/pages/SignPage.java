package demo.amazon.pages;

import demo.amazon.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignPage extends Utility {
    private static final Logger log = LogManager.getLogger(SignPage.class.getName());

    public SignPage() {
        PageFactory.initElements(driver, this);
    }
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Sign In')]")
    WebElement welcometext;


    public String getwelcomtext() {
        log.info("Getting text from : " + welcometext.toString());
        return getTextFromElement(welcometext);
    }
}
