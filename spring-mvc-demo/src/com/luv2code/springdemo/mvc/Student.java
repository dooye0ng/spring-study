package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {
	private String firstName;
	private String lastName;
	private String country;
	private LinkedHashMap<String, String> countryOptions;
	private String favoriteLanguage;
	private LinkedHashMap<String, String> favoriteLanguageOptions;
	private String[] operatingSystems;
	private LinkedHashMap<String, String> operatingSystemOptions;
	
	public Student() {
		countryOptions = new LinkedHashMap<String, String>();
		favoriteLanguageOptions = new LinkedHashMap<String, String>();
		operatingSystemOptions = new LinkedHashMap<String, String>();
		
		countryOptions.put("BR", "Brazil");
		countryOptions.put("FR", "France");
		countryOptions.put("DE", "Germany");
		countryOptions.put("IN", "India");
		countryOptions.put("KR", "Korea");
		
		favoriteLanguageOptions.put("C/C++", "C/C++");
		favoriteLanguageOptions.put("Java", "JAVA");
		favoriteLanguageOptions.put("Python", "PYTHON");
		favoriteLanguageOptions.put("JavaScript", "JAVASCRIPT");
		
		operatingSystemOptions.put("Linux", "Linux");
		operatingSystemOptions.put("Windows", "Windows");
		operatingSystemOptions.put("Mac OS", "Mac OS");
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public LinkedHashMap<String, String> getFavoriteLanguageOptions() {
		return favoriteLanguageOptions;
	}

	public String[] getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}

	public LinkedHashMap<String, String> getOperatingSystemOptions() {
		return operatingSystemOptions;
	}

}
