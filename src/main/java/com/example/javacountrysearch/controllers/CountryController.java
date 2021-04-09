package com.example.javacountrysearch.controllers;

import com.example.javacountrysearch.models.Country;
import com.example.javacountrysearch.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CountryController {
    @Autowired
    private CountryRepository countryRepository;
    @GetMapping(value = "/countries/all", produces = "application/json")
    public ResponseEntity<?> findAllCountries() {
        List<Country> countries = new ArrayList<>();
        countryRepository.findAll().iterator().forEachRemaining(countries::add);
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }
    @GetMapping(value = "/countries/name/{letter}", produces = "application/json")
    public ResponseEntity<?> findByName(@PathVariable char letter) {
        List<Country> countryList = new ArrayList();
    countryRepository.findAll().iterator().forEachRemaining(countryList::add);
    List<Country> filteredList = filterCountries(countryList,

            (e) -> Character.toLowerCase(e.getName().charAt(0)) == Character.toLowerCase(letter));
    return new ResponseEntity<>(filteredList, HttpStatus.OK);

    }

    private List<Country> filterCountries(List<Country> countryList,  FilterCountries tester) {
        List<Country> rtnList = new ArrayList<>();

        for(Country e : countryList) {
            if(tester.test(e)) {
                rtnList.add(e);
            }
        }
        return rtnList;
    }

    @GetMapping(value = "/countries/population/total", produces = "application/json")
    public ResponseEntity<?> calculateTotalPopulation() {
        long totalPop = 0;
        List<Country> countries = new ArrayList<>();
        System.out.println(countries);
        countryRepository.findAll().iterator().forEachRemaining(countries::add);
        for (Country c:countries) {
            totalPop += c.getPopulation();
        }
        System.out.println(countries);

        return new ResponseEntity<>(totalPop, HttpStatus.OK);


    }
    @GetMapping(value = "/countries/population/min", produces = "application/json")
    public ResponseEntity<?> calculateMinPopulation() {
        List<Country> countries = new ArrayList<>();
        countryRepository.findAll().iterator().forEachRemaining(countries::add);
        countries.sort((Country c1, Country c2) -> {
           return (c1.getPopulation() < c2.getPopulation()) ? 1 : -1;
        });
        return new ResponseEntity<>(countries.get(0), HttpStatus.OK);
    }
    @GetMapping(value = "/countries/population/max", produces = "application/json")
    public ResponseEntity<?> calculateMaxPopulation() {
        List<Country> countries = new ArrayList<>();
        countryRepository.findAll().iterator().forEachRemaining(countries::add);
        countries.sort((Country c1, Country c2) -> {
            return (c1.getPopulation() > c2.getPopulation()) ? 1 : -1;
        });
        return new ResponseEntity<>(countries.get(0), HttpStatus.OK);
    }


}
