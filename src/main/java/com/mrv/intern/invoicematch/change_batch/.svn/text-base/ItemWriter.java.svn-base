package com.mrv.intern.invoicematch.change_batch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mrv.intern.invoicematch.model.VendInvHdrVO;
import com.mrv.intern.invoicematch.model.VendInvPoVO;
import com.mrv.intern.invoicematch.service.InsertVoService;
import com.mrv.intern.invoicematch.utils.Helper;

public class ItemWriter implements org.springframework.batch.item.ItemWriter<VendInvHdrVO> {
	@Autowired
	private InsertVoService insertVoService;

	@Override
	public void write(List<? extends VendInvHdrVO> items) throws Exception {
		// TODO Auto-generated method stub
		/**
		  * insert vào DB tương ứng với model
		  * @author Khanh Tran
		  * 
		  */
		for (VendInvHdrVO vendHdr : items) {
			insertVoService.insertHdrVo(vendHdr);
			if ("COGS".equals(Helper.trim(vendHdr.getInvTypCd()))) {
				insertVoService.insertPoVo(vendHdr.getLstVendInvPoVO());
				for (VendInvPoVO vendPo : vendHdr.getLstVendInvPoVO()) {
					insertVoService.insertPoItmVo(vendPo.getLstVendInvPoLinItmVO());
				}
			} else {
				insertVoService.insertFrtItmPo(vendHdr.getLstVendInvFrtLinItmVO());
			}
			
		}
	}
}
