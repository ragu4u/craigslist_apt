package temp;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ApartmentSearchPane {
    private final WebDriver driver;

    public ApartmentSearchPane(WebDriver driver) {
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

    public void displayHousingOptions() {
        WebElement housingBox = driver.findElement(By.cssSelector("div[data-attr=\"housing_type\"]"));
        scrollElementIntoView(housingBox).click();
    }

    public void selectHousingTypes(HousingType...housingTypes) {
        for(HousingType type : housingTypes){
            driver.findElement(type.getLocator()).click();
        }
    }

    public void displayLaundryOptions() {
        WebElement laundryBox = driver.findElement(By.cssSelector("div[data-attr=\"laundry\"]"));
        scrollElementIntoView(laundryBox).click();
    }

    public void selectLaundryOptions(LaundryOption...laundryOptions) {
        for(LaundryOption option : laundryOptions){
            driver.findElement(option.getLocator()).click();
        }
    }

    private WebElement scrollElementIntoView(WebElement element){
        JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
        jsDriver.executeScript("arguments[0].scrollIntoView(true);", element);
        return element;
    }

    public void updateSearchFilters() {
        driver.findElement(By.xpath("//button[contains(. , 'update search')]")).click();
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

    public enum HousingType {
        APARTMENT(By.id("housing_type_1")),
        CONDO(By.id("housing_type_2")),
        DUPLEX(By.id("housing_type_4")),
        FLAT(By.id("housing_type_5")),
        TOWN_HOUSE(By.id("housing_type_9"));

        private By locator;

        HousingType(By locator) {
            this.locator = locator;
        }

        public By getLocator(){
            return this.locator;
        }
    }

    public enum LaundryOption {
        WD_IN_UNIT(By.id("laundry_1")),
        LAUNDRY_IN_BLDG(By.id("laundry_2")),
        LAUNDRY_ON_SITE(By.id("laundry_3"));
        private By locator;

        LaundryOption(By locator) {
            this.locator = locator;
        }

        public By getLocator(){
            return this.locator;
        }
    }

}
