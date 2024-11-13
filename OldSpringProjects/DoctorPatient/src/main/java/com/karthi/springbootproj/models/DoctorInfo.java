package com.karthi.springbootproj.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Entity
@Table(name="doctor")
public class DoctorInfo {
	
	@Id
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="Dob")
	private String dob;
	@Column(name="Gender")
	private String gender;
	@Column(name="Contact")
	private String contact;
	@Column(name="doctor_Id")
	private String doctorId;
	@Column(name="Password")
	private String password;
	private String email;
	@Column(name="user_category")
	private String userCategory;
	private String nickname;
	private String petname;
	private String bornplace;
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
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCotanct() {
		return contact;
	}
	public void setCotanct(String cotanct) {
		this.contact = cotanct;
	}
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserCategory() {
		return userCategory;
	}
	public void setUserCategory(String userCategory) {
		this.userCategory = userCategory;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPetname() {
		return petname;
	}
	public void setPetname(String petname) {
		this.petname = petname;
	}
	public String getBornplace() {
		return bornplace;
	}
	public void setBornplace(String bornplace) {
		this.bornplace = bornplace;
	}
	@Override
	public String toString() {
		return "DoctorInfo [firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", gender=" + gender
				+ ", contact=" + contact + ", doctorId=" + doctorId + ", password=" + password + ", email=" + email
				+ ", userCategory=" + userCategory + ", nickname=" + nickname + ", petname=" + petname + ", bornplace="
				+ bornplace + "]";
	}
	
}
