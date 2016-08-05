package com.mrv.intern.invoicematch.dao;
/**
 * @author tuhv
 * select data
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.mrv.intern.invoicematch.model.SearchInvoice;
import com.mrv.intern.invoicematch.utils.Constants;

@Repository
public class SearchInvoiceDAOIplm implements SearchInvoiceDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(@Qualifier("dataSource") DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<SearchInvoice> list() {
		String sql = Constants.SQL_SELECT_INVOICE;
		List<SearchInvoice> listInvoice = jdbcTemplate.query(sql, new RowMapper<SearchInvoice>() {
			@Override
			public SearchInvoice mapRow(ResultSet rs, int rowNum) throws SQLException {
				SearchInvoice invoiceMatch = new SearchInvoice();

				invoiceMatch.setVendorID(rs.getString("VEND_ID"));
				invoiceMatch.setInvoiceID(rs.getString("VEND_INV_NBR"));
				invoiceMatch.setInvoiceType(rs.getString("INV_TYP_CD"));
				invoiceMatch.setInvoiceStatus(rs.getTimestamp("INV_TS"));
				invoiceMatch.setInvoiceAmt(rs.getString("INV_AMT"));

				return invoiceMatch;
			}

		});
		return listInvoice;
	}

	public List<SearchInvoice> searchInvoice(String vendorID, String invoiceID, String trackingID, String orderID) {
		String sql = "";
		Object[] args = null;
		if (vendorID.equals(Constants.VENDOR_DEFAULD)) {
			if (trackingID.equals(Constants.EMPY_STRING) && orderID.equals(Constants.EMPY_STRING)) {
				// invoice
				sql = Constants.SQL_SEARCH_INVOICE;// y
				args = new Object[] { invoiceID, invoiceID };
			} else if (trackingID.equals(Constants.EMPY_STRING) && invoiceID.equals(Constants.EMPY_STRING)) {
				// order
				sql = Constants.SQL_SEARCH_ORDER;// y
				args = new Object[] { orderID };
			} else if (orderID.equals(Constants.EMPY_STRING) && invoiceID.equals(Constants.EMPY_STRING)) {
				// tracking
				sql = Constants.SQL_SEARCH_TRAKING;// y
				args = new Object[] { trackingID };
			} else if (trackingID.equals(Constants.EMPY_STRING)) {
				// invoice order
				sql = Constants.SQL_SEARCH_INVOCE_ORDER;// y
				args = new Object[] { invoiceID, orderID };

			} else if (orderID.equals(Constants.EMPY_STRING)) {
				// tracking invoice
				sql = Constants.SQL_SEARCH_TRACKING_INVOICE;// y
				args = new Object[] { trackingID, invoiceID };

			} else if (invoiceID.equals(Constants.EMPY_STRING)) {
				// tracking order
				sql = Constants.SQL_SEARCH_TRACKING_ORDER;// y
				args = new Object[] { trackingID, orderID, trackingID, orderID };

			} else {
				sql = Constants.SQL_SEARCH_INVOICE_TRACKING_ORDER;// y
				args = new Object[] { trackingID, invoiceID, orderID, trackingID, invoiceID, orderID };
			}
		}
		if (!vendorID.equals(Constants.VENDOR_DEFAULD)) {
			if (invoiceID.equals(Constants.EMPY_STRING) && trackingID.equals(Constants.EMPY_STRING) && orderID.equals(Constants.EMPY_STRING)) {
				// vendor
				sql = Constants.SQL_SEARCH_VENDOR;// y
				args = new Object[] { vendorID, vendorID };
			} else if (invoiceID.equals(Constants.EMPY_STRING) && trackingID.equals(Constants.EMPY_STRING)) {
				// vendor order
				sql = Constants.SQL_SEARCH_VENDOR_ORDER;// y
				args = new Object[] { vendorID, orderID };
			} else if (invoiceID.equals(Constants.EMPY_STRING) && orderID.equals(Constants.EMPY_STRING)) {
				// vendor tracking
				sql = Constants.SQL_SEARCH_VENDOR_TRACKING;// y
				args = new Object[] { trackingID, vendorID };
			} else if (orderID.equals(Constants.EMPY_STRING) && trackingID.equals(Constants.EMPY_STRING)) {
				// vendor invoice
				sql = Constants.SQL_SEARCH_VENDOR_INVOICE;// y
				args = new Object[] { invoiceID, vendorID, invoiceID, vendorID };
			} else if (trackingID.equals(Constants.EMPY_STRING)) {
				// vendor invoice order
				sql = Constants.SQL_SEARCH_VENDOR_INVOICE_ORDER;// y
				args = new Object[] { vendorID, invoiceID, orderID };
			} else if (orderID.equals(Constants.EMPY_STRING)) {
				// tracking vendor invoice
				sql = Constants.SQL_SEARCH_VENDOR_INVOICE_TRACKING;// y
				args = new Object[] { trackingID, vendorID, invoiceID };
			} else if (invoiceID.equals(Constants.EMPY_STRING)) {
				// tracking vendor order
				sql = Constants.SQL_SEARCH_VENDOR_TRACKING_ORDER;// y
				args = new Object[] { trackingID, vendorID, orderID, trackingID, vendorID, orderID };
			} else {
				sql = Constants.SQL_SEARCH_ALL;// y
				args = new Object[] { trackingID, vendorID, invoiceID, orderID, trackingID, vendorID, invoiceID,
						orderID };
			}
		}
		List<SearchInvoice> listInvoice = jdbcTemplate.query(sql, args, new RowMapper<SearchInvoice>() {

			@Override
			public SearchInvoice mapRow(ResultSet rs, int rowNum) throws SQLException {
				SearchInvoice invoice = new SearchInvoice();

				invoice.setVendorID(rs.getString("VEND_ID"));
				invoice.setInvoiceID(rs.getString("VEND_INV_NBR"));
				invoice.setInvoiceType(rs.getString("INV_TYP_CD"));
				invoice.setInvoiceStatus(rs.getTimestamp("INV_TS"));
				invoice.setInvoiceAmt(rs.getString("INV_AMT"));
				invoice.setInvoiceAmt(rs.getString("INV_AMT"));

				return invoice;
			}

		});
		return listInvoice;
	}

	@Override
	public List<SearchInvoice> listVendor() {
		String sql = Constants.SQL_LIST_VENDOR;
		List<SearchInvoice> listInvoice = jdbcTemplate.query(sql, new RowMapper<SearchInvoice>() {
			@Override
			public SearchInvoice mapRow(ResultSet rs, int rowNum) throws SQLException {
				SearchInvoice invoiceMatch = new SearchInvoice();

				invoiceMatch.setVendorID(rs.getString("VEND_ID"));

				return invoiceMatch;
			}

		});
		return listInvoice;
	}

	@Override
	public List<SearchInvoice> listInvoice() {
		String sql = Constants.SQL_LIST_INVOICE;
		List<SearchInvoice> listInvoice = jdbcTemplate.query(sql, new RowMapper<SearchInvoice>() {
			@Override
			public SearchInvoice mapRow(ResultSet rs, int rowNum) throws SQLException {
				SearchInvoice invoiceMatch = new SearchInvoice();

				invoiceMatch.setInvoiceID(rs.getString("VEND_INV_NBR"));

				return invoiceMatch;
			}

		});
		return listInvoice;
	}

	@Override
	public List<SearchInvoice> listTracking() {
		String sql = Constants.SQL_LIST_TRACKING;
		List<SearchInvoice> listInvoice = jdbcTemplate.query(sql, new RowMapper<SearchInvoice>() {
			@Override
			public SearchInvoice mapRow(ResultSet rs, int rowNum) throws SQLException {
				SearchInvoice invoiceMatch = new SearchInvoice();

				invoiceMatch.setTrackingID(rs.getString("VEND_TRKG_ID"));

				return invoiceMatch;
			}

		});
		return listInvoice;
	}

	@Override
	public List<SearchInvoice> listOrder() {
		String sql = Constants.SQL_LIST_ORDER;
		List<SearchInvoice> listInvoice = jdbcTemplate.query(sql, new RowMapper<SearchInvoice>() {
			@Override
			public SearchInvoice mapRow(ResultSet rs, int rowNum) throws SQLException {
				SearchInvoice invoiceMatch = new SearchInvoice();

				invoiceMatch.setOrderID(rs.getString("VEND_ORD_HDR_ID"));

				return invoiceMatch;
			}

		});
		return listInvoice;
	}

}
