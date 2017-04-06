/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.ac.seu.my.airlinereservationsys.model;

/**
 *
 * @author shithilboss
 */
public class City {
    private String cityId;
    private String countryCode;
    private String cityName;

    public City() {
    }

    public City(String cityId, String countryCode, String cityName) {
        this.cityId = cityId;
        this.countryCode = countryCode;
        this.cityName = cityName;
    }

    public String getCityId() {
        return cityId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCityName() {
        return cityName;
    }

    @Override
    public String toString() {
        return "City{" + "cityId=" + cityId + ", countryCode=" + countryCode + ", cityName=" + cityName + '}';
    }
    
}

