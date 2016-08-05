package com.mrv.intern.invoicematch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrv.intern.invoicematch.dao.InvoiceDAO;
import com.mrv.intern.invoicematch.model.ReportInvStat;
import com.mrv.intern.invoicematch.model.ReportVendInvHdrVO;

@Service
public class InvoiceService {
	ReportVendInvHdrVO reportVendInvHdrVO;
	
	@Autowired
	InvoiceDAO invoiceDAO;
	
	public List<ReportVendInvHdrVO> getAllInvoice(){
		return invoiceDAO.getAllInvoice();
	}
	
	public List<ReportInvStat> getInvStat(){
		return invoiceDAO.getInvStat();
		
	}
	
	public List<ReportVendInvHdrVO> searchInvoice(String dayStart, String dayEnd, String invStat){
		return invoiceDAO.searchInvoice(dayStart, dayEnd, invStat);
	}
}
