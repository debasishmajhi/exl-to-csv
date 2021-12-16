package com.SFTP.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PoHeader_Master {

	@Id
	private String ERPID;
	private String CompanyCode;
	private String BusinessUnitID;
	private String poNumber;
	private Date poDate;
	private char poStatus;
	private String PaymentTerms;
	private String PaymentTermDescription;
	private int TermsAbsoluteNumber;
	private String Currency;
	private int poTotal;
	private String poRequester;
	private String vendorID;
	
	public PoHeader_Master() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PoHeader_Master(String eRPID, String companyCode, String businessUnitID, String poNumber, Date poDate,
			char poStatus, String paymentTerms, String paymentTermDescription, int termsAbsoluteNumber, String currency,
			int poTotal, String poRequester, String vendorID) {
		super();
		ERPID = eRPID;
		CompanyCode = companyCode;
		BusinessUnitID = businessUnitID;
		this.poNumber = poNumber;
		this.poDate = poDate;
		this.poStatus = poStatus;
		PaymentTerms = paymentTerms;
		PaymentTermDescription = paymentTermDescription;
		TermsAbsoluteNumber = termsAbsoluteNumber;
		Currency = currency;
		this.poTotal = poTotal;
		this.poRequester = poRequester;
		this.vendorID = vendorID;
	}

	public String getERPID() {
		return ERPID;
	}

	public void setERPID(String eRPID) {
		ERPID = eRPID;
	}

	public String getCompanyCode() {
		return CompanyCode;
	}

	public void setCompanyCode(String companyCode) {
		CompanyCode = companyCode;
	}

	public String getBusinessUnitID() {
		return BusinessUnitID;
	}

	public void setBusinessUnitID(String businessUnitID) {
		BusinessUnitID = businessUnitID;
	}

	public String getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public Date getPoDate() {
		return poDate;
	}

	public void setPoDate(Date poDate) {
		this.poDate = poDate;
	}

	public char getPoStatus() {
		return poStatus;
	}

	public void setPoStatus(char poStatus) {
		this.poStatus = poStatus;
	}

	public String getPaymentTerms() {
		return PaymentTerms;
	}

	public void setPaymentTerms(String paymentTerms) {
		PaymentTerms = paymentTerms;
	}

	public String getPaymentTermDescription() {
		return PaymentTermDescription;
	}

	public void setPaymentTermDescription(String paymentTermDescription) {
		PaymentTermDescription = paymentTermDescription;
	}

	public int getTermsAbsoluteNumber() {
		return TermsAbsoluteNumber;
	}

	public void setTermsAbsoluteNumber(int termsAbsoluteNumber) {
		TermsAbsoluteNumber = termsAbsoluteNumber;
	}

	public String getCurrency() {
		return Currency;
	}

	public void setCurrency(String currency) {
		Currency = currency;
	}

	public int getPoTotal() {
		return poTotal;
	}

	public void setPoTotal(int poTotal) {
		this.poTotal = poTotal;
	}

	public String getPoRequester() {
		return poRequester;
	}

	public void setPoRequester(String poRequester) {
		this.poRequester = poRequester;
	}

	public String getVendorID() {
		return vendorID;
	}

	public void setVendorID(String vendorID) {
		this.vendorID = vendorID;
	}
	
	
	
	
	
}
