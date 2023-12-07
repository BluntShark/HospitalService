package org.example.model.address;

import java.util.Objects;

/**
 * @author
 * класс Address
 * Включает поля country, city, street, house
 */
public class Address{
    private String country;
    private String city;
    private String street;
    private String house;
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }
    public String getHouse() { return house; }
    public void setHouse(String house) { this.house = house; }
    public Address(String country, String city, String street, String house){
        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;
    }

    @Override
    public String toString() {
        return "[Country: " + country +
                ", City: " + city +
                ", Street: " + street +
                ", House: " + house +
                "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address address)) return false;
        return Objects.equals(country, address.country) && Objects.equals(city, address.city) && Objects.equals(street, address.street) && Objects.equals(house, address.house);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city, street, house);
    }
}
