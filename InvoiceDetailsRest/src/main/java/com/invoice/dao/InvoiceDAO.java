package com.invoice.dao;

import java.util.ArrayList;

import com.invoice.bean.InvoiceDetails;
import com.invoice.jackson.mapper.InvoicePriceDetails;

public interface InvoiceDAO {
	
	public float SaveInvoiceDetails(InvoiceDetails invoice);
	public void insertInvoiceDetailsFromJson(com.invoice.jackson.mapper.InvoiceDetails invoicedetails);
	public float insertPriceDetailsFromJson(String invoice_id, ArrayList<InvoicePriceDetails> invoicePriceDetailsList);


}
