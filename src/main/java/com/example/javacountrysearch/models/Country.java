package com.example.javacountrysearch.models;


import javax.persistence.*;

@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long countryid;
    private String name;
    private long population;
    private double landmasskm2;
    private double medianage;

    public Country() {

    }

    public Country(String name, long population, double landmasskm2, double medianage) {
        this.name = name;
        this.population = population;
        this.landmasskm2 = landmasskm2;
        this.medianage = medianage;
    }

    public long getCountryid() {
        return countryid;
    }

    public void setCountryid(long countryid) {
        this.countryid = countryid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public double getLandmasskm2() {
        return landmasskm2;
    }

    public void setLandmasskm2(double landmasskm2) {
        this.landmasskm2 = landmasskm2;
    }

    public double getMedianage() {
        return medianage;
    }

    public void setMedianage(double medianage) {
        this.medianage = medianage;
    }
}
