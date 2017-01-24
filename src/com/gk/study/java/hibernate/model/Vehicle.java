package com.gk.study.java.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

@Entity
@Table(name="vehicle")
@FilterDef(name="vehicleType", parameters=@ParamDef( name="minLength", type="integer" ))
public class Vehicle {
	
	@Id @GeneratedValue
	private int vehicleId;
	private String vehicleName;
	
	@ManyToOne
	private UserDetails_Vehicle_OneToOneMapping user;
	
	
	
	
	public UserDetails_Vehicle_OneToOneMapping getUser() {
		return user;
	}
	public void setUser(UserDetails_Vehicle_OneToOneMapping user) {
		this.user = user;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	

}
