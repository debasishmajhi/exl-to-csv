package com.SFTP.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HRheirarchyMaster {

	@Id
	private String ERPID;
	private String Tower;
	private String BU;
	private String UserId;
	private String FirstName;
	private String LastNme;
	private String EmailID;
	private String UserStatus;
	private String SupervisorEscalatonID;
	private String SupervisorEmailID;
	private String userRole;
	private String userRoleStatus;
	
	public HRheirarchyMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HRheirarchyMaster(String eRPID, String tower, String bU, String userId, String firstName, String lastNme,
			String emailID, String userStatus, String supervisorEscalatonID, String supervisorEmailID, String userRole,
			String userRoleStatus) {
		super();
		ERPID = eRPID;
		Tower = tower;
		BU = bU;
		UserId = userId;
		FirstName = firstName;
		LastNme = lastNme;
		EmailID = emailID;
		UserStatus = userStatus;
		SupervisorEscalatonID = supervisorEscalatonID;
		SupervisorEmailID = supervisorEmailID;
		this.userRole = userRole;
		this.userRoleStatus = userRoleStatus;
	}

	public String getERPID() {
		return ERPID;
	}

	public void setERPID(String eRPID) {
		ERPID = eRPID;
	}

	public String getTower() {
		return Tower;
	}

	public void setTower(String tower) {
		Tower = tower;
	}

	public String getBU() {
		return BU;
	}

	public void setBU(String bU) {
		BU = bU;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastNme() {
		return LastNme;
	}

	public void setLastNme(String lastNme) {
		LastNme = lastNme;
	}

	public String getEmailID() {
		return EmailID;
	}

	public void setEmailID(String emailID) {
		EmailID = emailID;
	}

	public String getUserStatus() {
		return UserStatus;
	}

	public void setUserStatus(String userStatus) {
		UserStatus = userStatus;
	}

	public String getSupervisorEscalatonID() {
		return SupervisorEscalatonID;
	}

	public void setSupervisorEscalatonID(String supervisorEscalatonID) {
		SupervisorEscalatonID = supervisorEscalatonID;
	}

	public String getSupervisorEmailID() {
		return SupervisorEmailID;
	}

	public void setSupervisorEmailID(String supervisorEmailID) {
		SupervisorEmailID = supervisorEmailID;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUserRoleStatus() {
		return userRoleStatus;
	}

	public void setUserRoleStatus(String userRoleStatus) {
		this.userRoleStatus = userRoleStatus;
	}
	
	
	
	
	
	
}
