package com.mrv.intern.invoicematch.batch;

import com.mrv.intern.invoicematch.model.StgVendInvHdrVO;

public class ItemProcessorhdr implements org.springframework.batch.item.ItemProcessor<StgVendInvHdrVO, StgVendInvHdrVO> {
	/**
	 * processor hdr
	 * @return StgVendInvHdrVO
	 * @author Xuan Vu
	 * 
	 */
	@Override
	public StgVendInvHdrVO process(StgVendInvHdrVO item) throws Exception {
		return item;
	}

}
