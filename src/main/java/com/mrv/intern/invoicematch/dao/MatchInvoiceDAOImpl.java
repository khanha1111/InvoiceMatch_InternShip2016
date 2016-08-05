package com.mrv.intern.invoicematch.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;


import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mrv.intern.invoicematch.model.HEBPoVO;
import com.mrv.intern.invoicematch.model.EdcSthFrt;
import com.mrv.intern.invoicematch.model.HEBPoLinItmVO;

import com.mrv.intern.invoicematch.model.VendAsnLinItmShpd;
import com.mrv.intern.invoicematch.model.VendInvFrtLinItmVO;
import com.mrv.intern.invoicematch.model.VendInvHdrVO;
import com.mrv.intern.invoicematch.model.VendInvPoLinItmVO;
import com.mrv.intern.invoicematch.model.VendInvPoVO;
import com.mrv.intern.invoicematch.utils.Constants;

@Repository
public class MatchInvoiceDAOImpl extends BaseDAOImpl implements MatchInvoiceDAO {
	/**
	  * get vendType 
	  * @return type
	  * @author Khanh Tran
	  * 
	  */
	@Override
	public String getInvoiceTypeByVendorId(String vendId) {
		String sql =Constants.KEY_selectHDRVO;
		String type = getJdbcTemplate().queryForObject(sql, new Object[] { vendId }, String.class);
		return type;

	}
	/**
	  * get List Po 
	  * @return listVendInvPo
	  * @author Khanh Tran
	  * 
	  */
	@Override
	public List<VendInvPoVO> getListOrderByInvoiceId(String invId) {
		System.out.println("ID:"+invId);
		String sql =Constants.KEY_selectPoVo;
		Object[] agrs = new Object[] { invId };
		List<VendInvPoVO> listVendInvPoVO = getJdbcTemplate().query(sql, agrs, new RowMapper<VendInvPoVO>() {

			@Override
			public VendInvPoVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				VendInvPoVO vendinvPoVO = new VendInvPoVO();
				vendinvPoVO.setOrdHdrId(rs.getString("ORD_HDR_ID"));
				vendinvPoVO.setVendOrdHdrId(rs.getString("ORD_HDR_ID"));
				vendinvPoVO.setVendInvNbr(rs.getString("VEND_INV_NBR"));
				vendinvPoVO.setVendID(rs.getString("VEND_ID"));
				return vendinvPoVO;
			}

		});
		return listVendInvPoVO;
	}
	/**
	  * get listPoItm 
	  * @return listvendInvPoLinItmVO
	  * @author Khanh Tran
	  * 
	  */
	@Override
	public List<VendInvPoLinItmVO> getListItemInOrder(String invId, String ordId) {
		String sql = Constants.KEY_selectPoVoItm;
		Object[] agrs = new Object[] {ordId,invId};
		List<VendInvPoLinItmVO> listvendInvPoLinItmVO = getJdbcTemplate().query(sql, agrs,
				new RowMapper<VendInvPoLinItmVO>() {

					@Override
					public VendInvPoLinItmVO mapRow(ResultSet rs, int rowNum) throws SQLException {
						VendInvPoLinItmVO vendPo = new VendInvPoLinItmVO();
						vendPo.setVendId(rs.getString("VEND_ID"));
						vendPo.setVendOrdHdrId(rs.getString("ORD_HDR_ID"));
						vendPo.setVendInvNbr(rs.getString("VEND_INV_NBR"));
						vendPo.setVendLinItmQty(rs.getString("VEND_LIN_ITM_QTY"));
						vendPo.setProdScnCd(rs.getString("VEND_PROD_SCN_CD"));
						vendPo.setVendLinItmAmt(rs.getString("VEND_LIN_ITM_AMT"));
						

						return vendPo;
					}
				});

				
		return listvendInvPoLinItmVO;
	}
	/**
	  * get listFrtItm
	  * @return listFrt
	  * @author Khanh Tran
	  * 
	  */
	@Override
	public List<VendInvFrtLinItmVO> getListFrtItemByInvoiceId(String invId) {
		String sql =Constants.Key_selectFRTItm;
		Object[] agrs = new Object[] { invId };
		List<VendInvFrtLinItmVO> listFrt = getJdbcTemplate().query(sql, agrs, new RowMapper<VendInvFrtLinItmVO>() {

			@Override
			public VendInvFrtLinItmVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				VendInvFrtLinItmVO vendInvFrtLinItmVO = new VendInvFrtLinItmVO();
				vendInvFrtLinItmVO.setVendPoShpCstAmt(rs.getString("VEND_PO_SHP_CST_AMT"));
				vendInvFrtLinItmVO.setVendInvNbr(rs.getString("VEND_INV_NBR"));
				vendInvFrtLinItmVO.setVendTrkgId(rs.getString("VEND_TRKG_ID"));
				vendInvFrtLinItmVO.setFrtPoNbr(rs.getString("FRT_PO_NBR"));
				vendInvFrtLinItmVO.setVendId(rs.getString("VEND_ID"));
		

				return vendInvFrtLinItmVO;
			}

		});

		return listFrt;
	}
