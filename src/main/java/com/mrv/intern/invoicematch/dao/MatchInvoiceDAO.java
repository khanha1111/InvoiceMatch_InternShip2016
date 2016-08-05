package com.mrv.intern.invoicematch.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mrv.intern.invoicematch.model.HEBPoVO;
import com.mrv.intern.invoicematch.model.VendAsnLinItmShpd;
import com.mrv.intern.invoicematch.model.EdcSthFrt;
import com.mrv.intern.invoicematch.model.HEBPoLinItmVO;
import com.mrv.intern.invoicematch.model.VendInvFrtLinItmVO;
import com.mrv.intern.invoicematch.model.VendInvPoLinItmVO;
import com.mrv.intern.invoicematch.model.VendInvPoVO;
@Repository
public interface MatchInvoiceDAO {
	public String getInvoiceTypeByVendorId(String vendId);
	public List<VendInvPoVO> getListOrderByInvoiceId(String invId);
	public List<VendInvPoLinItmVO> getListItemInOrder(String invId,String ordId);
	public List<VendInvFrtLinItmVO> getListFrtItemByInvoiceId(String invId);
	/**
	 * get list
	 * @return list VendInvPoVO
	 * @param vendInvNbr
	 * @author Xuan Vu
	 * 
	 */
	public List<VendInvPoVO> getListVendInvPoByVendInvNbr(String vendInvNbr);
	/**
	 * get list
	 * @return list VendInvFrtLinItmVO
	 * @param vendInvNbr
	 * @author Xuan Vu
	 * 
	 */
	public List<VendInvFrtLinItmVO> getListVendInvFrtLinItmByVendInvNbr(String vendInvNbr);
	/**
	 * get list
	 * @return list VendInvPoLinItmVO
	 * @param ordHdrId, vendInvNbr
	 * @author Xuan Vu
	 * 
	 */
	public List<VendInvPoLinItmVO> getListVendInvPoLinItmByOrdHdrIdAndVendInvNbr(String ordHdrId,String vendInvNbr);
	/**
	 * get object
	 * @return HEBPoVO
	 * @param vendId
	 * @author Xuan Vu
	 * 
	 */
	public HEBPoVO getListHEBPoByVendId(String vendId);
	/**
	 * get object
	 * @return HEBPoLinItmVO
	 * @param ordHdrId, prodScnCd
	 * @author Xuan Vu
	 * 
	 */
	public HEBPoLinItmVO getListHEBPoLinItmByOrdHdrIdAndProdScnCd(String ordHdrId, String prodScnCd);
	/**
	 * matching LinItm
	 * @return boolean
	 * @param vendLinItmQty, vendLinItmAmt, hebLintItmQty, hebLinItmAmt
	 * @author Xuan Vu
	 * 
	 */
	public Boolean matchLinItm(String vendLinItmQty, String vendLinItmAmt, String hebLintItmQty, String hebLinItmAmt);
	/**
	 * update status after matching LinItm
	 * @return void
	 * @param statusForVend, statusForHeb, ordDhrId, ScnCd
	 * @author Xuan Vu
	 * 
	 */
	public void updateStatusItm(String statusForVend, String statusForHeb, String ordDhrId, String ScnCd);
	/**
	 * update status for Po
	 * @return void
	 * @param statusForVend, statusForHeb, vendId, vendOrdDhrId, vendInvNbr
	 * @author Xuan Vu
	 * 
	 */
	public void updateStatusPo(String statusForVend, String statusForHeb, String vendId, String vendOrdDhrId,String vendInvNbr);
	/**
	 * update status for Hdr
	 * @return void
	 * @param statusForVend, vendInvNbr
	 * @author Xuan Vu
	 * 
	 */
	public void updateStatusHdr(String statusForVend, String vendInvNbr);
	/**
	 * get object
	 * @return EdcSthFrt
	 * @param trkgId
	 * @author Xuan Vu
	 * 
	 */
	public EdcSthFrt getEdcSthFrt (String trkgId);
	/**
	 * matching Frt Itm with EDC
	 * @return void
	 * @param edcEstShpgCstAmt, frtVendPoShpgCstAmt
	 * @author Xuan Vu
	 * 
	 */
	public Boolean matchFrtLinItm(String edcEstShpgCstAmt, String frtVendPoShpgCstAmt);
	/**
	 * update status after matching Frt Itm with EDC
	 * @return void
	 * @param statusEdc, statusFrt, vendTrkgId, vendInvNbr
	 * @author Xuan Vu
	 * 
	 */
	public void updateStatusFrtEdc(String statusEdc, String statusFrt, String vendTrkgId,String vendInvNbr);
	/**
	 * get list
	 * @return list VendAsnLinItmShpd
	 * @param trkgId
	 * @author Xuan Vu
	 * 
	 */
	public List<VendAsnLinItmShpd> getQtyFromAsn(String trkgId);
	/**
	 * get list
	 * @return list HEBPoLinItmVO
	 * @param ordDhrId, prodScnCd
	 * @author Xuan Vu
	 * 
	 */
	public List<HEBPoLinItmVO> getListShpgCostFromHEBPoLinItm(String ordDhrId, String prodScnCd);
	/**
	 * matching Frt Itm with Asn
	 * @return boolean
	 * @param EstShpgCstAmt, frtVendPoShpgCstAmt
	 * @author Xuan Vu
	 * 
	 */
	public Boolean matchFrtLinItmAsn(String EstShpgCstAmt, String frtVendPoShpgCstAmt);
	/**
	 * update status for Frt Itm after matching Frt Itm with Asn
	 * @return void
	 * @param statusForFrt, statusdForAsn, trkgId
	 * @author Xuan Vu
	 * 
	 */
	public void updateStatusFrtAndAsnByTrkgId (String statusForFrt, String statusdForAsn, String trkgId);
}
