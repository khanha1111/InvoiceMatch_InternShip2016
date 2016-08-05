package com.mrv.intern.invoicematch.batch;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Locale;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import com.mrv.intern.invoicematch.model.StgVendInvPoVO;
import com.mrv.intern.invoicematch.utils.Helper;

public class ItemPreparedStatementSetterInvoiceIsVendInvPo implements ItemPreparedStatementSetter<StgVendInvPoVO> {
	/**
	 * set value StgVendInvPoVO
	 * @return void
	 * @author Xuan Vu
	 * 
	 */
	public void setValues(StgVendInvPoVO result, PreparedStatement ps) throws SQLException {
		// TODO Auto-generated method stub ordHdrHd,vendInvNbr,invTs,ordTs,vendPoShpCstAmt
		ps.setString(1, result.getOrdHdrHd());
	}
}
