package temp;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static temp.ApartmentSearchOptions.TopOptions.*;

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

        ApartmentSearchOptions aptOptions = apartmentsPage.getSearchOptions();
        aptOptions.selectTopOption(HAS_IMAGE);
        aptOptions.enterMilesFromZip(5, 94102);
        aptOptions.enterPrice(1800, 2500);
        aptOptions.selectBedrooms(1, 2);
        aptOptions.selectBathrooms(1, 2);
        aptOptions.selectAreaSize(700, 1200);
    }

}
