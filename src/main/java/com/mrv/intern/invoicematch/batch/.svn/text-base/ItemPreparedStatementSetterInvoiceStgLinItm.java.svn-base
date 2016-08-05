package com.mrv.intern.invoicematch.batch;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Locale;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import com.mrv.intern.invoicematch.model.StgVendInvPoLinItmVO;
import com.mrv.intern.invoicematch.model.StgVendInvPoVO;
import com.mrv.intern.invoicematch.utils.Constants;
import com.mrv.intern.invoicematch.utils.Helper;

public class ItemPreparedStatementSetterInvoiceStgLinItm implements ItemPreparedStatementSetter<StgVendInvPoLinItmVO> {
	/**
	 * set value StgVendInvPoLinItmVO
	 * @return void
	 * @author Xuan Vu
	 * 
	 */
	public void setValues(StgVendInvPoLinItmVO result, PreparedStatement ps) throws SQLException {
//		vendProdScnCd,ordHdrId,vendInvNbr,invTs,vendLinItmQty,vendLinItmAmt,venLiShpCstAtm
		ps.setString(1, result.getVendProdScnCd());
		ps.setString(2, result.getOrdHdrId());
		ps.setString(3, result.getVendInvNbr());
		ps.setTimestamp(4, Helper.parseStringToTimeStamp(result.getInvTs(),Constants.TIME_DEFINE, Locale.US));
		ps.setBigDecimal(5, new BigDecimal(result.getVendLinItmQty()));
		ps.setBigDecimal(6, new BigDecimal(result.getVendLinItmAmt()));
		ps.setBigDecimal(7, new BigDecimal(result.getVenLiShpCstAtm()));
	}
}
