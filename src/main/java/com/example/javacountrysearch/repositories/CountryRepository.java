package com.example.javacountrysearch.repositories;

import com.example.javacountrysearch.models.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Long> {

}
