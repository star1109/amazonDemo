package demo.amazon.drivermanager;


import demo.amazon.propertyreader.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ManageDriver {

    private static final Logger log = LogManager.getLogger(ManageDriver.class.getName());
    public static WebDriver driver;
    public String baseUrl = PropertyReader.getInstance().getProperty("baseUrl");
    public String secondsInString = PropertyReader.getInstance().getProperty("implicitlyWait");

    public long seconds = Long.parseLong(secondsInString);

    public ManageDriver() {

        PageFactory.initElements(driver, this);


        PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/test/java/resources/propertiesfile/log4j2.properties");
    }

    public void selectBrowser(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            WebDriver driver= new ChromeDriver();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            options.addArguments("--remote-allow-origins=*");
            log.info("Launching Chrome Browser");
            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();

            log.info("launching firefox browser");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            log.info("launching edge browser");
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong browser name");
        }

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
        driver.get(baseUrl);
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }








}
