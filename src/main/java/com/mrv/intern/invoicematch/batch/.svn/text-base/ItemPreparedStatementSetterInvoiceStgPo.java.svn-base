package com.mrv.intern.invoicematch.batch;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Locale;

import javax.naming.spi.DirStateFactory.Result;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import com.mrv.intern.invoicematch.model.StgVendInvPoVO;
import com.mrv.intern.invoicematch.utils.Constants;
import com.mrv.intern.invoicematch.utils.Helper;

import oracle.net.aso.p;

public class ItemPreparedStatementSetterInvoiceStgPo implements ItemPreparedStatementSetter<StgVendInvPoVO> {
	/**
	 * set value StgVendInvPoVO
	 * @return void
	 * @author Xuan Vu
	 * 
	 */
	public void setValues(StgVendInvPoVO result, PreparedStatement ps) throws SQLException {
		// TODO Auto-generated method stub ordHdrHd,vendInvNbr,invTs,ordTs,vendPoShpCstAmt
		ps.setString(1, result.getOrdHdrHd());
		ps.setString(2, result.getVendInvNbr());
		ps.setTimestamp(3, Helper.parseStringToTimeStamp(result.getInvTs(),Constants.TIME_DEFINE, Locale.US));
		ps.setTimestamp(4, Helper.parseStringToTimeStamp(result.getOrdTs(),Constants.TIME_DEFINE, Locale.US));
		BigDecimal amt= new BigDecimal(result.getVendPoShpCstAmt());
		amt=amt.setScale(4, RoundingMode.HALF_UP);
		ps.setBigDecimal(5,amt);
	}
}	
