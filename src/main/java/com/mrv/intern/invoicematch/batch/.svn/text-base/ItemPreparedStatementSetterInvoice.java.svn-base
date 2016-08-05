package com.mrv.intern.invoicematch.batch;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import com.mrv.intern.invoicematch.model.StgVendInvHdrVO;
import com.mrv.intern.invoicematch.utils.Constants;
import com.mrv.intern.invoicematch.utils.Helper;



public class ItemPreparedStatementSetterInvoice implements ItemPreparedStatementSetter<StgVendInvHdrVO> {
	/**
	 * set value StgVendInvHdrVO
	 * @return void
	 * @author Xuan Vu
	 * 
	 */
    public void setValues(StgVendInvHdrVO result, PreparedStatement ps) throws SQLException {

    	ps.setString(1, result.getVendInvNbr());
    	ps.setTimestamp(2, Helper.parseStringToTimeStamp(result.getInvTs(),Constants.TIME_DEFINE, Locale.US));
    	ps.setTimestamp(3, Helper.parseStringToTimeStamp(result.getInvRecdTs(),Constants.TIME_DEFINE, Locale.US));
    	ps.setString(4, result.getInvRecdUsrId());
    	ps.setBigDecimal(5, new BigDecimal(result.getInvAmt()));
    	ps.setString(6, result.getDunsId());
    	ps.setString(7, result.getTradePrtnrId());
    	ps.setTimestamp(8, Helper.parseStringToTimeStamp(result.getHebSchPymtDt(),Constants.TIME_DEFINE, Locale.US));
    	ps.setString(9, result.getProcStatCd());
    	ps.setString(10, result.getVendId());
    }
    
}