//	THE FUNCTIONS TO GET VALUE FROM DATABASE FOR MATCHING BY XUAN VU PHAM
	@Override
	public List<VendInvPoVO> getListVendInvPoByVendInvNbr(String vendInvNbr) {
		String sql = Constants.KEY_getListVendInvPoByVendInvNbr_SQL;
		Object[] agrs = new Object[] { vendInvNbr };
		List<VendInvPoVO> listVendInvPoVO = getJdbcTemplate().query(sql, agrs, new RowMapper<VendInvPoVO>() {

			@Override
			public VendInvPoVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				VendInvPoVO vendinvPoVO = new VendInvPoVO();
				vendinvPoVO.setVendID(rs.getString("VEND_ID"));
				vendinvPoVO.setMatTypCd(rs.getString("MAT_TYP_CD"));
				vendinvPoVO.setOrdHdrId(rs.getString("ORD_HDR_ID"));
				vendinvPoVO.setVendInvNbr(rs.getString("VEND_INV_NBR"));
				vendinvPoVO.setVendID(rs.getString("VEND_ID"));
				vendinvPoVO.setVendOrdHdrId(rs.getString("VEND_ORD_HDR_ID"));
				return vendinvPoVO;
			}

		});
		return listVendInvPoVO;
	}

	@Override
	public List<VendInvFrtLinItmVO> getListVendInvFrtLinItmByVendInvNbr(String vendInvNbr) {
		String sql = Constants.KEY_getListVendInvFrtLinItmByVendInvNbr_SQL;
		Object[] agrs = new Object[] { vendInvNbr };
		List<VendInvFrtLinItmVO> listFrt = getJdbcTemplate().query(sql, agrs, new RowMapper<VendInvFrtLinItmVO>() {

			@Override
			public VendInvFrtLinItmVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				VendInvFrtLinItmVO vendInvFrtLinItmVO = new VendInvFrtLinItmVO();
				vendInvFrtLinItmVO.setVendId(rs.getString("VEND_ID"));
				vendInvFrtLinItmVO.setVendInvNbr(rs.getString("VEND_INV_NBR"));
				vendInvFrtLinItmVO.setVendTrkgId(rs.getString("VEND_TRKG_ID"));
				vendInvFrtLinItmVO.setFrtPoNbr(rs.getString("FRT_PO_NBR"));
				vendInvFrtLinItmVO.setVendPoShpCstAmt(rs.getString("VEND_PO_SHP_CST_AMT"));
				vendInvFrtLinItmVO.setHebTrkgId(rs.getString("HEB_TRKG_ID"));
				vendInvFrtLinItmVO.setHebSgpngCstAmt(rs.getString("HEB_SHPNG_CST_AMT"));
				vendInvFrtLinItmVO.setFnlShpngCstAmt(rs.getString("FNL_SHPNG_CST_AMT"));
				vendInvFrtLinItmVO.setAdjRsnTxt(rs.getString("ADJ_RSN_TXT"));
				vendInvFrtLinItmVO.setLinItmMatStatCd(rs.getString("LIN_ITM_MAT_STAT_CD"));
				return vendInvFrtLinItmVO;
			}

		});

		return listFrt;
	}

	@Override
	public List<VendInvPoLinItmVO> getListVendInvPoLinItmByOrdHdrIdAndVendInvNbr(String ordHdrId, String vendInvNbr) {
		String sql = Constants.KEY_getListVendInvPoLinItmByOrdHdrIdAndVendInvNbr_SQL;
		Object[] agrs = new Object[] { ordHdrId, vendInvNbr };
		List<VendInvPoLinItmVO> listvendInvPoLinItmVO = getJdbcTemplate().query(sql, agrs,
				new RowMapper<VendInvPoLinItmVO>() {

					@Override
					public VendInvPoLinItmVO mapRow(ResultSet rs, int rowNum) throws SQLException {
						VendInvPoLinItmVO vendPo = new VendInvPoLinItmVO();
						vendPo.setVendOrdHdrId(rs.getString("VEND_ORD_HDR_ID"));
						vendPo.setVendProdScnCd(rs.getString("VEND_PROD_SCN_CD"));
						vendPo.setHebOutstQty(rs.getString("HEB_OUTST_QTY"));
						vendPo.setVendLinItmQty(rs.getString("VEND_LIN_ITM_QTY"));
						vendPo.setVendLinItmAmt(rs.getString("VEND_LIN_ITM_AMT"));
						vendPo.setFnlLinItmQty(rs.getString("FNL_LIN_ITM_QTY"));
						vendPo.setFnlLinItmAmt(rs.getString("FNL_LIN_ITM_AMT"));
						vendPo.setLinItmMatStatCd(rs.getString("LIN_ITM_MAT_STAT_CD"));
						return vendPo;
					}
				});
		return listvendInvPoLinItmVO;
	}

	@Override
	public HEBPoVO getListHEBPoByVendId(String vendId) {
		String sql = Constants.KEY_getListHEBPoByVendId_SQL;
		Object[] agrs = new Object[] {vendId};
		return getJdbcTemplate().query(sql, new ResultSetExtractor<HEBPoVO>() {

			@Override
			public HEBPoVO extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					HEBPoVO listHEBPo = new HEBPoVO();
					listHEBPo.setOrdHdrId(rs.getString("ORD_HDR_ID"));
					listHEBPo.setVendId(rs.getString("VEND_ID"));
					listHEBPo.setOrdDt(rs.getString("ORD_DT"));
					listHEBPo.setLinItmCnt(rs.getString("LIN_ITM_CNT"));
					listHEBPo.setOrdAmt(rs.getString("ORD_AMT"));
					listHEBPo.setHebOrdAmt(rs.getString("HEB_ORD_AMT"));
					listHEBPo.setLinItmMatStatCd(rs.getString("LIN_ITM_MAT_STAT_CD"));
					listHEBPo.setVendPoShpCstAmt(rs.getString("VEND_PO_SHP_CST_AMT"));
					return listHEBPo;
				}

				return null;
			}

		});
	}

	@Override
	public HEBPoLinItmVO getListHEBPoLinItmByOrdHdrIdAndProdScnCd(String ordHdrId, String prodScnCd) {
		String sql = Constants.KEY_getListHEBPoLinItmByOrdHdrIdAndProdScnCd_SQL;
		Object[] agrs = new Object[] {ordHdrId, prodScnCd};
		return getJdbcTemplate().query(sql, agrs, new ResultSetExtractor<HEBPoLinItmVO>() {
			@Override
			public HEBPoLinItmVO extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					HEBPoLinItmVO hebItm = new HEBPoLinItmVO();
					hebItm.setOrdHdrId(rs.getString("ORD_HDR_ID"));
					hebItm.setProdScnCd(rs.getString("PROD_SCN_CD"));
					hebItm.setLinItmAmt(rs.getString("LIN_ITM_AMT"));
					hebItm.setLinItmQuy(rs.getString("LIN_ITM_QTY"));
					hebItm.setLinItmMatStatCd(rs.getString("LIN_ITM_MAT_STAT_CD"));
					hebItm.setEstShpngCstAmt(rs.getString("EST_SHPNG_CST_AMT"));
					hebItm.setHebApprQuy(rs.getString("HEB_APPR_QTY"));
					hebItm.setHebDept(rs.getString("HEB_DEPT"));
					hebItm.setHebSubDept(rs.getString("HEB_SUB_DEPT"));
					return hebItm;
				}
				return null;
			}
		});
	}

	@Override
	public Boolean matchLinItm(String vendLinItmQty, String vendLinItmAmt, String hebLintItmQty, String hebLinItmAmt) {
		if("".equals(hebLintItmQty) || "".equals(hebLinItmAmt) || "".equals(vendLinItmQty) || "".equals(vendLinItmAmt)){
			return false;
		}
		else if (vendLinItmQty.equals(hebLintItmQty) && vendLinItmAmt.equals(hebLinItmAmt)) {
			return true;
		} else
			return false;
	}
