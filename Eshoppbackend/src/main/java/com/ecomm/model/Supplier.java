package com.ecomm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Supplier {
	@GeneratedValue
	@Id
	private int supId;
	private String supName;
	private String supLocation;
	public int getSupId() {
		return supId;
	}
	public void setSupId(int supId) {
		this.supId = supId;
	}
	public String getSupName() {
		return supName;
	}
	public void setSupName(String supName) {
		this.supName = supName;
	}
	public String getSupLocation() {
		return supLocation;
	}
	public void setSupLocation(String supLocation) {
		this.supLocation = supLocation;
	}
	
		
	
	
	

}
