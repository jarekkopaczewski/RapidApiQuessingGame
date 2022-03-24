package data;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class CountryDetails {
    private String capital;
    private String code;
    private String callingCode;
    private ArrayList<String> currencyCodes;
    private String flagImageUri;
    private String name;
    private int numRegions;
    private String wikiDataId;

    public CountryDetails(String capital, String code, String callingCode,
                          ArrayList<String> currencyCodes, String flagImageUri,
                          String name, int numRegions, String wikiDataId) {
        this.capital = capital;
        this.code = code;
        this.callingCode = callingCode;
        this.currencyCodes = currencyCodes;
        this.flagImageUri = flagImageUri;
        this.name = name;
        this.numRegions = numRegions;
        this.wikiDataId = wikiDataId;
    }
}
