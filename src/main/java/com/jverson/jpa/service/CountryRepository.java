
package com.jverson.jpa.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.jverson.jpa.domain.Country;

@CacheConfig(cacheNames = "countrycode")
public interface CountryRepository extends PagingAndSortingRepository<Country, Long> {

	@Cacheable
	Country findByCountrycode(String countrycode);
	
//	@CacheEvict
	@Transactional
	int deleteByCountrycode(@Param("countrycode") String countrycode); //注意删除的写法比较特殊
	
	/*@Modifying 
	@Query("update country a set a.countryname = :countryname where a.countrycode = :countrycode") 
	int update(@Param("countryname") String countryname, @Param("countrycode") String countrycode);*/
	
}
