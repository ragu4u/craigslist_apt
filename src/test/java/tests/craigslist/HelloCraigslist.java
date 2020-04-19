package tests.craigslist;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ApartmentSearchOptions;
import pages.ApartmentSearchPane;
import pages.ApartmentsPage;
import driver.Driver;
import driver.WebDriverFactory;

import static pages.ApartmentSearchPane.HousingType.*;
import static pages.ApartmentSearchPane.LaundryOption.*;
import static pages.ApartmentSearchPane.TopOption.*;

public class HelloCraigslist {
    private static WebDriver driver = WebDriverFactory.getDriver(Driver.CHROME);

    @BeforeMethod
    public void beforeMethod(){
        driver.get("https://sfbay.craigslist.org/search/apa");
    }

    @Test
    public void findApartmentsInSFBayArea(){
        ApartmentsPage apartmentsPage = new ApartmentsPage(driver);
        Assert.assertTrue(apartmentsPage.isOpen());
        Assert.assertEquals(apartmentsPage.getRegion(), "sfbay");

        ApartmentSearchPane aptPane = apartmentsPage.getSearchPane();
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
        ApartmentSearchPane aptPane = apartmentsPage.getSearchPane();
        aptPane.enterMultipleOptions(getDefaultApartmentSearchOptions());
    }

    private ApartmentSearchOptions getDefaultApartmentSearchOptions(){
        ApartmentSearchOptions aptOptions = new ApartmentSearchOptions();
        aptOptions
                .setTopOptions(HAS_IMAGE)
                .setMilesFromZip(5, 94102)
                .setPriceRange(1800, 2500)
                .setBedrooms(1, 2)
                .setBathrooms(1, 2)
                .setAreaRange(700, 1200)
                .setHousingTypes(APARTMENT, CONDO, DUPLEX, FLAT, CONDO)
                .setLaundryOptions(WD_IN_UNIT, LAUNDRY_IN_BLDG, LAUNDRY_ON_SITE);
        return aptOptions;
    }

}
