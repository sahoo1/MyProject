package com.invoice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoice.dao.InvoiceDAO;
import com.invoice.dao.InvoiceDAOImpl;
import com.invoice.jackson.mapper.InvoiceDetails;
import com.invoice.jackson.mapper.InvoiceRequestObjectList;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	InvoiceDAO inVoiceDAO;
	
	

	/* (non-Javadoc)
	 * @see Service class to store to call the Dao Layer
	 */
	@Override
	public float SaveInvoiceAsJsonDetails(InvoiceRequestObjectList invoiceRequestObjectList) {

		float total=0;
		List<InvoiceDetails> invoiceDetailsList=invoiceRequestObjectList.getInvoice();
		
		if(null!=invoiceDetailsList && invoiceDetailsList.size()!=0){

		for(InvoiceDetails invoicedetails :invoiceDetailsList)
		{
			inVoiceDAO.insertInvoiceDetailsFromJson(invoicedetails);
			total=inVoiceDAO.insertPriceDetailsFromJson(invoicedetails.getInvoiceid(),invoicedetails.getInvoicepricedetails());
		}
		
		}else {
			System.out.println("There is some problem in invoiceDetailsList");
		}
		return total;

	}



	@Override
	public float SaveInvoiceDetailsInFormFormat(com.invoice.bean.InvoiceDetails invoice) {
		
		
		return (inVoiceDAO.SaveInvoiceDetails(invoice));
	}

}
