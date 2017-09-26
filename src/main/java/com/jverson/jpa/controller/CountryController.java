package com.jverson.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jverson.jpa.domain.Country;
import com.jverson.jpa.service.CountryService;

@Controller
@RequestMapping("/countries")
public class CountryController {

	@Autowired
	private CountryService countryService;

	@RequestMapping
    public String getAllView(Model model, Country country) {
        Page<Country> countryPage = countryService.getAllByPage(country.getPage(), country.getRows()); //暂时只有分页，没有实现条件查询
        model.addAttribute("pageInfo", countryPage);
        model.addAttribute("queryParam", country);
        model.addAttribute("page", country.getPage());
        model.addAttribute("rows", country.getRows());
        return "index";
    }

}
