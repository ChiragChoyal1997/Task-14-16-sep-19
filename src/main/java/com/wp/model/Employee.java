package com.wp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;


//This is additionally added to practice the mapping, without modifying the Emp class
@Entity
public class Employee {
	
	@Id
	private int eno;
	private String ename;
	private int sal;
	
	@OneToOne
	private Laptop laptop;
	
	@OneToOne
	private Vehicle vehicle;

	public Employee(int eno, String ename, int sal, Laptop laptop, Vehicle vehicle) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.sal = sal;
		this.laptop = laptop;
		this.vehicle = vehicle;
	}

	public Employee() {
		super();
	}

	public int getEno() {
		return eno;
	}

	public void setEno(int eno) {
		this.eno = eno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", ename=" + ename + ", sal=" + sal + ", laptop=" + laptop + ", vehicle="
				+ vehicle + "]";
	}
	
	
}
