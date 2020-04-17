package temp;

import java.util.HashSet;
import java.util.Set;

import static temp.ApartmentSearchPane.*;

public class ApartmentSearchOptions {
    private Set<TopOptions> topOptions = new HashSet<>();

    private int minMilesFromZip, intMaxMilesFromZip;
    private int minPrice, maxPrice;
    private int minBedrooms, maxBedrooms;
    private int minBathrooms, maxBathrooms;
    private int minArea, maxArea;

    private Set<HousingType> housingTypes = new HashSet<>();

    private Set<LaundryOption> laundryOptions = new HashSet<>();

    public ApartmentSearchOptions setTopOptions(TopOptions...topOptions) {
        for(TopOptions tops : topOptions){
            this.topOptions.add(tops);
        }
        return this;
    }

    public ApartmentSearchOptions setMilesFromZip(int min, int max) {
        this.minMilesFromZip = min;
        this.intMaxMilesFromZip = max;
        return this;
    }

    public ApartmentSearchOptions setPriceRange(int min, int max) {
        this.minPrice = min;
        this.maxPrice = max;
        return this;
    }

    public ApartmentSearchOptions setBedrooms(int min, int max) {
        this.minBedrooms = min;
        this.maxBedrooms = max;
        return this;
    }

    public ApartmentSearchOptions setBathrooms(int min, int max) {
        this.minBathrooms = min;
        this.maxBathrooms = max;
        return this;
    }

    public ApartmentSearchOptions setAreaRange(int min, int max) {
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
