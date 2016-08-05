package com.mrv.intern.invoicematch.model;

import java.sql.Timestamp;

public class ReportVendInvFrtLinItmVO {
	private int  vendId;
	private String  vendInvNbr;
	private String  vendTrkgId;
	private String  frtPoNbr;
	private int  vendPoShpCstAmt;
	private String  hebTrkgId;
	private int  hebSgpngCstAmt;
	private int  fnlShpngCstAmt;
	private String  adjRsnTxt;
	private String  linItmMatStatCd;
	private String  cre8Uid;
	private Timestamp  cre8Ts;
	private Timestamp  lstUpdtTs;
	private String  lstUpdtUid;
	private String  cstSellSw;
	
	
	
	
	public ReportVendInvFrtLinItmVO(int vendId, String vendInvNbr, String vendTrkgId, String frtPoNbr,
			int vendPoShpCstAmt, String hebTrkgId, int hebSgpngCstAmt, int fnlShpngCstAmt, String adjRsnTxt,
			String linItmMatStatCd, String cre8Uid, Timestamp cre8Ts, Timestamp lstUpdtTs, String lstUpdtUid,
			String cstSellSw) {
		super();
		this.vendId = vendId;
		this.vendInvNbr = vendInvNbr;
		this.vendTrkgId = vendTrkgId;
		this.frtPoNbr = frtPoNbr;
		this.vendPoShpCstAmt = vendPoShpCstAmt;
		this.hebTrkgId = hebTrkgId;
		this.hebSgpngCstAmt = hebSgpngCstAmt;
		this.fnlShpngCstAmt = fnlShpngCstAmt;
		this.adjRsnTxt = adjRsnTxt;
		this.linItmMatStatCd = linItmMatStatCd;
		this.cre8Uid = cre8Uid;
		this.cre8Ts = cre8Ts;
		this.lstUpdtTs = lstUpdtTs;
		this.lstUpdtUid = lstUpdtUid;
		this.cstSellSw = cstSellSw;
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
	public String getVendTrkgId() {
		return vendTrkgId;
	}
	public void setVendTrkgId(String vendTrkgId) {
		this.vendTrkgId = vendTrkgId;
	}
	public String getFrtPoNbr() {
		return frtPoNbr;
	}
	public void setFrtPoNbr(String frtPoNbr) {
		this.frtPoNbr = frtPoNbr;
	}
	public int getVendPoShpCstAmt() {
		return vendPoShpCstAmt;
	}
	public void setVendPoShpCstAmt(int vendPoShpCstAmt) {
		this.vendPoShpCstAmt = vendPoShpCstAmt;
	}
	public String getHebTrkgId() {
		return hebTrkgId;
	}
	public void setHebTrkgId(String hebTrkgId) {
		this.hebTrkgId = hebTrkgId;
	}
	public int getHebSgpngCstAmt() {
		return hebSgpngCstAmt;
	}
	public void setHebSgpngCstAmt(int hebSgpngCstAmt) {
		this.hebSgpngCstAmt = hebSgpngCstAmt;
	}
	public int getFnlShpngCstAmt() {
		return fnlShpngCstAmt;
	}
	public void setFnlShpngCstAmt(int fnlShpngCstAmt) {
		this.fnlShpngCstAmt = fnlShpngCstAmt;
	}
	public String getAdjRsnTxt() {
		return adjRsnTxt;
	}
	public void setAdjRsnTxt(String adjRsnTxt) {
		this.adjRsnTxt = adjRsnTxt;
	}
	public String getLinItmMatStatCd() {
		return linItmMatStatCd;
	}
	public void setLinItmMatStatCd(String linItmMatStatCd) {
		this.linItmMatStatCd = linItmMatStatCd;
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
	public Timestamp getLstUpdtTs() {
		return lstUpdtTs;
	}
	public void setLstUpdtTs(Timestamp lstUpdtTs) {
		this.lstUpdtTs = lstUpdtTs;
	}
	public String getLstUpdtUid() {
		return lstUpdtUid;
	}
	public void setLstUpdtUid(String lstUpdtUid) {
		this.lstUpdtUid = lstUpdtUid;
	}
	public String getCstSellSw() {
		return cstSellSw;
	}
	public void setCstSellSw(String cstSellSw) {
		this.cstSellSw = cstSellSw;
	}
	
	
		
	
}
