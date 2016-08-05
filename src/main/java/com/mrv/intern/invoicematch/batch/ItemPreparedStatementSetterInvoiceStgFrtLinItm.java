package com.mrv.intern.invoicematch.batch;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Locale;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import com.mrv.intern.invoicematch.model.StgVendInvFrtLinItmVO;
import com.mrv.intern.invoicematch.model.StgVendInvPoLinItmVO;
import com.mrv.intern.invoicematch.utils.Constants;
import com.mrv.intern.invoicematch.utils.Helper;

public class ItemPreparedStatementSetterInvoiceStgFrtLinItm implements ItemPreparedStatementSetter<StgVendInvFrtLinItmVO> {
	/**
	 * set value StgVendInvFrtLinItmVO
	 * @return void
	 * @author Xuan Vu
	 * 
	 */
	public void setValues(StgVendInvFrtLinItmVO result, PreparedStatement ps) throws SQLException {
//		vendInvNbr,vendTrkgId,invTs,frtPoNbr,vendPoShpCstAmt
		ps.setString(1, result.getVendInvNbr());
		ps.setString(2, result.getVendTrkgId());
		ps.setTimestamp(3, Helper.parseStringToTimeStamp(result.getInvTs(),Constants.TIME_DEFINE, Locale.US));
		ps.setString(4, result.getFrtPoNbr());
		ps.setBigDecimal(5, new BigDecimal(result.getVendPoShpCstAmt()));
		
	}
}
