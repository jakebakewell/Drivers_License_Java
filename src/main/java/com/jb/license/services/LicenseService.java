package com.jb.license.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jb.license.models.License;
import com.jb.license.models.Person;
import com.jb.license.repositories.LicenseRepository;

@Service
public class LicenseService {
	private final LicenseRepository licenseRepository;
	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	
	public List<License> allLicenses() {
        return licenseRepository.findAll();
    }
	
	public License createLicense(License l) {
        return licenseRepository.save(l);
    }
	
	public License createLicense(String number, Date expirationDate, String state, Person person) {
		License l = new License (number, expirationDate, state, person);
		return licenseRepository.save(l);
	}
	
	public License findLicense(Long id) {
        Optional<License> optionalLicense = licenseRepository.findById(id);
        if(optionalLicense.isPresent()) {
            return optionalLicense.get();
        } else {
            return null;
        }
    }
	
	public void deleteLicense(Long id) {
    	licenseRepository.deleteById(id);
    }
	
	public License findByNumber(String number) {
		return licenseRepository.findLicenseByNumber(number);
	}
}
