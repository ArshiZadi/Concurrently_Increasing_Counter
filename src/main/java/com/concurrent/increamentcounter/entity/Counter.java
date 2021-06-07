package com.concurrent.increamentcounter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "counter")
public class Counter {
	
	@Id
	Long id;
	@Column
	int counterValue;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getCounterValue() {
		return counterValue;
	}
	public void setCounterValue(int counterValue) {
		this.counterValue = counterValue;
	}
	

}
