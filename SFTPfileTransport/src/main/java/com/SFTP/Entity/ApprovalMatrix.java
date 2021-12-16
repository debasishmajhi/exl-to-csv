package com.SFTP.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ApprovalMatrix {

	@Id
	private String Tower;
	private String Request_Type;
	private String Station;
	private String Dept;
	private int Minimum_Limit;
	private int Maximum_Limit;
	private String Status;
	private String Approval_Id;
	private int Approval_Level;
	
	public ApprovalMatrix() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApprovalMatrix(String tower, String request_Type, String station, String dept, int minimum_Limit,
			int maximum_Limit, String status, String approval_Id, int approval_Level) {
		super();
		Tower = tower;
		Request_Type = request_Type;
		Station = station;
		Dept = dept;
		Minimum_Limit = minimum_Limit;
		Maximum_Limit = maximum_Limit;
		Status = status;
		Approval_Id = approval_Id;
		Approval_Level = approval_Level;
	}

	public String getTower() {
		return Tower;
	}

	public void setTower(String tower) {
		Tower = tower;
	}

	public String getRequest_Type() {
		return Request_Type;
	}

	public void setRequest_Type(String request_Type) {
		Request_Type = request_Type;
	}

	public String getStation() {
		return Station;
	}

	public void setStation(String station) {
		Station = station;
	}

	public String getDept() {
		return Dept;
	}

	public void setDept(String dept) {
		Dept = dept;
	}

	public int getMinimum_Limit() {
		return Minimum_Limit;
	}

	public void setMinimum_Limit(int minimum_Limit) {
		Minimum_Limit = minimum_Limit;
	}

	public int getMaximum_Limit() {
		return Maximum_Limit;
	}

	public void setMaximum_Limit(int maximum_Limit) {
		Maximum_Limit = maximum_Limit;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getApproval_Id() {
		return Approval_Id;
	}

	public void setApproval_Id(String approval_Id) {
		Approval_Id = approval_Id;
	}

	public int getApproval_Level() {
		return Approval_Level;
	}

	public void setApproval_Level(int approval_Level) {
		Approval_Level = approval_Level;
	}
	
	
	
	
	
}
