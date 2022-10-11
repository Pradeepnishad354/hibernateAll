package com.test;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="Employee_address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;
	
	@Column(name="STREET" ,length = 20)
	private String street;
	
	@Column(name="CITY",length = 30)
	private String city;
	
	@Column(name="Is_open")
	private boolean isOpen;
	
	@Lob
	private byte[] image;
	@Column(name="added_date")
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Transient
	private double x;
	public Address(int addressId, String street, String city, boolean isOpen, byte[] image, Date date, double x) {
		super();
		this.addressId = addressId;
		this.street = street;
		this.city = city;
		this.isOpen = isOpen;
		this.image = image;
		this.date = date;
		this.x = x;
	}
	public Address() {
		// TODO Auto-generated constructor stub
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public boolean isOpen() {
		return isOpen;
	}
	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}

}
