package temp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {
    static {
        setDriverLocation(Driver.CHROME);
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

    private static void setDriverLocation(Driver driverName){
        String driverProperty;
        String driverPath = "C:/work/installations/selenium_drivers";

        switch (driverName) {
            case CHROME:
                driverProperty = "webdriver.chrome.driver";
                driverPath += "/chromedriver.exe";
                break;
            default:
                throw new UnsupportedOperationException("The browser " + driverName + " is not supported.");
        }
        System.setProperty(driverProperty, driverPath);
    }

}
