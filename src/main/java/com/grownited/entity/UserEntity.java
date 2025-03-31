package com.grownited.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//for create users table
@Entity
@Table(name="users")//table name set
public class UserEntity {
	
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Integer userId;
   private String firstName;
   private String lastName;
   @Column(unique = true)
   private String email;
   private String password;
   private String contactNum;
   private String gender;
   private String role;//1.Admin, 2.buyer,3.seller
   private String confirmPassword;
   private Date createdAt;
   private String otp;
   private String profilePicPath;
   //private Integer status;//1:Active, 2:Disabled
   
public Integer getUserId() {
	return userId;
}
public void setUserId(Integer userId) {
	this.userId = userId;
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
public String getContactNum() {
	return contactNum;
}
public void setContactNum(String contactNum) {
	this.contactNum = contactNum;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getConfirmPassword() {
	return confirmPassword;
}
public void setConfirmPassword(String confirmPassword) {
	this.confirmPassword = confirmPassword;
}
public Date getCreatedAt() {
	return createdAt;
}
public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}
public String getOtp() {
	return otp;
}
public void setOtp(String otp) {
	this.otp = otp;
}
public String getProfilePicPath() {
	return profilePicPath;
}
public void setProfilePicPath(String profilePicPath) {
	this.profilePicPath = profilePicPath;
}


//public Integer getStatus() {
//	return status;
//}
//public void setStatus(Integer status) {
	//this.status = status;
//}

}
