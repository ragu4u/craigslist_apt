package temp;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class HelloCraigslist {
    private static WebDriver driver = WebDriverFactory.getDriver(Driver.CHROME);

    @Test
    public void selectApartments(){
        ApartmentsPage apartmentsPage = new ApartmentsPage(driver);
    }
}
