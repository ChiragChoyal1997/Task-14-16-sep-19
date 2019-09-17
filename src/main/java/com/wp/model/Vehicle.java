package com.wp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NamedNativeQuery;

@Entity
public class Vehicle {
	
	@Id
	private String vehicle_id;
	private String brand;
	private int price;
	
	@OneToOne(mappedBy="vehicle")
	private Employee employee;

	public String getVehicle_id() {
		return vehicle_id;
	}

	public void setVehicle_id(String vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicle_id=" + vehicle_id + ", brand=" + brand + ", price=" + price + "]";
	}

	public Vehicle(String vehicle_id, String brand, int price) {
		super();
		this.vehicle_id = vehicle_id;
		this.brand = brand;
		this.price = price;
	}

	public Vehicle() {
		super();
	}
	
	
	
}
