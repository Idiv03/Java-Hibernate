package com.divya.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {
	@Id
	@Column(name = "SID")
	private Integer Sid;
	
	@Column(name="SNAME")
	private String sName;
	
	@Column(name="SCITY")
	private String sCity;
	
	public Student() {
		System.out.println("Zero Param Constructor for Hibernate");
	}

	public Integer getSid() {
		return Sid;
	}

	public void setSid(Integer sid) {
		this.Sid = sid;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getScity() {
		return sCity;
	}

	public void setScity(String scity) {
		this.sCity = scity;
	}

	@Override
	public String toString() {
		return "Student [sid=" + Sid + ", sName=" + sName + ", scity=" + sCity + "]";
	}
	
	
	
}
