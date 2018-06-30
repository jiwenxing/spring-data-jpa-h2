/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2016 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.jverson.jpa.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jverson.jpa.domain.Country;

@CacheConfig(cacheNames = "country")
@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAll(Country country) {
        return (List<Country>) countryRepository.findAll();
    }

    public Page<Country> getAllByPage(int pageNumber,int pageSize){
        Page<Country> sourceCodes= this.countryRepository.findAll(new PageRequest(pageNumber, pageSize, null));
        return sourceCodes;
    }

//    @Cacheable(cacheNames = "country", key = "#p0", condition = "#p0.length()>5")
    @Cacheable(key="#p0")
	public Country findByCountrycode(String countrycode) {
		return countryRepository.findByCountrycode(countrycode);
	}

    @CachePut(key="#country.countrycode", condition="#result!=null")
	public Country save(Country country) {
		return countryRepository.save(country);
	}

	@CacheEvict(key="#country.countrycode") //必须和Cacheable的key相同
	@Transactional
	public void delete(Country country) {
		countryRepository.delete(country);
	}
    
}
