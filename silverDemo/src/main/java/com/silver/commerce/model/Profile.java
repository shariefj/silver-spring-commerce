package com.silver.commerce.model;

import java.util.ArrayList;
import java.util.List;
 
public class Profile {
	
	
	int profileId;
	
	String  firstName;
	
	String lastName;
	
	String email;
	
	String password;
	
	Address defaultShippingAddress;
	
	Address defaultBillingAddress;
	
	String externalCustomerNo;
	
	List<Product> favorites = new ArrayList<Product>();
	
		
	public Profile() {
		// TODO Auto-generated constructor stub
	}
	
	
	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
