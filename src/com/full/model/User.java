package com.full.model;

import java.io.Serializable;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String given_name;
	private String family_name;
	@Id
	private String email;
	private String password;
	private long dateofBirth;
	private String gender;
	//private long id;
	private String picture;

	public String getGiven_name() {
		return given_name;
	}

	public void setGiven_name(String given_name) {
		this.given_name = given_name;
	}

	public String getFamily_name() {
		return family_name;
	}

	public void setFamily_name(String family_name) {
		this.family_name = family_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/*public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
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
	return given_name + " "+ family_name;
}
}
