package temp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {
    public static WebDriver getDriver(Drivers driverName) {
        WebDriver driver = null;

        switch (driverName){
            case CHROME:
                driver = new ChromeDriver();
                break;
            default:
                throw new UnsupportedOperationException("The browser " + driverName + " is not supported.");
        }
        return driver;
    }
}
