
package com.jverson.jpa.service;

import org.springframework.data.repository.CrudRepository;

import com.jverson.jpa.domain.Country;

public interface CountryRepository extends CrudRepository<Country, Long> {

}
