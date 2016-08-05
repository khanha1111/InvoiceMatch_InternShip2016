package com.mrv.intern.invoicematch.model;

import java.util.List;

public class VendInvHdrVO {
	private String  vendId;
	private String  vendInvNbr;
	private String  invTs;
	private String  invTypCd;
	private String  invRecdTs;
	private String  invRecdUsrId;
	private String  invApprTs;
	private String  invApprUsrId;
	private String  lstUpdtTs;
	private String  lstUpdtUnid;
	private String  invStatCd;
	private String  invExcpTypCd;
	private String  invAmt;
	private String  apPostTs;
	private String  locNbr;
	private String  locTypCd;
	private String  linItmCnt;
	private String  invSrcCd;
	private String  manCre8Ts;
	private String  apBusUntDes;
	private String  hebSchPymtDt;
	private String  bdmCd;
	private String  hebMatInvAmt;
	private String  cre8Uid;
	private String  cre8Ts;
	private String  manCre8RsnTxt;
	private String  postToXnetSw;
	private String  roleSw;
	private String  biPostTs;
	private String  glPostTs;
	private String  rcgpPostTs;
	private List<VendInvPoVO> lstVendInvPoVO;
	private List<VendInvFrtLinItmVO> lstVendInvFrtLinItmVO;
	private List<VendInvHdrVO> hdrVOs;
	
	public List<VendInvHdrVO> getHdrVOs() {
		return hdrVOs;
	}
//	public void setHdrVOs(List<VendInvHdrVO> hdrVOs) {
//		this.hdrVOs = hdrVOs;
//	}
	public List<VendInvFrtLinItmVO> getLstVendInvFrtLinItmVO() {
		return lstVendInvFrtLinItmVO;
	}
	public void setLstVendInvFrtLinItmVO(List<VendInvFrtLinItmVO> lstVendInvFrtLinItmVO) {
		this.lstVendInvFrtLinItmVO = lstVendInvFrtLinItmVO;
	}
	public List<VendInvPoVO> getLstVendInvPoVO() {
		return lstVendInvPoVO;
	}
	public void setLstVendInvPoVO(List<VendInvPoVO> lstVendInvPoVO) {
		this.lstVendInvPoVO = lstVendInvPoVO;
	}
	public String getVendId() {
		return vendId;
	}
	public void setVendId(String vendId) {
		this.vendId = vendId;
	}
	public String getVendInvNbr() {
		return vendInvNbr;
	}
	public void setVendInvNbr(String vendInvNbr) {
		this.vendInvNbr = vendInvNbr;
	}
	public String getInvTs() {
		return invTs;
	}
	public void setInvTs(String invTs) {
		this.invTs = invTs;
	}
	public String getInvTypCd() {
		return invTypCd;
	}
	public void setInvTypCd(String invTypCd) {
		this.invTypCd = invTypCd;
	}
	public String getInvRecdTs() {
		return invRecdTs;
	}
	public void setInvRecdTs(String invRecdTs) {
		this.invRecdTs = invRecdTs;
	}
	public String getInvRecdUsrId() {
		return invRecdUsrId;
	}
	public void setInvRecdUsrId(String invRecdUsrId) {
		this.invRecdUsrId = invRecdUsrId;
	}
	public String getInvApprTs() {
		return invApprTs;
	}
	public void setInvApprTs(String invApprTs) {
		this.invApprTs = invApprTs;
	}
	public String getInvApprUsrId() {
		return invApprUsrId;
	}
	public void setInvApprUsrId(String invApprUsrId) {
		this.invApprUsrId = invApprUsrId;
	}
	public String getLstUpdtTs() {
		return lstUpdtTs;
	}
	public void setLstUpdtTs(String lstUpdtTs) {
		this.lstUpdtTs = lstUpdtTs;
	}
	public String getLstUpdtUnid() {
		return lstUpdtUnid;
	}
	public void setLstUpdtUnid(String lstUpdtUnid) {
		this.lstUpdtUnid = lstUpdtUnid;
	}
	public String getInvStatCd() {
		return invStatCd;
	}
	public void setInvStatCd(String invStatCd) {
		this.invStatCd = invStatCd;
	}
	public String getInvExcpTypCd() {
		return invExcpTypCd;
	}
	public void setInvExcpTypCd(String invExcpTypCd) {
		this.invExcpTypCd = invExcpTypCd;
	}
	public String getInvAmt() {
		return invAmt;
	}
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
	}
	public String getApPostTs() {
		return apPostTs;
	}
	public void setApPostTs(String apPostTs) {
		this.apPostTs = apPostTs;
	}
	public String getLocNbr() {
		return locNbr;
	}
	public void setLocNbr(String locNbr) {
		this.locNbr = locNbr;
	}
	public String getLocTypCd() {
		return locTypCd;
	}
	public void setLocTypCd(String locTypCd) {
		this.locTypCd = locTypCd;
	}
	public String getLinItmCnt() {
		return linItmCnt;
	}
	public void setLinItmCnt(String linItmCnt) {
		this.linItmCnt = linItmCnt;
	}
	public String getInvSrcCd() {
		return invSrcCd;
	}
	public void setInvSrcCd(String invSrcCd) {
		this.invSrcCd = invSrcCd;
	}
	public String getManCre8Ts() {
		return manCre8Ts;
	}
	public void setManCre8Ts(String manCre8Ts) {
		this.manCre8Ts = manCre8Ts;
	}
	public String getApBusUntDes() {
		return apBusUntDes;
	}
	public void setApBusUntDes(String apBusUntDes) {
		this.apBusUntDes = apBusUntDes;
	}
	public String getHebSchPymtDt() {
		return hebSchPymtDt;
	}
	public void setHebSchPymtDt(String hebSchPymtDt) {
		this.hebSchPymtDt = hebSchPymtDt;
	}
	public String getBdmCd() {
		return bdmCd;
	}
	public void setBdmCd(String bdmCd) {
		this.bdmCd = bdmCd;
	}
	public String getHebMatInvAmt() {
		return hebMatInvAmt;
	}
	public void setHebMatInvAmt(String hebMatInvAmt) {
		this.hebMatInvAmt = hebMatInvAmt;
	}
	public String getCre8Uid() {
		return cre8Uid;
	}
	public void setCre8Uid(String cre8Uid) {
		this.cre8Uid = cre8Uid;
	}
	public String getCre8Ts() {
		return cre8Ts;
	}
	public void setCre8Ts(String cre8Ts) {
		this.cre8Ts = cre8Ts;
	}
	public String getManCre8RsnTxt() {
		return manCre8RsnTxt;
	}
	public void setManCre8RsnTxt(String manCre8RsnTxt) {
		this.manCre8RsnTxt = manCre8RsnTxt;
	}
	public String getPostToXnetSw() {
		return postToXnetSw;
	}
	public void setPostToXnetSw(String postToXnetSw) {
		this.postToXnetSw = postToXnetSw;
	}
	public String getRoleSw() {
		return roleSw;
	}
	public void setRoleSw(String roleSw) {
		this.roleSw = roleSw;
	}
	public String getBiPostTs() {
		return biPostTs;
	}
	public void setBiPostTs(String biPostTs) {
		this.biPostTs = biPostTs;
	}
	public String getGlPostTs() {
		return glPostTs;
	}
	public void setGlPostTs(String glPostTs) {
		this.glPostTs = glPostTs;
	}
	public String getRcgpPostTs() {
		return rcgpPostTs;
	}
	public void setRcgpPostTs(String rcgpPostTs) {
		this.rcgpPostTs = rcgpPostTs;
	}
	
}
