package com.mrv.intern.invoicematch.service;
/**
 * @author tuhv
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrv.intern.invoicematch.dao.SearchInvoiceDAO;
import com.mrv.intern.invoicematch.model.SearchInvoice;
@Service
public class SeachInvoiceService {
	SearchInvoice searchInvoice;
	@Autowired
	private SearchInvoiceDAO searchInvoiceDAO;

	public List<SearchInvoice> searchInvoice(String vendorID, String invoiceID, String trackingID, String orderID) {
		return searchInvoiceDAO.searchInvoice(vendorID, invoiceID, trackingID, orderID);

	}
	public List<SearchInvoice> list(){
		return searchInvoiceDAO.list();
	}
	public List<SearchInvoice> listVendor(){
		return searchInvoiceDAO.listVendor();
	}
	public List<SearchInvoice> listInvoice(){
		return searchInvoiceDAO.listInvoice();
	}
	public List<SearchInvoice> listTracking(){
		return searchInvoiceDAO.listTracking();
	}
	public List<SearchInvoice> listOrder(){
		return searchInvoiceDAO.listOrder();
	}
}
