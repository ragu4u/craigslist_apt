package temp;

import org.openqa.selenium.WebDriver;

public class ApartmentsPage {
    private final WebDriver driver;

    public ApartmentsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOpen() {
        return driver.getCurrentUrl().endsWith("craigslist.org/search/apa");
    }
}
