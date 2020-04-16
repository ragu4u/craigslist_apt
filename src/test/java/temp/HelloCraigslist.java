package temp;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class HelloCraigslist {
    private static WebDriver driver = WebDriverFactory.getDriver(Drivers.CHROME);

    @Test
    public void selectApartments(){
        ApartmentsPage apartmentsPage = new ApartmentsPage(driver);
    }
}
