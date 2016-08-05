package com.mrv.intern.invoicematch.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mrv.intern.invoicematch.model.VendInvFrtLinItmVO;
import com.mrv.intern.invoicematch.model.VendInvHdrVO;
import com.mrv.intern.invoicematch.model.VendInvPoLinItmVO;
import com.mrv.intern.invoicematch.model.VendInvPoVO;

public interface InsertToMapperDAO {
public void insertHdrVo(VendInvHdrVO invHdrVOs);
public void insertPoVo(final List<VendInvPoVO> invPoVOs);
public void insertPoItmVo(final List<VendInvPoLinItmVO> invPoLinItmVOs);
public void insertFrtItmPo(final List<VendInvFrtLinItmVO> invFrtLinItmVOs);

}
