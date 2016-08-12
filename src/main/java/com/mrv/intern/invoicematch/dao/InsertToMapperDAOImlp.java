package com.mrv.intern.invoicematch.dao;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;
import com.mrv.intern.invoicematch.model.VendInvFrtLinItmVO;
import com.mrv.intern.invoicematch.model.VendInvHdrVO;
import com.mrv.intern.invoicematch.model.VendInvPoLinItmVO;
import com.mrv.intern.invoicematch.model.VendInvPoVO;
import com.mrv.intern.invoicematch.utils.Constants;
@Repository
public class InsertToMapperDAOImlp  extends BaseDAOImpl implements InsertToMapperDAO {
	/**
	  * insertHdrVo
	  * @author Khanh Tran
	  * 
	  */
	@Override
	public void insertHdrVo(VendInvHdrVO venderinvHdr) {
		
			String sql =Constants.KEY_insertHdrVo;

			 getJdbcTemplate().update(sql, new PreparedStatementSetter() {
					
					@Override
					public void setValues(PreparedStatement ps) throws SQLException {
						
						VendInvHdrVO vendInvHdr= venderinvHdr;
						System.out.println("Chek HDR:"+vendInvHdr.getVendId());
						ps.setBigDecimal(1, new BigDecimal(vendInvHdr.getInvAmt()));
						ps.setLong(2, new Long(vendInvHdr.getVendId()));

						ps.setString(3, vendInvHdr.getVendInvNbr());
						ps.setString(4, vendInvHdr.getInvTypCd());
					}
				});
				
		}
	/**
	  * insertPoVo
	  * @author Khanh Tran
	  * 
	  */	
	@Override
	public void insertPoVo(List<VendInvPoVO> invPoVOs) {
		System.out.println("CHECK DATA: "+invPoVOs.size());
		
		String sql = Constants.KEY_insertPoVo;
		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				
				VendInvPoVO result = invPoVOs.get(i);
					ps.setLong(1, new Long(result.getVendID()));
					ps.setString(2, result.getVendInvNbr());
					ps.setString(3, result.getVendOrdHdrId());
					ps.setString(4, result.getOrdHdrId());
					
			}
			
			@Override
			public int getBatchSize() {
				
				return invPoVOs.size();
			}
		});
		
	}
	/**
	  * insertPoItm
	  * @author Khanh Tran
	  * 
	  */
	@Override
	public void insertPoItmVo(List<VendInvPoLinItmVO> invPoLinItmVOs) {

		String sql =Constants.KEY_insertPoItmVo;
		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {

				
				VendInvPoLinItmVO result = invPoLinItmVOs.get(i);
				System.out.println("Get Vend PO Itm:"+result.getVendId());
				ps.setBigDecimal(1, new BigDecimal(result.getVendLinItmAmt()));
				ps.setLong(2, new Long(result.getVendId()));
				ps.setString(3, result.getVendInvNbr());
				ps.setString(4, result.getVendOrdHdrId());
				ps.setString(5, result.getProdScnCd());
				ps.setBigDecimal(6, new BigDecimal(result.getVendLinItmQty()));
	
			}
			
			@Override
			public int getBatchSize() {
				
				return invPoLinItmVOs.size();
			}
		});
		
		
	}
	/**
	  * insertFrtItm
	  * @author Khanh Tran
	  * 
	  */
	@Override
	public void insertFrtItmPo(List<VendInvFrtLinItmVO> invFrtLinItmVOs) {
	
		String sql =Constants.KEY_insertFrtItmVo;
		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				
				VendInvFrtLinItmVO result = invFrtLinItmVOs.get(i);
				ps.setBigDecimal(1, new BigDecimal(result.getVendPoShpCstAmt()));
				ps.setLong(2, new Long(result.getVendId()));
				ps.setString(3, result.getVendInvNbr());
				ps.setString(4, result.getVendTrkgId());
			}
			
			@Override
			public int getBatchSize() {
				
				return invFrtLinItmVOs.size();
			}
		});
		
	}
	
}
