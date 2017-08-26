package com.invoice.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.invoice.bean.InvoiceDetails;
import com.invoice.dao.InvoiceDAO;
import com.invoice.dao.InvoiceDAOImpl;
import com.invoice.jackson.mapper.InvoiceRequestObjectList;
import com.invoice.service.InvoiceService;
import com.invoice.service.InvoiceServiceImpl;
import com.invoice.util.InvoiceConstant;

@Controller

public class AddInvoiceDetailsController {
	
	 @Autowired
	 InvoiceDAO inVoiceDAO;
	 
	 @Autowired
	 InvoiceService invoiceService;
	
	
	
	@RequestMapping(value="/invoice/add.htm", method = RequestMethod.POST)
	public @ResponseBody InvoiceDetails add(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		InvoiceDetails invoice = new InvoiceDetails();
	    invoice.setInoviceId(request.getParameter("inoviceId"));
	    invoice.setName(request.getParameter("name"));
        invoice.setEmail(request.getParameter("email"));
        invoice.setDate(request.getParameter("invoicedate"));
        invoice.setDescription(request.getParameter("description"));
        invoice.setAmount(Float.parseFloat(request.getParameter("amount")));
        
      // float totalAmount= inVoiceDAO.SaveInvoiceDetails(invoice);
        
        float totalAmount= invoiceService.SaveInvoiceDetailsInFormFormat(invoice);
       
       invoice.setTotalAmount(totalAmount);
        
       

		return invoice;
	}
	

	/**
	 * @param invoiceRequestObjectList
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/invoice/addJson.htm", method = RequestMethod.POST)
	public @ResponseBody String addInvoiceAsJson(@RequestBody InvoiceRequestObjectList invoiceRequestObjectList, HttpServletResponse response)
			throws Exception {

		float totalAmount=invoiceService.SaveInvoiceAsJsonDetails(invoiceRequestObjectList);	
		return InvoiceConstant.ResponseToUI+totalAmount;
	}
	
	
	
}
