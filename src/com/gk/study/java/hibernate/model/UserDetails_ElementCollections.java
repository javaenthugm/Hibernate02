package com.gk.study.java.hibernate.model;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity(name="UserDetails")
@Table(name="user_details")
public class UserDetails_ElementCollections{
	
	@Id @GeneratedValue(strategy=GenerationType.TABLE)
	private int userId;	
	private String userName;
	
	@ElementCollection
	@JoinTable(name="user_address",
			   joinColumns=@JoinColumn(name="userId"))
	@GenericGenerator(name="hilo-gen",strategy="hilo")
	@CollectionId(columns = { @Column(name="address_id") }, generator = "hilo-gen", type = @Type(type="long"))
	private List<Address> listOfAddress = new ArrayList<>();
	
	
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
	public List<Address> getListOfAddress() {
		return listOfAddress;
	}
	public void setListOfAddress(List<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}
	
	
	
	
	
	

}
