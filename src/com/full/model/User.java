package com.full.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class User {
	private String firstName;
	private String lastName;

	// private Long id;
	@Id
	private String emailId;
	private String password;
	private long dateofBirth;
	private String gender;

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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getDateofBirth() {
		return dateofBirth;
	}

	public void setDateofBirth(long dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	/*
	 * public Long getId() { return id; }
	 * 
	 * public void setId(Long id) { this.id = id; }
	 */

}
