package com.mrv.intern.invoicematch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrv.intern.invoicematch.dao.MatchInvoiceDAO;
import com.mrv.intern.invoicematch.model.EdcSthFrt;
import com.mrv.intern.invoicematch.model.HEBPoLinItmVO;
import com.mrv.intern.invoicematch.model.HEBPoVO;
import com.mrv.intern.invoicematch.model.VendAsnLinItmShpd;
import com.mrv.intern.invoicematch.model.VendInvFrtLinItmVO;
import com.mrv.intern.invoicematch.model.VendInvPoLinItmVO;
import com.mrv.intern.invoicematch.model.VendInvPoVO;
import com.sun.org.apache.regexp.internal.recompile;

@Service
public class ImportInvoiceData {
	@Autowired
	MatchInvoiceDAO matchInvoiceDAO;
	public String getInvoiceTypeByVendorId(String vendId){
		//.....................
//		return "COGS";//COGS/FRT
		return matchInvoiceDAO.getInvoiceTypeByVendorId(vendId);
	}
	public List<VendInvPoVO> getListOrderByInvoiceId(String invId){
		return matchInvoiceDAO.getListOrderByInvoiceId(invId);
	}
	public List<VendInvPoLinItmVO> getListItemInOrder(String invId,String ordId){
		//call DAO to get
		return matchInvoiceDAO.getListItemInOrder(invId, ordId);
	}
	public List<VendInvFrtLinItmVO> getListFrtItemByInvoiceId(String invId){
		//call DAO to get
		return matchInvoiceDAO.getListFrtItemByInvoiceId(invId);
	}
	
	public List<VendInvPoVO> getListVendInvPoByVendInvNbr(String vendInvNbr){
		return matchInvoiceDAO.getListVendInvPoByVendInvNbr(vendInvNbr);
	}
	
	public List<VendInvFrtLinItmVO> getListVendInvFrtLinItmByVendInvNbr(String vendInvNbr){
		return matchInvoiceDAO.getListVendInvFrtLinItmByVendInvNbr(vendInvNbr);
	}
	
	public List<VendInvPoLinItmVO> getListVendInvPoLinItmByOrdHdrIdAndVendInvNbr(String ordHdrId,String vendInvNbr){
		return matchInvoiceDAO.getListVendInvPoLinItmByOrdHdrIdAndVendInvNbr(ordHdrId, vendInvNbr);
	}
	
	public HEBPoVO getListHEBPoByVendId(String vendId){
		return matchInvoiceDAO.getListHEBPoByVendId(vendId);
	}
	
	public HEBPoLinItmVO getListHEBPoLinItmByOrdHdrIdAndProdScnCd(String ordHdrId, String prodScnCd){
		return matchInvoiceDAO.getListHEBPoLinItmByOrdHdrIdAndProdScnCd(ordHdrId, prodScnCd);
	}
	
	public Boolean matchLinItm(String vendLinItmQty, String vendLinItmAmt, String hebLintItmQty, String hebLinItmAmt){
		return matchInvoiceDAO.matchLinItm(vendLinItmQty, vendLinItmAmt, hebLintItmQty, hebLinItmAmt);
	}
	
	public void updateStatusItm(String statusForVend, String statusForHeb, String ordDhrId, String ScnCd){
		matchInvoiceDAO.updateStatusItm(statusForVend, statusForHeb, ordDhrId, ScnCd);
	}
	
	public void updateStatusPo(String statusForVend, String statusForHeb, String vendId, String vendOrdDhrId, String vendInvNbr){
		matchInvoiceDAO.updateStatusPo(statusForVend, statusForHeb, vendId, vendOrdDhrId, vendInvNbr);
	}
	
	public void updateStatusHdr(String statusForVend, String vendInvNbr){
		matchInvoiceDAO.updateStatusHdr(statusForVend, vendInvNbr);
	}
	
	public EdcSthFrt getEdcSthFrt (String trkgId){
		return matchInvoiceDAO.getEdcSthFrt(trkgId);
	}
	
	public Boolean matchFrtLinItm(String edcEstShpgCstAmt, String frtVendPoShpgCstAmt){
		return matchInvoiceDAO.matchFrtLinItm(edcEstShpgCstAmt, frtVendPoShpgCstAmt);
	}
	
	public void updateStatusFrtEdc(String statusEdc, String statusFrt, String vendTrkgId, String vendInvNbr){
		matchInvoiceDAO.updateStatusFrtEdc(statusEdc, statusFrt, vendTrkgId, vendInvNbr);
	}
	
	public List<VendAsnLinItmShpd> getQtyFromAsn(String trkgId){
		return matchInvoiceDAO.getQtyFromAsn(trkgId);
	}
	
	public List<HEBPoLinItmVO> getListShpgCostFromHEBPoLinItm(String ordDhrId, String prodScnCd){
		return matchInvoiceDAO.getListShpgCostFromHEBPoLinItm(ordDhrId, prodScnCd);
	}
	
	public Boolean matchFrtLinItmAsn(String EstShpgCstAmt, String frtVendPoShpgCstAmt){
		return matchInvoiceDAO.matchFrtLinItmAsn(EstShpgCstAmt, frtVendPoShpgCstAmt);
	}
	
	public void updateStatusFrtAndAsnByTrkgId (String statusForFrt, String statusdForAsn, String trkgId){
		matchInvoiceDAO.updateStatusFrtAndAsnByTrkgId(statusForFrt, statusdForAsn, trkgId);
	}
}
