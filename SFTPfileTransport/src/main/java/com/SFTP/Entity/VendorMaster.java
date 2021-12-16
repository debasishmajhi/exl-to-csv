package com.SFTP.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VendorMaster {

	@Id
	private String ERPID;
	private int Supplier_ID;
	private String SupplierName;
	private String Enabled_flag;
	private int Term_id;
	private String Invoice_cuntry_code;
	private String Payment_cuntry_code;
	private Date Start_date_active;
	private Date End_date_start;
	private String Pament_method;
	private String Address_line1;
	private String Address_line2;
	private String Address_line3;
	private String city;
	private String State;
	private String Zip;
	private String country;
	private String remittance_email;
	
	public VendorMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VendorMaster(String eRPID, int supplier_ID, String supplierName, String enabled_flag, int term_id,
			String invoice_cuntry_code, String payment_cuntry_code, Date start_date_active, Date end_date_start,
			String pament_method, String address_line1, String address_line2, String address_line3, String city,
			String state, String zip, String country, String remittance_email) {
		super();
		ERPID = eRPID;
		Supplier_ID = supplier_ID;
		SupplierName = supplierName;
		Enabled_flag = enabled_flag;
		Term_id = term_id;
		Invoice_cuntry_code = invoice_cuntry_code;
		Payment_cuntry_code = payment_cuntry_code;
		Start_date_active = start_date_active;
		End_date_start = end_date_start;
		Pament_method = pament_method;
		Address_line1 = address_line1;
		Address_line2 = address_line2;
		Address_line3 = address_line3;
		this.city = city;
		State = state;
		Zip = zip;
		this.country = country;
		this.remittance_email = remittance_email;
	}

	public String getERPID() {
		return ERPID;
	}

	public void setERPID(String eRPID) {
		ERPID = eRPID;
	}

	public int getSupplier_ID() {
		return Supplier_ID;
	}

	public void setSupplier_ID(int supplier_ID) {
		Supplier_ID = supplier_ID;
	}

	public String getSupplierName() {
		return SupplierName;
	}

	public void setSupplierName(String supplierName) {
		SupplierName = supplierName;
	}

	public String getEnabled_flag() {
		return Enabled_flag;
	}

	public void setEnabled_flag(String enabled_flag) {
		Enabled_flag = enabled_flag;
	}

	public int getTerm_id() {
		return Term_id;
	}

	public void setTerm_id(int term_id) {
		Term_id = term_id;
	}

	public String getInvoice_cuntry_code() {
		return Invoice_cuntry_code;
	}

	public void setInvoice_cuntry_code(String invoice_cuntry_code) {
		Invoice_cuntry_code = invoice_cuntry_code;
	}

	public String getPayment_cuntry_code() {
		return Payment_cuntry_code;
	}

	public void setPayment_cuntry_code(String payment_cuntry_code) {
		Payment_cuntry_code = payment_cuntry_code;
	}

	public Date getStart_date_active() {
		return Start_date_active;
	}

	public void setStart_date_active(Date start_date_active) {
		Start_date_active = start_date_active;
	}

	public Date getEnd_date_start() {
		return End_date_start;
	}

	public void setEnd_date_start(Date end_date_start) {
		End_date_start = end_date_start;
	}

	public String getPament_method() {
		return Pament_method;
	}

	public void setPament_method(String pament_method) {
		Pament_method = pament_method;
	}

	public String getAddress_line1() {
		return Address_line1;
	}

	public void setAddress_line1(String address_line1) {
		Address_line1 = address_line1;
	}

	public String getAddress_line2() {
		return Address_line2;
	}

	public void setAddress_line2(String address_line2) {
		Address_line2 = address_line2;
	}

	public String getAddress_line3() {
		return Address_line3;
	}

	public void setAddress_line3(String address_line3) {
		Address_line3 = address_line3;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getZip() {
		return Zip;
	}

	public void setZip(String zip) {
		Zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRemittance_email() {
		return remittance_email;
	}

	public void setRemittance_email(String remittance_email) {
		this.remittance_email = remittance_email;
	}
	
	
	
	
	
	
}
