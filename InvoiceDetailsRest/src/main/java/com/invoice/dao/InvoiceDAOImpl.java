package com.invoice.dao;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.invoice.bean.InvoiceDetails;
import com.invoice.jackson.mapper.InvoicePriceDetails;

public class InvoiceDAOImpl implements InvoiceDAO{


	private JdbcTemplate jdbcTemplate;
	
	     @Autowired
	    public void setDataSource(DataSource dataSource) {
	    	this.jdbcTemplate = new JdbcTemplate(dataSource);
	    }


	@Override
	public float SaveInvoiceDetails(InvoiceDetails invoice) {

		float totalAmount=0;

		String query = "insert into invoiceDetails (invoice_id,invoice_name,email_id,invoice_date) values (?,?,?,?)";

		jdbcTemplate.update(query,new Object[] { invoice.getInoviceId(),invoice.getName(),invoice.getEmail(),invoice.getDate()});

		String query1 = "insert into invoiceDescription (invoice_id,invoice_description,invoice_amount) values (?,?,?)";

		jdbcTemplate.update(query1,new Object[] {invoice.getInoviceId(),invoice.getDescription(),invoice.getAmount()});
       
		return totalAmount=totalAmount+invoice.getAmount();
      
	}

	/* (non-Javadoc)
	 * @To Stote the Invoice Details in invoiceDetails 
	 */
	@Override
	public void insertInvoiceDetailsFromJson(com.invoice.jackson.mapper.InvoiceDetails invoicedetails) {

		String query = "insert into invoiceDetails (invoice_id,invoice_name,email_id,invoice_date) values (?,?,?,?)";

		try{
		jdbcTemplate.update(query,new Object[] { invoicedetails.getInvoiceid(),invoicedetails.getName(),invoicedetails.getEmail(),invoicedetails.getDate()});
		}catch(Exception e){
			
			System.out.println(e.getMessage());
		}
	}

	/* (non-Javadoc)
	 * @To Store the Invoice Price Details in invoiceDescription
	 */
	@Override
	public float insertPriceDetailsFromJson(String invoice_id, ArrayList<InvoicePriceDetails> invoicePriceDetailsList) {

		String query = "insert into invoiceDescription (invoice_id,invoice_description,invoice_amount) values (?,?,?)";
		float totalAmount=0;
		try{
			for(InvoicePriceDetails invoicePriceDetails :invoicePriceDetailsList){

				totalAmount=totalAmount+Float.parseFloat(invoicePriceDetails.getAmount());
				jdbcTemplate.update(query,new Object[] {invoice_id,invoicePriceDetails.getDescription(),invoicePriceDetails.getAmount()});
			}

			System.out.println("Total Invoice amount for all description "+totalAmount);
		}catch(Exception e){
			System.out.println(e.getMessage()); 
		}

		return totalAmount ;
	}

}
