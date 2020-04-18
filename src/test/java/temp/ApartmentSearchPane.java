package temp;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class ApartmentSearchPane {
    private final WebDriver driver;

    public ApartmentSearchPane(WebDriver driver) {
        this.driver = driver;
    }

    public void selectTopOption(TopOption...options) {
        if(options.length > 0){
            for(TopOption option : options){
                driver.findElement(option.getLocator()).click();
            }
        }
    }

    public void enterMilesFromZip(Integer miles, Integer zipCode) {
        if (miles != null) { driver.findElement(By.name("search_distance")).sendKeys(miles.toString());};
        if (zipCode != null) { driver.findElement(By.name("postal")).sendKeys(zipCode.toString()); };
    }

    public void enterPrice(Integer min, Integer max) {
        if(min != null){driver.findElement(By.name("min_price")).sendKeys(min.toString());}
        if(max != null){driver.findElement(By.name("max_price")).sendKeys(max.toString());}
    }

    public void selectBedrooms(Integer min, Integer max) {
        if(min != null){
            Select minBedrooms = new Select(driver.findElement(By.name("min_bedrooms")));
            minBedrooms.selectByValue(min.toString());
        }

        if(max != null){
            Select maxBedrooms = new Select(driver.findElement(By.name("max_bedrooms")));
            maxBedrooms.selectByValue(max.toString());
        }
    }

    public void selectBathrooms(Integer min, Integer max) {
        if(min != null){
            Select minBedrooms = new Select(driver.findElement(By.name("min_bathrooms")));
            minBedrooms.selectByValue(min.toString());
        }

        if(max != null){
            Select maxBedrooms = new Select(driver.findElement(By.name("max_bathrooms")));
            maxBedrooms.selectByValue(max.toString());
        }
    }

    public void selectAreaSize(Integer min, Integer max) {
        if(min != null){driver.findElement(By.name("minSqft")).sendKeys(min.toString());}
        if(max != null){driver.findElement(By.name("maxSqft")).sendKeys(max.toString());}
    }

    public void displayHousingOptions() {
        WebElement housingBox = driver.findElement(By.cssSelector("div[data-attr=\"housing_type\"]"));
        scrollElementIntoView(housingBox).click();
    }

    public void selectHousingTypes(HousingType...housingTypes) {
        try{
            if(housingTypes.length > 0){
                for(HousingType type : housingTypes){
                    driver.findElement(type.getLocator()).click();
                }
            }
        }catch (ElementNotInteractableException ex) {
            throw new ElementClickInterceptedException("Housing options might be hidden. " +
                    "Click the housing menu 'button' to display the options.");
        }
    }

    public void displayLaundryOptions() {
        WebElement laundryBox = driver.findElement(By.cssSelector("div[data-attr=\"laundry\"]"));
        scrollElementIntoView(laundryBox).click();
    }

    public void selectLaundryOptions(LaundryOption...laundryOptions) {
        try{
            if(laundryOptions.length > 0){
                for(LaundryOption option : laundryOptions){
                    driver.findElement(option.getLocator()).click();
                }
            }
        }catch (ElementNotInteractableException ex) {
            throw new ElementClickInterceptedException("Laundry options might be hidden. " +
                    "Click the laundry menu 'button' to display the options.");
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

    private void displayAndSelectHousingTypes(HousingType...types){
        displayHousingOptions();
        selectHousingTypes(types);
    }

    private void displayAndSelectLaundryTypes(LaundryOption...options){
        displayLaundryOptions();
        selectLaundryOptions(options);
    }

    /* Disadvantage of this approach is that you can enter the search options in only a fixed order.*/
    public void enterMultipleOptions(ApartmentSearchOptions options) {
        selectTopOption(options.getTopOptions().toArray(new TopOption[0]));

        enterMilesFromZip(options.getMilesFromZip(), options.getReferenceZipCode());

        enterPrice(options.getMinPrice(), options.getMaxPrice());

        selectBedrooms(options.getMinBedrooms(), options.getMaxBedrooms());

        selectBathrooms(options.getMinBathrooms(), options.getMaxBathrooms());

        selectAreaSize(options.getMinArea(), options.getMaxArea());

        displayAndSelectHousingTypes(options.getHousingTypes().toArray(new HousingType[0]));

        displayAndSelectLaundryTypes(options.getLaundryOptions().toArray(new LaundryOption[0]));
    }

    public enum TopOption {
        HAS_IMAGE(By.name("hasPic"));

        private By locator;

        TopOption(By locator) {
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
