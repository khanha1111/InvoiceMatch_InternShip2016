package com.mrv.intern.invoicematch.change_batch;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mrv.intern.invoicematch.model.VendInvFrtLinItmVO;
import com.mrv.intern.invoicematch.model.VendInvHdrVO;
import com.mrv.intern.invoicematch.utils.Helper;

public class HDRLinItmVOMapper implements RowMapper<VendInvHdrVO> {

	@Override
	public VendInvHdrVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		VendInvHdrVO frtItm = new VendInvHdrVO();
		frtItm.setVendInvNbr(Helper.trim(rs.getString("VEND_INV_NBR")));
		frtItm.setInvRecdUsrId(Helper.trim(rs.getString("INV_RECD_USR_ID")));
		frtItm.setInvAmt((Helper.trim(rs.getString("INV_AMT"))).toString());
		frtItm.setHebSchPymtDt(Helper.trim(rs.getString("HEB_SCH_PYMT_DT")));
		

		frtItm.setVendId(Helper.trim(rs.getString("VEND_ID")));
//		frtItm.setInvTypCd(Helper.trim(rs.getString("INV_TYP_CD")));
		return frtItm;
	}

}
