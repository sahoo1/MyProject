package com.invoice.bean;

public class InvoiceDetails {

	private String inoviceId ;

	private String name;

	private String email;

	private String date;

	private String description;

	private float amount;
	
	private float totalAmount ;

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getName() {
		return name;
	}
	
	public String getInoviceId() {
		return inoviceId;
	}

	public void setInoviceId(String inoviceId) {
		this.inoviceId = inoviceId;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}





}
