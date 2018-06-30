package com.jverson.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.jverson.jpa.domain.Country;
import com.jverson.jpa.service.CountryService;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaApplication.class)
public class CacheTest {

	@Autowired
	private CountryService countryService;

	@Autowired
	private CacheManager cacheManager;

	/*
	 * @Before public void before(){ countryRepository.save(new Country("super",
	 * "aaa")); }
	 */

	@Test
	public void testCacheType() throws InterruptedException {
		assertTrue("org.springframework.cache.guava.GuavaCacheManager".equals(cacheManager.getClass().getName()));
	}
	
	@Test
	public void testCachePut(){
		System.out.println("==============testCachePut==============");
		// first query, from db and data cached
		Country country = countryService.findByCountrycode("Angola");
		System.out.println(country);
		
		country.setCountryname("china");
		countryService.save(country);
		
		// second query after update
		assertTrue("china".equals(countryService.findByCountrycode("Angola").getCountryname()));
	}
	
	@Test
	public void testCacheEvict(){
		System.out.println("==============testCacheEvict==============");
		// first query, from db and data cached
		Country country = countryService.findByCountrycode("Algeria");
		System.out.println(country);

		// second query, from cache
		System.out.println(countryService.findByCountrycode("Algeria"));

		// delete data in db(CacheEvict annoation)
		countryService.delete(country);

		// third query after delete, data still in cache
		System.out.println(countryService.findByCountrycode("Algeria"));
		assertTrue(countryService.findByCountrycode("Algeria")==null);
	}

	@Test
	public void testExpire() throws InterruptedException {
		System.out.println("==============first query, cache data expireAfterAccess 4s=============");
		Country country = countryService.findByCountrycode("Australia");
		System.out.println(country);
		
		Thread.sleep(3000);
		System.out.println("==============second query after sleep 3s, cache exits=============");
		System.out.println(cacheManager.getCache("country").get(country.getCountrycode(), Country.class));
		assertTrue(cacheManager.getCache("country").get(country.getCountrycode())!=null);

		Thread.sleep(5000);
		System.out.println("==============third query after sleep another 5s, cache expired=============");
		assertFalse(cacheManager.getCache("country").get(country.getCountrycode())!=null);
	}

}
