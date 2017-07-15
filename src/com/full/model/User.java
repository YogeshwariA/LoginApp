package com.full.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	// @JsonProperty("given_name")
	private String firstName;
	// @JsonProperty("family_name")
	private String lastName;
	@Id
	private String email;
	private String password;
	private long dateofBirth;
	private String gender;
	private String picture;

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

	/*
	 * public long getId() { return id; }
	 * 
	 * public void setId(long id) { this.id = id; }
	 */
	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
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

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
}
