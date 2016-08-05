package com.mrv.intern.invoicematch.model;

import java.sql.Timestamp;

public class ReportStgVendInvPoVO {
	private String  ordHdrHd;
	private String  vendInvNbr;
	private Timestamp  invTs;
	private Timestamp  ordTs;
	private int  vendPoShpCstAmt;
	public String getOrdHdrHd() {
		return ordHdrHd;
	}
	public void setOrdHdrHd(String ordHdrHd) {
		this.ordHdrHd = ordHdrHd;
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
	public Timestamp getOrdTs() {
		return ordTs;
	}
	public void setOrdTs(Timestamp ordTs) {
		this.ordTs = ordTs;
	}
	public int getVendPoShpCstAmt() {
		return vendPoShpCstAmt;
	}
	public void setVendPoShpCstAmt(int vendPoShpCstAmt) {
		this.vendPoShpCstAmt = vendPoShpCstAmt;
	}
	public ReportStgVendInvPoVO(String ordHdrHd, String vendInvNbr, Timestamp invTs, Timestamp ordTs,
			int vendPoShpCstAmt) {
		super();
		this.ordHdrHd = ordHdrHd;
		this.vendInvNbr = vendInvNbr;
		this.invTs = invTs;
		this.ordTs = ordTs;
		this.vendPoShpCstAmt = vendPoShpCstAmt;
	}

	
	
}
