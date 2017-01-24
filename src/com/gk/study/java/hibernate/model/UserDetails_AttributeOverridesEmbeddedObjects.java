package com.gk.study.java.hibernate.model;



import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="UserDetails")
@Table(name="USER_DETAILS")
public class UserDetails_AttributeOverridesEmbeddedObjects{
	
	@Id @GeneratedValue(strategy=GenerationType.TABLE)
	private int userId;
	
	private String userName;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride (name="street",column=@Column(name="HOME_STREET_NAME")),
		@AttributeOverride (name="city",column=@Column(name="HOME_CITY_NAME")),
		@AttributeOverride (name="state",column=@Column(name="HOME_STATE_NAME")),
		@AttributeOverride (name="pincode",column=@Column(name="HOME_PINCODE_NAME"))
	})
	private Address homeAddress;
	
	@Embedded
	private Address officeAddress;

	
	@Temporal(TemporalType.DATE)
	private Date joinedDate;
	private String description;
	
	
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	
	
	
	

}
