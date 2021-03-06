package pages;

import org.openqa.selenium.WebDriver;
import utils.StringUtils;

public class ApartmentsPage {
    private final WebDriver driver;

    public ApartmentsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOpen() {
        return driver.getCurrentUrl().endsWith("craigslist.org/search/apa");
    }

    public String getRegion() {
        return StringUtils.getSubString(driver.getCurrentUrl(), "https://", ".craigslist");
    }

    public ApartmentSearchPane getSearchPane() {
        return new ApartmentSearchPane(driver);
    }
}
