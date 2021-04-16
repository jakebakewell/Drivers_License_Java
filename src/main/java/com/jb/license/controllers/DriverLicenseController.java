package com.jb.license.controllers;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jb.license.models.License;
import com.jb.license.models.Person;
import com.jb.license.services.LicenseService;
import com.jb.license.services.PersonService;

@Controller
public class DriverLicenseController {
	private final PersonService personService;
	private final LicenseService licenseService;
	public DriverLicenseController(PersonService personService, LicenseService licenseService) {
		this.personService = personService;
		this.licenseService = licenseService;
	}
	
	@RequestMapping("/")
	public String index(Model model) {
		List<Person> people = personService.allPeople();
		List<License> licenses = licenseService.allLicenses();
		model.addAttribute("people", people);
		model.addAttribute("licenses", licenses);
		model.addAttribute("person", new Person());
		model.addAttribute("license", new License());
		return "index.jsp";
	}
	
	@RequestMapping("/license/{id}")
	public String newLicense(Model model, @PathVariable("id") Long id) {
		Person person = personService.findPerson(id);
		model.addAttribute("person", person);
		model.addAttribute("license", new License());
		return "license.jsp";
	}
	
	@RequestMapping(value="/index/person", method=RequestMethod.POST)
    public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
        if (result.hasErrors()) {
            return "index.jsp";
        } else {
            personService.createPerson(person);
            return "redirect:/";
        }
    }
	
	@RequestMapping(value="/index/license", method=RequestMethod.POST)
    public String createLicense(@RequestParam(value="number") String number, @RequestParam(value="expirationDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd")
 Date expirationDate, @RequestParam(value="state") String state, @RequestParam(value="person") Long personID) {
		Person person = personService.findPerson(personID);
		licenseService.createLicense(number, expirationDate, state, person);
		return "redirect:/";
    }
}
