package com.assessment.countryRestApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assessment.countryRestApi.entity.Country;

public interface CountryRepo extends JpaRepository<Country, Integer> {

}
