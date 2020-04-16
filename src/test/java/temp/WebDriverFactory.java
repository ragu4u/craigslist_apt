package temp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {
    private static final String DRIVER_FOLDER = "C:/work/installations/selenium_drivers";

    static {
        setDriverLocations();
    }

    public static WebDriver getDriver(Driver driverName) {
        WebDriver driver;

        switch (driverName){
            case CHROME:
                driver = new ChromeDriver();
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

}
