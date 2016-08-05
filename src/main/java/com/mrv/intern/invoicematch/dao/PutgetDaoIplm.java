//package com.mrv.intern.invoicematch.dao;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Repository;
//
//import com.mrv.intern.invoicematch.model.VendInvPoVO;
//
//@Repository
//public class PutgetDaoIplm implements PutGetDao{
//
//	public List<VendInvPoVO> getListVendInvHdrByVendInvNbr(String invNbr) {
//		JdbcTemplate jdbcTemplate = null;
//
//		// public StudentDAOImlp(DataSource dataSource) {
//		// jdbcTemplate = new JdbcTemplate(dataSource);
//		// }
//		// TODO Auto-generated method stub
////		MAT_TYP_CD,ORD_HDR_ID,VEND_INV_NBR,VEND_ID,VEND_ORD_HDR_ID
//		String sql = "SELECT MAT_TYP_CD,ORD_HDR_ID,VEND_INV_NBR,VEND_ID,VEND_ORD_HDR_ID FROM VEND_INV_PO Where VEND_INV_NBR = ?";
//		Object[] agrs = new Object[] {invNbr};
//		List<VendInvPoVO> listInvPo = jdbcTemplate.query(sql, new RowMapper<VendInvPoVO>() {
//
//			public VendInvPoVO mapRow(ResultSet rs, int rowNum) throws SQLException {
//				VendInvPoVO venInvPo = new VendInvPoVO();
//
////				astudent.setId(rs.getInt("id"));
////				astudent.setName(rs.getString("name"));
////				astudent.setSubject(rs.getString("subject"));
////				astudent.setMark(rs.getInt("mark"));
////				astudent.setAge(rs.getInt("age"));
////				astudent.setGender(rs.getString("gender"));
//				venInvPo.setMatTypId(rs.getString("MAT_TYP_CD"));
//				return venInvPo;
//			}
//
//		});
//
//		return listInvPo;
//	}
//
//}
