package com.mrv.intern.invoicematch.change_batch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mrv.intern.invoicematch.model.VendInvFrtLinItmVO;
import com.mrv.intern.invoicematch.model.VendInvHdrVO;
import com.mrv.intern.invoicematch.model.VendInvPoLinItmVO;
import com.mrv.intern.invoicematch.model.VendInvPoVO;
import com.mrv.intern.invoicematch.service.ImportInvoiceData;

public class ItemProcessor implements org.springframework.batch.item.ItemProcessor<VendInvHdrVO, VendInvHdrVO> {
	@Autowired
	private ImportInvoiceData importInvoiceData;

	@Override
	public VendInvHdrVO process(VendInvHdrVO item) throws Exception {
		// lay vendor id -> get attr 6 -> invoice tpye
		// get detail theo cac type do
		/**
		  * set vao list trong model tương ứng
		  * @author Khanh Tran
		  * 
		  */
		String invTyp = importInvoiceData.getInvoiceTypeByVendorId(item.getVendId());
		if (invTyp.equals("COGS")) {
			List<VendInvPoVO> lst = importInvoiceData.getListOrderByInvoiceId(item.getVendInvNbr());
			if (lst != null) {
				for (VendInvPoVO vendInvPoVO : lst) {
					List<VendInvPoLinItmVO> lstItem = importInvoiceData.getListItemInOrder(item.getVendInvNbr(),
							vendInvPoVO.getOrdHdrId());
					vendInvPoVO.setLstVendInvPoLinItmVO(lstItem);
				}

			}

			item.setLstVendInvPoVO(lst);
		} else {
			List<VendInvFrtLinItmVO> lstFrtItem = importInvoiceData.getListFrtItemByInvoiceId(item.getVendInvNbr());
			item.setLstVendInvFrtLinItmVO(lstFrtItem);
		}

		item.setInvTypCd(invTyp);

		return item;
	}

}
