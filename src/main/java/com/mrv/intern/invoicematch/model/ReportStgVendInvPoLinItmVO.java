package com.mrv.intern.invoicematch.model;

import java.sql.Timestamp;

public class ReportStgVendInvPoLinItmVO {
	private String vendProdScnCd;
	private String ordHdrId;
	private String vendInvNbr;
	private Timestamp invTs;
	private int  vendLinItmQty;
	private int vendLinItmAmt;
	private int venLiShpCstAtm;
	public ReportStgVendInvPoLinItmVO(String vendProdScnCd, String ordHdrId, String vendInvNbr, Timestamp invTs,
			int vendLinItmQty, int vendLinItmAmt, int venLiShpCstAtm) {
		super();
		this.vendProdScnCd = vendProdScnCd;
		this.ordHdrId = ordHdrId;
		this.vendInvNbr = vendInvNbr;
		this.invTs = invTs;
		this.vendLinItmQty = vendLinItmQty;
		this.vendLinItmAmt = vendLinItmAmt;
		this.venLiShpCstAtm = venLiShpCstAtm;
	}
	public String getVendProdScnCd() {
		return vendProdScnCd;
	}
	public void setVendProdScnCd(String vendProdScnCd) {
		this.vendProdScnCd = vendProdScnCd;
	}
	public String getOrdHdrId() {
		return ordHdrId;
	}
	public void setOrdHdrId(String ordHdrId) {
		this.ordHdrId = ordHdrId;
	}
	public String getVendInvNbr() {
		return vendInvNbr;
	}
	public void setVendInvNbr(String vendInvNbr) {
		this.vendInvNbr = vendInvNbr;
	}
	public Timestamp getInvTs() {
		return invTs;
	}
	public void setInvTs(Timestamp invTs) {
		this.invTs = invTs;
	}
	public int getVendLinItmQty() {
		return vendLinItmQty;
	}
	public void setVendLinItmQty(int vendLinItmQty) {
		this.vendLinItmQty = vendLinItmQty;
	}
	public int getVendLinItmAmt() {
		return vendLinItmAmt;
	}
	public void setVendLinItmAmt(int vendLinItmAmt) {
		this.vendLinItmAmt = vendLinItmAmt;
	}
	public int getVenLiShpCstAtm() {
		return venLiShpCstAtm;
	}
	public void setVenLiShpCstAtm(int venLiShpCstAtm) {
		this.venLiShpCstAtm = venLiShpCstAtm;
	}

	
	

}
