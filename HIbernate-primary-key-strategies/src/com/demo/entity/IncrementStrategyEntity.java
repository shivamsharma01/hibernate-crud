package com.demo.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="TABLE_INCREMENT")
@GenericGenerator(name="idgen", strategy="increment")
public class IncrementStrategyEntity {
	@Id
	@GeneratedValue(generator="idgen")
	private Integer id;
	@Column(name="ENTRY_DATE")
	@Temporal(TemporalType.DATE)
	private Calendar date;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
}