//	THE FUNCTIONS TO UPDATE NEW STATUS FOR ITEM, PO AND HDR AFTER MATCHING BY XUAN VU PHAM
	@Override
	public void updateStatusItm(String statusForVend, String statusForHeb, String ordDhrId, String ScnCd) {
		String sql = Constants.KEY_updateStatusItm_SQL1;
		Object[] agrs = new Object[] {statusForVend, ordDhrId, ScnCd};
		getJdbcTemplate().update(sql, agrs);
		String sql2 = Constants.KEY_updateStatusItm_SQL2;
		Object[] agrs2 = new Object[] {statusForHeb, ordDhrId, ScnCd};
		getJdbcTemplate().update(sql2, agrs2);
	}

	@Override
	public void updateStatusPo(String statusForVend, String statusForHeb, String vendId, String vendOrdDhrId,String vendInvNbr) {
		String sql = Constants.KEY_updateStatusPo_SQL1;
		Object[] agrs = new Object[] {statusForVend, vendId, vendOrdDhrId, vendInvNbr};
		getJdbcTemplate().update(sql, agrs);
		String sql2 = Constants.KEY_updateStatusPo_SQL2;
		Object[] agrs2 = new Object[] {statusForHeb, vendId, vendOrdDhrId};
		getJdbcTemplate().update(sql2, agrs2);
	}

	@Override
	public void updateStatusHdr(String statusForVend, String vendInvNbr) {
		String sql = Constants.KEY_updateStatusHdr_SQL;
		Object[] agrs = new Object[] {statusForVend, vendInvNbr};
		getJdbcTemplate().update(sql, agrs);
	}
