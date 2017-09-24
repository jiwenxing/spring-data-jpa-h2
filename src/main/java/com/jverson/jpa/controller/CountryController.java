package com.jverson.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jverson.jpa.domain.Country;
import com.jverson.jpa.service.CountryService;

@RestController
public class CountryController {

	@Autowired
	private CountryService countryService;
	
	@RequestMapping("/countries")
    public Object getAll(Country country) {
        return countryService.getAll(country);
    }
	
}
