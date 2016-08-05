package com.mrv.intern.invoicematch.batch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mrv.intern.invoicematch.model.VendInvFrtLinItmVO;
import com.mrv.intern.invoicematch.model.VendInvHdrVO;
import com.mrv.intern.invoicematch.model.VendInvPoLinItmVO;
import com.mrv.intern.invoicematch.model.VendInvPoVO;
import com.mrv.intern.invoicematch.service.ImportInvoiceData;
import com.mrv.intern.invoicematch.utils.Constants;

@Repository
public class SelectFromVendInvHDRItemProcess
		implements org.springframework.batch.item.ItemProcessor<VendInvHdrVO, VendInvHdrVO> {
	@Autowired
	private ImportInvoiceData importInvoiceData;

	@Override
	public VendInvHdrVO process(VendInvHdrVO item) throws Exception {
		String invTyp = item.getInvTypCd();
		if (invTyp.equals(Constants.KEY_COGS)) {
			List<VendInvPoVO> lst = importInvoiceData.getListVendInvPoByVendInvNbr(item.getVendInvNbr());
			if (lst.size() != 0) {
				for (VendInvPoVO vendInvPoVO : lst) {
					List<VendInvPoLinItmVO> lstItem = importInvoiceData.getListVendInvPoLinItmByOrdHdrIdAndVendInvNbr(
							vendInvPoVO.getVendOrdHdrId(), vendInvPoVO.getVendInvNbr());
					vendInvPoVO.setLstVendInvPoLinItmVO(lstItem);
				}
			}
			item.setLstVendInvPoVO(lst);
		} else {
			List<VendInvFrtLinItmVO> lstFrtItem = importInvoiceData
					.getListVendInvFrtLinItmByVendInvNbr(item.getVendInvNbr());
			item.setLstVendInvFrtLinItmVO(lstFrtItem);
		}
		return item;
	}

}
