package com.jverson.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jverson.jpa.service.CountryRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaApplication.class)
public class CacheTest {

	@Autowired
    private CountryRepository countryRepository;
	
	/*@Before
	public void before(){
		countryRepository.save(new Country("super", "aaa"));
	}*/
	
	@Test
	public void test() throws InterruptedException{
		System.out.println("==============first query=============");
		System.out.println(countryRepository.findByCountrycode("Angola"));
		System.out.println("==============second query=============");
		System.out.println(countryRepository.findByCountrycode("Angola"));
		
		System.out.println("==============delete=============");
		countryRepository.deleteByCountrycode("Angola");
		
		System.out.println("==============third query after update=============");
		System.out.println(countryRepository.findByCountrycode("Angola"));
		
		Thread.sleep(5000);
		
		System.out.println("==============fourth query after sleep 5s=============");
		System.out.println(countryRepository.findByCountrycode("Angola"));
	}
	
	
}
