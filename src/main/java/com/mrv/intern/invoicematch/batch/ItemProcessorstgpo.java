package com.mrv.intern.invoicematch.batch;

import com.mrv.intern.invoicematch.model.StgVendInvPoVO;

public class ItemProcessorstgpo implements org.springframework.batch.item.ItemProcessor<StgVendInvPoVO, StgVendInvPoVO> {
	/**
	 * processor stgpo
	 * @return StgVendInvPoVO
	 * @author Xuan Vu
	 * 
	 */
	@Override
	public StgVendInvPoVO process(StgVendInvPoVO item) throws Exception {
		return item;
	}

}
