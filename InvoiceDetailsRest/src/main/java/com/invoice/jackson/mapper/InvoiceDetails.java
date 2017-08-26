package com.invoice.jackson.mapper;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceDetails {
	
	   @JsonProperty("invoiceid")
	    private String invoiceid;
	
	   @JsonProperty("name")
	    private String name;
	   
	    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

		@JsonProperty("email")
		private String email;
		
	    @JsonProperty("date")
	    private String date;
		
	    @JsonProperty("invoicepricedetails")
		private ArrayList<InvoicePriceDetails> invoicepricedetails;

		public String getInvoiceid() {
			return invoiceid;
		}

		public void setInvoiceid(String invoiceid) {
			this.invoiceid = invoiceid;
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

		public ArrayList<InvoicePriceDetails> getInvoicepricedetails() {
			return invoicepricedetails;
		}

		public void setInvoicepricedetails(ArrayList<InvoicePriceDetails> invoicepricedetails) {
			this.invoicepricedetails = invoicepricedetails;
		}
}
