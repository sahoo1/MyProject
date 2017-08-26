package com.invoice.service;

import com.invoice.bean.InvoiceDetails;
import com.invoice.jackson.mapper.InvoiceRequestObjectList;

public interface InvoiceService {
	
	public float SaveInvoiceAsJsonDetails(InvoiceRequestObjectList invoiceRequestObjectList) ;

	public float SaveInvoiceDetailsInFormFormat(InvoiceDetails invoice);

}
