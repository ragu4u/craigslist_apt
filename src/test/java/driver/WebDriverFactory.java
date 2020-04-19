package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collections;

public class WebDriverFactory {
    private static final String DRIVER_FOLDER = "C:/work/installations/selenium_drivers";

    static {
        setDriverLocations();
    }

    public static WebDriver getDriver(Driver driverName) {
        WebDriver driver;

        switch (driverName){
            case CHROME:
                driver = new ChromeDriver(getChromeOptions());
                break;
            default:
                throw new UnsupportedOperationException("The browser " + driverName + " is not supported.");
        }
        return driver;
    }

    private static void setDriverLocations(){
        //Chrome.
        System.setProperty("webdriver.chrome.driver", DRIVER_FOLDER + "/chromedriver.exe");
    }

    private static ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--start-maximized");

        //Next two lines to remove the annoying info bar on top of the browser.
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);

        return options;
    }

}