//	THE FUNCTIONS FOR MATCHING EDC FRT BY XUAN VU PHAM
	@Override
	public EdcSthFrt getEdcSthFrt(String trkgId) {
		String sql = Constants.KEY_getEdcSthFrt_SQL;
		Object[] agrs = new Object[] {trkgId};
		return getJdbcTemplate().query(sql, agrs, new ResultSetExtractor<EdcSthFrt>() {
			@Override
			public EdcSthFrt extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					EdcSthFrt hebItm = new EdcSthFrt();
					hebItm.setEST_SHPNG_CST_AMT(rs.getString("EST_SHPNG_CST_AMT"));
					hebItm.setVEND_ID(rs.getString("VEND_ID"));
					hebItm.setTRKG_ID(rs.getString("TRKG_ID"));
					return hebItm;
				}
				return null;
			}
		});
	}

	@Override
	public Boolean matchFrtLinItm(String edcEstShpgCstAmt, String frtVendPoShpgCstAmt) {
		if("".equals(frtVendPoShpgCstAmt) || "".equals(edcEstShpgCstAmt)){
			return false;
		}
		else if(edcEstShpgCstAmt.equals(frtVendPoShpgCstAmt)){
			return true;
		}
		else return false;
	}

	@Override
	public void updateStatusFrtEdc(String statusEdc, String statusFrt, String vendTrkgId,String vendInvNbr) {
		String sql = Constants.KEY_updateStatusFrtEdc_SQL1;
		Object[] agrs = new Object[] {statusFrt, vendTrkgId, vendInvNbr};
		getJdbcTemplate().update(sql, agrs);
		String sql2 = Constants.KEY_updateStatusFrtEdc_SQL2;
		Object[] agrs2 = new Object[] {statusEdc, vendTrkgId};
		getJdbcTemplate().update(sql2, agrs2);
	}
