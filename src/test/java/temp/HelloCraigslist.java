package temp;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HelloCraigslist {
    private static WebDriver driver = WebDriverFactory.getDriver(Driver.CHROME);

    @BeforeClass
    public void beforeClass(){
        driver.get("https://sfbay.craigslist.org/search/apa");
    }

    @Test
    public void findApartmentsInSFBayArea(){
        ApartmentsPage apartmentsPage = new ApartmentsPage(driver);
        Assert.assertTrue(apartmentsPage.isOpen());
        Assert.assertEquals(apartmentsPage.getRegion(), "sfbay");
    }
}
