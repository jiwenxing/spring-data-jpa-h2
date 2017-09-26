
package com.jverson.jpa.service;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.jverson.jpa.domain.Country;

public interface CountryRepository extends PagingAndSortingRepository<Country, Long> {

}
