package com.gk.study.java.hibernate.model;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="UserDetails")
@Table(name="user")
public class UserDetails_Vehicle_OneToOneMapping{
	
	@Id @GeneratedValue
	private int userId;	
	private String userName;
	
	@OneToMany
	@JoinTable(name="user_vehicle", joinColumns=@JoinColumn(name="user_id"),
	inverseJoinColumns=@JoinColumn(name="vehicle_id"))
	private List<Vehicle> vehicle = new ArrayList<Vehicle>();
	
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
	
	public List<Vehicle> getVehicle() {
		return vehicle;
	}
	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}

}
