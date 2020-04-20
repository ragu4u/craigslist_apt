package pages;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static pages.ApartmentSearchPane.*;

@Getter
@Setter
public class ApartmentSearchOptions {
    private List<TopOption> topOptions = new ArrayList<>();

    private Integer milesFromZip, referenceZipCode;
    private Integer minPrice, maxPrice;
    private Integer minBedrooms, maxBedrooms;
    private Integer minBathrooms, maxBathrooms;
    private Integer minArea, maxArea;

    private List<HousingType> housingTypes = new ArrayList<>();

    private List<LaundryOption> laundryOptions = new ArrayList<>();

    public ApartmentSearchOptions setTopOptions(TopOption...topOptions) {
        for(TopOption tops : topOptions){
            this.topOptions.add(tops);
        }
        return this;
    }

    public ApartmentSearchOptions setMilesFromZip(Integer min, Integer max) {
        this.milesFromZip = min;
        this.referenceZipCode = max;
        return this;
    }

    public ApartmentSearchOptions setPriceRange(Integer min, Integer max) {
        this.minPrice = min;
        this.maxPrice = max;
        return this;
    }

    public ApartmentSearchOptions setBedrooms(Integer min, Integer max) {
        this.minBedrooms = min;
        this.maxBedrooms = max;
        return this;
    }

    public ApartmentSearchOptions setBathrooms(Integer min, Integer max) {
        this.minBathrooms = min;
        this.maxBathrooms = max;
        return this;
    }

    public ApartmentSearchOptions setAreaRange(Integer min, Integer max) {
        this.minArea = min;
        this.maxArea = max;
        return this;
    }

    public ApartmentSearchOptions setHousingTypes(HousingType...housingTypes) {
        for(HousingType types : housingTypes){
            this.housingTypes.add(types);
        }
        return this;
    }

    public ApartmentSearchOptions setLaundryOptions(LaundryOption...laundryOptions) {
        for(LaundryOption option : laundryOptions){
            this.laundryOptions.add(option);
        }
        return this;
    }

}
