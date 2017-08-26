package com.invoice.jackson.mapper;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceRequestObjectList {
	
	@JsonProperty("invoice")
	private ArrayList<InvoiceDetails> invoice;

	public ArrayList<InvoiceDetails> getInvoice() {
		return invoice;
	}

	public void setInvoice(ArrayList<InvoiceDetails> invoice) {
		this.invoice = invoice;
	}

}
