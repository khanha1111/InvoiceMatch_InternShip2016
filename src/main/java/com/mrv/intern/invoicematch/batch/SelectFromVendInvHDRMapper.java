package com.mrv.intern.invoicematch.batch;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mrv.intern.invoicematch.model.VendInvHdrVO;
import com.mrv.intern.invoicematch.utils.Helper;

public class SelectFromVendInvHDRMapper implements RowMapper<VendInvHdrVO> {
//	public static VendInvHdrVO frtItm = new VendInvHdrVO();
	@Override
	public VendInvHdrVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		 VendInvHdrVO frtItm = new VendInvHdrVO();
		frtItm.setInvAmt(Helper.trim(rs.getString("INV_AMT")));
		frtItm.setInvTs(Helper.trim(rs.getString("INV_TS")));
		frtItm.setHebMatInvAmt((Helper.trim(rs.getString("HEB_MAT_INV_AMT"))).toString());
		frtItm.setLinItmCnt(Helper.trim(rs.getString("LIN_ITM_CNT")));
		frtItm.setInvTypCd(Helper.trim(rs.getString("INV_TYP_CD")));
		frtItm.setVendInvNbr(Helper.trim(rs.getString("VEND_INV_NBR")));
		frtItm.setVendId(Helper.trim(rs.getString("VEND_ID")));
//		getDataVendHdr.getDataVendHdr(frtItm);
		return frtItm;
	}
}
