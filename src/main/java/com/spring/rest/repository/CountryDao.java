package com.spring.rest.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.spring.rest.component.Country;

@Repository
public class CountryDao {

	@Autowired
	private HibernateTemplate template;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	// Get all countries from the database	
	public List<Country> getAllCountries() {			
		List<Country> countries = getTemplate().loadAll(Country.class);

		for(Country c : countries)
			System.out.println(c.toString());

		return countries;
	}

	// Get country by id from the database
	public Country getCountry(int id) {		
		Country country = (Country) getTemplate().get(Country.class, new Integer(id));
		System.out.println(country.toString());
		return country;
	}
}