package com.mrv.intern.invoicematch.batch;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mrv.intern.invoicematch.model.EdcSthFrt;
import com.mrv.intern.invoicematch.model.HEBPoLinItmVO;
import com.mrv.intern.invoicematch.model.VendAsnLinItmShpd;
import com.mrv.intern.invoicematch.model.VendInvFrtLinItmVO;
import com.mrv.intern.invoicematch.model.VendInvHdrVO;
import com.mrv.intern.invoicematch.model.VendInvPoLinItmVO;
import com.mrv.intern.invoicematch.model.VendInvPoVO;
import com.mrv.intern.invoicematch.service.ImportInvoiceData;
import com.mrv.intern.invoicematch.utils.Constants;

public class SelectFromVendInvHDRItemWriter implements org.springframework.batch.item.ItemWriter<VendInvHdrVO> {
	@Autowired
	private ImportInvoiceData importInvoiceData;

	@Override
	public void write(List<? extends VendInvHdrVO> items) throws Exception {
		if (items != null) {
			List<VendInvPoVO> listPo = new ArrayList<VendInvPoVO>();
			List<VendInvFrtLinItmVO> listFrt = new ArrayList<VendInvFrtLinItmVO>();
			List<VendInvPoLinItmVO> listItm = new ArrayList<VendInvPoLinItmVO>();
			HEBPoLinItmVO hebPoLinItm = null;
			EdcSthFrt edcSthFrt;
			List<VendAsnLinItmShpd> vendAsn = new ArrayList<VendAsnLinItmShpd>();
			for (VendInvHdrVO vendHdr : items) {
				// GETING LIST VEND_INV_PO OR LIST VEND_INV_FRT_ITM FOR EACH
				// VEND_INV_HDR IN LIST TO MATCH
				listPo = vendHdr.getLstVendInvPoVO();
				listFrt = vendHdr.getLstVendInvFrtLinItmVO();
				Boolean checkListPo = true;
				// MATCHING TYPE PO
				if (listPo != null) {
					for (VendInvPoVO vendPo : listPo) {
						listItm = vendPo.getLstVendInvPoLinItmVO();
						Boolean checkListItm = true;
						if (listItm.size() != 0) {
							for (VendInvPoLinItmVO itmheb : listItm) {
								hebPoLinItm = importInvoiceData.getListHEBPoLinItmByOrdHdrIdAndProdScnCd(
										itmheb.getVendOrdHdrId(), itmheb.getVendProdScnCd());
								if (hebPoLinItm != null) {
									if (importInvoiceData.matchLinItm(itmheb.getVendLinItmQty(),
											itmheb.getVendLinItmAmt(), hebPoLinItm.getLinItmQuy(),
											hebPoLinItm.getLinItmAmt()) == true) {
										importInvoiceData.updateStatusItm(Constants.KEY_MATCH, Constants.KEY_CLSD,
												itmheb.getVendOrdHdrId(), itmheb.getVendProdScnCd());
									} else {
										checkListItm = false;
										importInvoiceData.updateStatusItm(Constants.KEY_MISMT, Constants.KEY_READY,
												itmheb.getVendOrdHdrId(), itmheb.getVendProdScnCd());
									}
								} else {
									checkListItm = false;
									importInvoiceData.updateStatusItm(Constants.KEY_MISMT, Constants.KEY_READY,
											itmheb.getVendOrdHdrId(), itmheb.getVendProdScnCd());
								}
							}
						} else
							checkListItm = false;
						if (checkListItm == true) {
							importInvoiceData.updateStatusPo(Constants.KEY_MATCH, Constants.KEY_CLSD,
									vendPo.getVendID(), vendPo.getVendOrdHdrId(), vendPo.getVendInvNbr());
						} else {
							checkListPo = false;
							importInvoiceData.updateStatusPo(Constants.KEY_MISMT, Constants.KEY_READY,
									vendPo.getVendID(), vendPo.getVendOrdHdrId(), vendPo.getVendInvNbr());
						}

					}
					// MATCHING TYPE FRT ITM
				} else if (listFrt != null) {
					for (VendInvFrtLinItmVO vendFrt : listFrt) {
						edcSthFrt = importInvoiceData.getEdcSthFrt(vendFrt.getVendTrkgId());
						vendAsn = importInvoiceData.getQtyFromAsn(vendFrt.getVendTrkgId());
						float sumCost;
						if (edcSthFrt != null) {
							if (importInvoiceData.matchFrtLinItm(vendFrt.getVendPoShpCstAmt(),
									edcSthFrt.getEST_SHPNG_CST_AMT())) {
								importInvoiceData.updateStatusFrtEdc(Constants.KEY_CLSD, Constants.KEY_MATCH,
										vendFrt.getVendTrkgId(), vendHdr.getVendInvNbr());
							} else {
								checkListPo = false;
								importInvoiceData.updateStatusFrtEdc(Constants.KEY_READY, Constants.KEY_MISMT,
										vendFrt.getVendTrkgId(), vendHdr.getVendInvNbr());
							}
						} else if (vendAsn != null) {
							sumCost = 0;
							for (VendAsnLinItmShpd itemAsn : vendAsn) {
								hebPoLinItm = importInvoiceData.getListHEBPoLinItmByOrdHdrIdAndProdScnCd(
										itemAsn.getOrdDhrId(), itemAsn.getProdScnCd());
								sumCost += Float.parseFloat(hebPoLinItm.getEstShpngCstAmt());
							}
							if (importInvoiceData.matchFrtLinItmAsn(Float.toString(sumCost),
									vendFrt.getVendPoShpCstAmt())) {
								importInvoiceData.updateStatusFrtAndAsnByTrkgId(Constants.KEY_MATCH, Constants.KEY_CLSD,
										vendFrt.getVendTrkgId());
							} else {
								checkListPo = false;
								importInvoiceData.updateStatusFrtAndAsnByTrkgId(Constants.KEY_MISMT,
										Constants.KEY_READY, vendFrt.getVendTrkgId());
							}

						} else
							checkListPo = false;
					}
				} else
				checkListPo = false;

				if (checkListPo == true) {
					importInvoiceData.updateStatusHdr(Constants.KEY_MATCH, vendHdr.getVendInvNbr());
				} else {
					importInvoiceData.updateStatusHdr(Constants.KEY_MISMT, vendHdr.getVendInvNbr());
				}
			}
		}
	}
}