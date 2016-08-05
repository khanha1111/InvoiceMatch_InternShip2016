package com.mrv.intern.invoicematch.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mrv.intern.invoicematch.model.ReportInvStat;
import com.mrv.intern.invoicematch.model.ReportVendInvHdrVO;
import com.mrv.intern.invoicematch.model.ReportVendInvPoVO;
import com.mrv.intern.invoicematch.utils.Constants;
import com.sun.org.apache.regexp.internal.recompile;

import oracle.net.aso.i;

@Repository
public class InvoiceDAOIplm implements InvoiceDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(@Qualifier("dataSource") DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	

	/**
	  * get All Invoice
	  * @return List
	  * @author Phuoc Nguyen
	  * 
	  */
	@Override
	public List<ReportVendInvHdrVO> getAllInvoice() {
		String sql = Constants.SQL_SELECT_HEADER;
		List<ReportVendInvHdrVO> listReportInvoiceMatch = jdbcTemplate.query(sql, new RowMapper<ReportVendInvHdrVO>() {

			@Override
			public ReportVendInvHdrVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				ReportVendInvHdrVO reportInvoice = new ReportVendInvHdrVO();

				reportInvoice.setVendId(rs.getInt("VEND_ID"));
				reportInvoice.setVendInvNbr(rs.getString("VEND_INV_NBR"));
				reportInvoice.setInvTs(rs.getTimestamp("INV_TS"));
				reportInvoice.setInvTypCd(rs.getString("INV_TYP_CD"));
				reportInvoice.setInvRecdTs(rs.getTimestamp("INV_RECD_TS"));
				reportInvoice.setInvRecdUsrId(rs.getString("INV_RECD_USR_ID"));
				reportInvoice.setInvApprTs(rs.getTimestamp("INV_APPR_TS"));
				reportInvoice.setInvApprUsrId(rs.getString("INV_APPR_USR_ID"));
				reportInvoice.setLstUpdtTs(rs.getTimestamp("LST_UPDT_TS"));
				reportInvoice.setLstUpdtUnid(rs.getString("LST_UPDT_UID"));
				reportInvoice.setInvStatCd(rs.getString("INV_STAT_CD"));
				reportInvoice.setInvExcpTypCd(rs.getString("INV_EXCP_TYP_CD"));
				reportInvoice.setInvAmt(rs.getDouble("INV_AMT"));
				reportInvoice.setApPostTs(rs.getTimestamp("AP_POST_TS"));
				reportInvoice.setLocNbr(rs.getInt("LOC_NBR"));
				reportInvoice.setLocTypCd(rs.getString("LOC_TYP_CD").trim());
				reportInvoice.setLinItmCnt(rs.getInt("LIN_ITM_CNT"));
				reportInvoice.setInvSrcCd(rs.getString("INV_SRC_CD"));
				reportInvoice.setManCre8Ts(rs.getTimestamp("MAN_CRE8_TS"));
				reportInvoice.setApBusUntDes(rs.getString("AP_BUS_UNT_DES"));
				reportInvoice.setHebSchPymtDt(rs.getString("HEB_SCH_PYMT_DT"));
				reportInvoice.setBdmCd(rs.getString("BDM_CD"));
				reportInvoice.setHebMatInvAmt(rs.getInt("HEB_MAT_INV_AMT"));
				reportInvoice.setCre8Uid(rs.getString("CRE8_UID"));
				reportInvoice.setCre8Ts(rs.getTimestamp("CRE8_TS"));
				reportInvoice.setManCre8RsnTxt(rs.getString("MAN_CRE8D_RSN_TXT"));
				reportInvoice.setPostToXnetSw(rs.getString("POST_TO_XNET_SW"));
				reportInvoice.setRuleSw(rs.getString("RULE_SW"));
				reportInvoice.setBiPostTs(rs.getTimestamp("BI_POST_TS"));
				reportInvoice.setGlPostTs(rs.getTimestamp("GL_POST_TS"));
				reportInvoice.setRcgpPostTs(rs.getTimestamp("RCGP_POST_TS"));

				return reportInvoice;
			}

		});

		return listReportInvoiceMatch;
	}
	
	

	/**
	  * get Invoice Status
	  * @return List
	  * @author Phuoc Nguyen
	  * 
	  */
	@Override
	public List<ReportInvStat> getInvStat() {
		String sql = "SELECT * FROM INTERNSHIP.INV_STAT";
		List<ReportInvStat> lisstInvStat = jdbcTemplate.query(sql, new RowMapper<ReportInvStat>() {
			
			@Override
			public ReportInvStat mapRow(ResultSet rs, int rowNum) throws SQLException {
				ReportInvStat listInvStatMapRow = new ReportInvStat();

				listInvStatMapRow.setInvStatId(rs.getString("INV_STAT_CD"));
				listInvStatMapRow.setInvStatDes(rs.getString("INV_STAT_DES"));

				return listInvStatMapRow;
			}

		});
		return lisstInvStat;
	}
	

	/**
	  * Search Report 
	  * @return List
	  * @author Phuoc Nguyen
	  * 
	  */

	@Override
	public List<ReportVendInvHdrVO> searchInvoice(String dayStart, String dayEnd, String invStat) {
		String sql = "";
		Object[] args = null;

		if (invStat.equals(Constants.INV_STAT_DEFAULD)) {
			if (dayStart == null) {
				sql = Constants.SQL_SELECT_HEADER + " WHERE INV_TS <=?";
				args = new Object[] { dayEnd };
			} else if (dayEnd == null) {
				sql = Constants.SQL_SELECT_HEADER + " WHERE INV_TS >=?";
				args = new Object[] { dayStart };
			} else {
				sql = Constants.SQL_SELECT_HEADER + " WHERE INV_TS  >=? AND INV_TS <= ?";
				args = new Object[] { dayStart, dayEnd };
			}
		} else {
			if (dayStart == null) {
				if (dayEnd == null) {
					sql = Constants.SQL_SELECT_HEADER + " WHERE INV_STAT_CD =?";
					args = new Object[] { invStat };
				} else {
					sql = Constants.SQL_SELECT_HEADER + " WHERE INV_TS <=? AND INV_STAT_CD =?";
					args = new Object[] { dayEnd, invStat };
				}
			} else if (dayEnd == null) {
				if (dayStart == null) {
					sql = Constants.SQL_SELECT_HEADER + " WHERE INV_STAT_CD =?";
					args = new Object[] { invStat };
				} else {
					sql = Constants.SQL_SELECT_HEADER + " WHERE INV_TS >=? AND INV_STAT_CD =?";
					args = new Object[] { dayStart, invStat };
				}
			} else {
				sql = Constants.SQL_SELECT_HEADER + " WHERE INV_TS >=? AND INV_TS <=? AND INV_STAT_CD =?";
				args = new Object[] { dayStart, dayEnd, invStat };
			}
		}

		List<ReportVendInvHdrVO> listReportInvoiceMatch = jdbcTemplate.query(sql, args,
				new RowMapper<ReportVendInvHdrVO>() {
			
					@Override
					public ReportVendInvHdrVO mapRow(ResultSet rs, int rowNum) throws SQLException {
						ReportVendInvHdrVO reportInvoice = new ReportVendInvHdrVO();

						reportInvoice.setVendId(rs.getInt("VEND_ID"));
						reportInvoice.setVendInvNbr(rs.getString("VEND_INV_NBR"));
						reportInvoice.setInvTs(rs.getTimestamp("INV_TS"));
						reportInvoice.setInvTypCd(rs.getString("INV_TYP_CD"));
						reportInvoice.setInvRecdTs(rs.getTimestamp("INV_RECD_TS"));
						reportInvoice.setInvRecdUsrId(rs.getString("INV_RECD_USR_ID"));
						reportInvoice.setInvApprTs(rs.getTimestamp("INV_APPR_TS"));
						reportInvoice.setInvApprUsrId(rs.getString("INV_APPR_USR_ID"));
						reportInvoice.setLstUpdtTs(rs.getTimestamp("LST_UPDT_TS"));
						reportInvoice.setLstUpdtUnid(rs.getString("LST_UPDT_UID"));
						reportInvoice.setInvStatCd(rs.getString("INV_STAT_CD"));
						reportInvoice.setInvExcpTypCd(rs.getString("INV_EXCP_TYP_CD"));
						reportInvoice.setInvAmt(rs.getDouble("INV_AMT"));
						reportInvoice.setApPostTs(rs.getTimestamp("AP_POST_TS"));
						reportInvoice.setLocNbr(rs.getInt("LOC_NBR"));
						reportInvoice.setLocTypCd(rs.getString("LOC_TYP_CD").trim());
						reportInvoice.setLinItmCnt(rs.getInt("LIN_ITM_CNT"));
						reportInvoice.setInvSrcCd(rs.getString("INV_SRC_CD"));
						reportInvoice.setManCre8Ts(rs.getTimestamp("MAN_CRE8_TS"));
						reportInvoice.setApBusUntDes(rs.getString("AP_BUS_UNT_DES"));
						reportInvoice.setHebSchPymtDt(rs.getString("HEB_SCH_PYMT_DT"));
						reportInvoice.setBdmCd(rs.getString("BDM_CD"));
						reportInvoice.setHebMatInvAmt(rs.getInt("HEB_MAT_INV_AMT"));
						reportInvoice.setCre8Uid(rs.getString("CRE8_UID"));
						reportInvoice.setCre8Ts(rs.getTimestamp("CRE8_TS"));
						reportInvoice.setManCre8RsnTxt(rs.getString("MAN_CRE8D_RSN_TXT"));
						reportInvoice.setPostToXnetSw(rs.getString("POST_TO_XNET_SW"));
						reportInvoice.setRuleSw(rs.getString("RULE_SW"));
						reportInvoice.setBiPostTs(rs.getTimestamp("BI_POST_TS"));
						reportInvoice.setGlPostTs(rs.getTimestamp("GL_POST_TS"));
						reportInvoice.setRcgpPostTs(rs.getTimestamp("RCGP_POST_TS"));

						return reportInvoice;
					}

				});

		return listReportInvoiceMatch;
	}
}
