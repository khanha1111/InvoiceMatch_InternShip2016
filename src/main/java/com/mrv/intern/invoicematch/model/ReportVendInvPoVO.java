package com.mrv.intern.invoicematch.model;

import java.sql.Timestamp;

public class ReportVendInvPoVO {
	private int vendId;
	private String vendInvNbr;
	private String vendOrdHdr;
	private String ordHdrId;
	private String matTypId;
	private String cre8Uid;
	private Timestamp cre8Ts;
	private String lstUpdtUid;
	private Timestamp lstUpdtTs;
	
	
	
	public ReportVendInvPoVO(int vendId, String vendInvNbr, String vendOrdHdr, String ordHdrId, String matTypId,
			String cre8Uid, Timestamp cre8Ts, String lstUpdtUid, Timestamp lstUpdtTs) {
		super();
		this.vendId = vendId;
		this.vendInvNbr = vendInvNbr;
		this.vendOrdHdr = vendOrdHdr;
		this.ordHdrId = ordHdrId;
		this.matTypId = matTypId;
		this.cre8Uid = cre8Uid;
		this.cre8Ts = cre8Ts;
		this.lstUpdtUid = lstUpdtUid;
		this.lstUpdtTs = lstUpdtTs;
	}
	public int getVendId() {
		return vendId;
	}
	public void setVendId(int vendId) {
		this.vendId = vendId;
	}
	public String getVendInvNbr() {
		return vendInvNbr;
	}
	public void setVendInvNbr(String vendInvNbr) {
		this.vendInvNbr = vendInvNbr;
	}
	public String getVendOrdHdr() {
		return vendOrdHdr;
	}
	public void setVendOrdHdr(String vendOrdHdr) {
		this.vendOrdHdr = vendOrdHdr;
	}
	public String getOrdHdrId() {
		return ordHdrId;
	}
	public void setOrdHdrId(String ordHdrId) {
		this.ordHdrId = ordHdrId;
	}
	public String getMatTypId() {
		return matTypId;
	}
	public void setMatTypId(String matTypId) {
		this.matTypId = matTypId;
	}
	public String getCre8Uid() {
		return cre8Uid;
	}
	public void setCre8Uid(String cre8Uid) {
		this.cre8Uid = cre8Uid;
	}
	public Timestamp getCre8Ts() {
		return cre8Ts;
	}
	public void setCre8Ts(Timestamp cre8Ts) {
		this.cre8Ts = cre8Ts;
	}
	public String getLstUpdtUid() {
		return lstUpdtUid;
	}
	public void setLstUpdtUid(String lstUpdtUid) {
		this.lstUpdtUid = lstUpdtUid;
	}
	public Timestamp getLstUpdtTs() {
		return lstUpdtTs;
	}
	public void setLstUpdtTs(Timestamp lstUpdtTs) {
		this.lstUpdtTs = lstUpdtTs;
	}
	
	
	

}
