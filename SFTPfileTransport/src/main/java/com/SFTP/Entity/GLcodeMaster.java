package com.SFTP.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class GLcodeMaster {

	@Id
	private String business_unit;
	private String Corporate_Division_Code;
	private String Corp_Div_Description;
	private String Dept_Code;
	private String Dept_Description_Code;
	private String LIB_code;
	private String LIB_description;
	private String GLA_account;
	private String GLA_account_description;
	private Date Start_date_active;
	private Date end_date_active;
	private String activeInactive;
	
	public GLcodeMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GLcodeMaster(String business_unit, String corporate_Division_Code, String corp_Div_Description,
			String dept_Code, String dept_Description_Code, String lIB_code, String lIB_description, String gLA_account,
			String gLA_account_description, Date start_date_active, Date end_date_active, String activeInactive) {
		super();
		this.business_unit = business_unit;
		Corporate_Division_Code = corporate_Division_Code;
		Corp_Div_Description = corp_Div_Description;
		Dept_Code = dept_Code;
		Dept_Description_Code = dept_Description_Code;
		LIB_code = lIB_code;
		LIB_description = lIB_description;
		GLA_account = gLA_account;
		GLA_account_description = gLA_account_description;
		Start_date_active = start_date_active;
		this.end_date_active = end_date_active;
		this.activeInactive = activeInactive;
	}

	public String getBusiness_unit() {
		return business_unit;
	}

	public void setBusiness_unit(String business_unit) {
		this.business_unit = business_unit;
	}

	public String getCorporate_Division_Code() {
		return Corporate_Division_Code;
	}

	public void setCorporate_Division_Code(String corporate_Division_Code) {
		Corporate_Division_Code = corporate_Division_Code;
	}

	public String getCorp_Div_Description() {
		return Corp_Div_Description;
	}

	public void setCorp_Div_Description(String corp_Div_Description) {
		Corp_Div_Description = corp_Div_Description;
	}

	public String getDept_Code() {
		return Dept_Code;
	}

	public void setDept_Code(String dept_Code) {
		Dept_Code = dept_Code;
	}

	public String getDept_Description_Code() {
		return Dept_Description_Code;
	}

	public void setDept_Description_Code(String dept_Description_Code) {
		Dept_Description_Code = dept_Description_Code;
	}

	public String getLIB_code() {
		return LIB_code;
	}

	public void setLIB_code(String lIB_code) {
		LIB_code = lIB_code;
	}

	public String getLIB_description() {
		return LIB_description;
	}

	public void setLIB_description(String lIB_description) {
		LIB_description = lIB_description;
	}

	public String getGLA_account() {
		return GLA_account;
	}

	public void setGLA_account(String gLA_account) {
		GLA_account = gLA_account;
	}

	public String getGLA_account_description() {
		return GLA_account_description;
	}

	public void setGLA_account_description(String gLA_account_description) {
		GLA_account_description = gLA_account_description;
	}

	public Date getStart_date_active() {
		return Start_date_active;
	}

	public void setStart_date_active(Date start_date_active) {
		Start_date_active = start_date_active;
	}

	public Date getEnd_date_active() {
		return end_date_active;
	}

	public void setEnd_date_active(Date end_date_active) {
		this.end_date_active = end_date_active;
	}

	public String getActiveInactive() {
		return activeInactive;
	}

	public void setActiveInactive(String activeInactive) {
		this.activeInactive = activeInactive;
	}
	
	
	
	
	
	
}
