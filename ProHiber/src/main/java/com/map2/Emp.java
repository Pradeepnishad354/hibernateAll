package com.map2;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Emp {
	@Id
	private int empId;
	private String name;
	
	@ManyToMany
	@JoinTable(name="emp_learn",joinColumns = {@JoinColumn(name="eId")}
	,inverseJoinColumns = {@JoinColumn(name="pId")})
	private List<Project> projects;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	public Emp(int empId, String name, List<Project> projects) {
		super();
		this.empId = empId;
		this.name = name;
		this.projects = projects;
	}
	public Emp() {
		// TODO Auto-generated constructor stub
	}
	
	

}
