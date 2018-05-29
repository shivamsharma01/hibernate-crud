package com.demo.entity;

import java.io.Serializable;

public class ClassroomPK implements Serializable {
	private int classroomId;
	private int batchId;

	public int getClassroomId() {
		return classroomId;
	}

	public void setClassroomId(int classroomId) {
		this.classroomId = classroomId;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}
}
