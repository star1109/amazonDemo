package demo.amazon.pages;

import demo.amazon.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Utility {
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//input[@id='sp-cc-accept']")
    WebElement acceptcookies;


    @CacheLookup
    @FindBy(xpath = "//header/div[@id='navbar']/div[@id='nav-belt']/div[3]/div[1]/a[4]/div[1]/span[2]")
    WebElement basketbutton;

    @CacheLookup
    @FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
    WebElement loginlink;


    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Your Amazon Cart is empty')]")
    WebElement emptymassage;

    @CacheLookup
    @FindBy(xpath = "//select[@id='searchDropdownBox']")
    WebElement searchDropdown;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"searchDropdownBox\"]/option[12]")
    WebElement books;

    @CacheLookup
    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    WebElement searchbox;


    public void clickOnacceptcookies() {
        clickOnElement(acceptcookies);
        log.info("Accepting cookies : " + acceptcookies.toString());
    }

    public void clickOnloginlink() {
        clickOnElement(loginlink);
        log.info("Clicking on login link : " + loginlink.toString());
    }


    public void clickOnBasketLink() {
        clickOnElement(basketbutton);
        log.info("Clicking on basket button : " + basketbutton.toString());
    }


    public String getemptymassage() {
        //log.info("Getting text from : " + emptymassage.toString());
        System.out.println("************" + emptymassage.toString() + "***********");
        return getTextFromElement(emptymassage);
    }

    public void clickOnsearchDropdown() {


        clickOnElement(searchDropdown);
       // selectByValueFromDropDown(searchDropdown, "Books");
        log.info("Clicking on search: " + searchDropdown.toString());
    }

    public void selectBooks() {

        //mouseHoverToElementAndClick(books);
        selectByVisibleTextFromDropDown(searchDropdown,"Books");
        log.info("selecting books from the dropdown : " + books.toString());
    }

    public void enterBitcoinInsearchBox()
    {
        sendTextToElement(searchbox,"Bitcoin");
    }

}
