package temp;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static temp.ApartmentSearchPane.LaundryOption.*;
import static temp.ApartmentSearchPane.TopOptions.*;
import static temp.ApartmentSearchPane.HousingType.*;

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

        ApartmentSearchPane aptPane = apartmentsPage.getSearchOptions();
        aptPane.selectTopOption(HAS_IMAGE);

        aptPane.enterMilesFromZip(5, 94102);
        aptPane.enterPrice(1800, 2500);
        aptPane.selectBedrooms(1, 2);
        aptPane.selectBathrooms(1, 2);
        aptPane.selectAreaSize(700, 1200);

        aptPane.displayHousingOptions();

        aptPane.selectHousingTypes(APARTMENT, CONDO, DUPLEX, FLAT, CONDO);

        aptPane.displayLaundryOptions();
        aptPane.selectLaundryOptions(WD_IN_UNIT, LAUNDRY_IN_BLDG, LAUNDRY_ON_SITE);

        aptPane.updateSearchFilters();
    }

    @Test
    public void browseFilteredApartmentListings(){
        ApartmentsPage apartmentsPage = new ApartmentsPage(driver);
        Assert.assertTrue(apartmentsPage.isOpen());
        Assert.assertEquals(apartmentsPage.getRegion(), "sfbay");

        ApartmentSearchOptions aptOptions = new ApartmentSearchOptions();
    }

}
