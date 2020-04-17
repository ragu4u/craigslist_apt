package temp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ApartmentSearchOptions {
    private final WebDriver driver;

    public ApartmentSearchOptions(WebDriver driver) {
        this.driver = driver;
    }

    public void selectTopOption(TopOptions option) {
        driver.findElement(option.getLocator()).click();
    }

    public void enterMilesFromZip(int miles, int zipCode) {
        driver.findElement(By.name("search_distance")).sendKeys(miles + "");
        driver.findElement(By.name("postal")).sendKeys(zipCode + "");
    }

    public void enterPrice(int min, int max) {
        driver.findElement(By.name("min_price")).sendKeys(min + "");
        driver.findElement(By.name("max_price")).sendKeys(max + "");
    }

    public void selectBedrooms(int min, int max) {
        Select minBedrooms = new Select(driver.findElement(By.name("min_bedrooms")));
        minBedrooms.selectByValue(min + "");

        Select maxBedrooms = new Select(driver.findElement(By.name("max_bedrooms")));
        maxBedrooms.selectByValue(max + "");
    }

    public void selectBathrooms(int min, int max) {
        Select minBedrooms = new Select(driver.findElement(By.name("min_bathrooms")));
        minBedrooms.selectByValue(min + "");

        Select maxBedrooms = new Select(driver.findElement(By.name("max_bathrooms")));
        maxBedrooms.selectByValue(max + "");
    }

    public void selectAreaSize(int min, int max) {
        driver.findElement(By.name("minSqft")).sendKeys(min + "");
        driver.findElement(By.name("maxSqft")).sendKeys(max + "");
    }

    public enum TopOptions{
        HAS_IMAGE(By.name("hasPic"));

        private By locator;

        TopOptions(By locator) {
            this.locator = locator;
        }

        public By getLocator(){
            return this.locator;
        }

    }

}