//	THE FUNCTIONS FOR MATCHING ASN FRT BY XUAN VU PHAM
	@Override
	public List<VendAsnLinItmShpd> getQtyFromAsn(String trkgId) {
		String sql = Constants.KEY_getQtyFromAsn_SQL;
		Object[] agrs = new Object[] {trkgId};
		List<VendAsnLinItmShpd> listvendInvPoLinItmVO = getJdbcTemplate().query(sql, agrs,
				new RowMapper<VendAsnLinItmShpd>() {

					@Override
					public VendAsnLinItmShpd mapRow(ResultSet rs, int rowNum) throws SQLException {
						VendAsnLinItmShpd hebItm = new VendAsnLinItmShpd();
						hebItm.setLinItmQty(rs.getString("LIN_ITM_QTY"));
						hebItm.setOrdDhrId(rs.getString("ORD_HDR_ID"));
						hebItm.setProdScnCd(rs.getString("PROD_SCN_CD"));
						return hebItm;
					}
				});
		return listvendInvPoLinItmVO;
	}

	@Override
	public List<HEBPoLinItmVO> getListShpgCostFromHEBPoLinItm(String ordDhrId, String prodScnCd) {
		String sql = Constants.KEY_getListShpgCostFromHEBPoLinItm_SQL;
		Object[] agrs = new Object[] {ordDhrId, prodScnCd};
		List<HEBPoLinItmVO> listvendInvPoLinItmVO = getJdbcTemplate().query(sql, agrs,
				new RowMapper<HEBPoLinItmVO>() {

					@Override
					public HEBPoLinItmVO mapRow(ResultSet rs, int rowNum) throws SQLException {
						HEBPoLinItmVO hebItm = new HEBPoLinItmVO();
						hebItm.setOrdHdrId(rs.getString("ORD_HDR_ID"));
						hebItm.setProdScnCd(rs.getString("PROD_SCN_CD"));
						hebItm.setEstShpngCstAmt(rs.getString("EST_SHPNG_CST_AMT"));
						return hebItm;
					}
				});
		return listvendInvPoLinItmVO;
	}

	@Override
	public Boolean matchFrtLinItmAsn(String EstShpgCstAmt, String frtVendPoShpgCstAmt) {
		if(("".equals(frtVendPoShpgCstAmt)) || ("".equals(EstShpgCstAmt))){
			return false;
		}
		else if(EstShpgCstAmt.equals(frtVendPoShpgCstAmt)){
			return true;
		}
		else return false;
	}

	@Override
	public void updateStatusFrtAndAsnByTrkgId(String statusForFrt, String statusdForAsn,String trkgId) {
		String sql = Constants.KEY_updateStatusFrtAndAsnByTrkgId_SQL1;
		Object[] agrs = new Object[] {statusForFrt, trkgId};
		getJdbcTemplate().update(sql, agrs);
		String sql2 = Constants.KEY_updateStatusFrtAndAsnByTrkgId_SQL2;
		Object[] agrs2 = new Object[] {statusdForAsn, trkgId};
		getJdbcTemplate().update(sql2, agrs2);
	}



}
