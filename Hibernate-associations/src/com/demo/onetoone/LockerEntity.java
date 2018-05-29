package com.demo.onetoone;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LOCKER_ASSOCIATION_TABLE")
public class LockerEntity {
	@Id
	private int lockerId;
	private Calendar lastAccessed;
	public int getLockerId() {
		return lockerId;
	}
	public void setLockerId(int lockerId) {
		this.lockerId = lockerId;
	}
	public Calendar getLastAccessed() {
		return lastAccessed;
	}
	public void setLastAccessed(Calendar lastAccessed) {
		this.lastAccessed = lastAccessed;
	}
}
