package com.example.javacountrysearch.controllers;

import com.example.javacountrysearch.models.Country;

@FunctionalInterface
public interface FilterCountries {
    boolean test(Country country);
}
