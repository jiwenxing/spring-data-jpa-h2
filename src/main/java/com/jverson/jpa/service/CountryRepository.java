
package com.jverson.jpa.service;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.jverson.jpa.domain.Country;

public interface CountryRepository extends PagingAndSortingRepository<Country, Long> {

	Country findByCountrycode(String countrycode);
	
	int deleteByCountrycode(@Param("countrycode") String countrycode); //注意删除的写法比较特殊
	
}
